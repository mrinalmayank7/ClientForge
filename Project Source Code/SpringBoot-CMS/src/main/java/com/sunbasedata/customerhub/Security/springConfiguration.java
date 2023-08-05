package com.sunbasedata.customerhub.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class springConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        theUserDetailsManager
                .setUsersByUsernameQuery("select email, password, active from users where email=?");

        theUserDetailsManager
                .setAuthoritiesByUsernameQuery("select email, role from roles where email=?");
        return theUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET, "/").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/find").hasRole("EMPLOYEE")

                                .requestMatchers(HttpMethod.GET, "/addCustomerForm").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.GET, "/updateForm").hasRole("MANAGER")

                                .requestMatchers(HttpMethod.GET, "/deleteCustomer").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateuser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/accessdenied"))

        ;
        return http.build();
    }

}
