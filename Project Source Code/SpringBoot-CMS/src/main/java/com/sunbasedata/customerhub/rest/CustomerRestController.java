package com.sunbasedata.customerhub.rest;
import com.sunbasedata.customerhub.entity.Customer;
import com.sunbasedata.customerhub.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class CustomerRestController {
    private CustomerService service;

    public CustomerRestController(CustomerService service) {
        this.service = service;
    }



    @GetMapping("/")
    public String getAllCustomer(
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "5") int size,
            @RequestParam(name="sortBy",defaultValue = "id") String sortBy,
            @RequestParam(name="sortOrder",defaultValue = "asc") String sortOrder,
            Model theModel) {
        Page<Customer> customers = service.getAllCustomer(page, size, sortBy, sortOrder);
        theModel.addAttribute("customers", customers);
        theModel.addAttribute("page", page);
        theModel.addAttribute("size", size);
        theModel.addAttribute("sortBy", sortBy);
        theModel.addAttribute("sortOrder", sortOrder);
        return "customers/listcustomers";
    }
    @GetMapping("/addCustomerForm")
    public String addcustomerform(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer_to_save",theCustomer);
        theModel.addAttribute("update", false);
        return "customers/addcustomerform";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("customer_id") int updId, Model theModel){
        Customer theCustomer = service.findById(updId);
        theModel.addAttribute("customer_to_save",theCustomer);
        theModel.addAttribute("update", true);
        return "customers/addcustomerform";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer_to_save") Customer theCustomer){
        service.save(theCustomer);
        return "redirect:/";

    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customer_id")  int customerID){
        Customer theCustomer = service.findById(customerID);
        if(theCustomer== null){
            throw new RuntimeException("CUSTOMER ID NOT FOUND : "+customerID);
        }
        else{
            service.delete(customerID);
        }
        return "redirect:/";

    }

    @GetMapping("/find")
    public String getCustomer(@RequestParam(name="findID") int findID, Model theModel){
        Pageable pageable = PageRequest.of(0, 1);
        Page<Customer> theCustomers = service.findById(findID, pageable);
        theModel.addAttribute("page", 0);
        theModel.addAttribute("size", 5);
        theModel.addAttribute("customers",theCustomers);
        return "customers/listcustomers";
    }




}
