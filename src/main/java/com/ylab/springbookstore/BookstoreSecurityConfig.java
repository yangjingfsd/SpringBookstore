package com.ylab.springbookstore;

import javax.sql.DataSource;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BookstoreSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager(){

    //     UserDetails john = User.builder()
    //         .username("john")
    //         .password("{noop}test123")
    //         .roles("EMPLOYEE")
    //         .build();

    //         UserDetails susan = User.builder()
    //         .username("susan")
    //         .password("{noop}test123")
    //         .roles("EMPLOYEE", "MANAGER", "ADMIN")
    //         .build();

    //         UserDetails mary = User.builder()
    //         .username("mary")
    //         .password("{noop}test123")
    //         .roles("EMPLOYEE", "MANAGER")
    //         .build();

    //     return new InMemoryUserDetailsManager(john, mary, susan);
    // }

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

    http.authorizeHttpRequests(configurer -> configurer
    .requestMatchers("/").permitAll()
    .requestMatchers("/list").permitAll()
    .requestMatchers("/add/**").hasRole("STAFF")
    .requestMatchers("/update/**").hasRole("STAFF")
    .requestMatchers("/delete/**").hasRole("STAFF")
    .requestMatchers("/purchase/**").hasRole("CUSTOM")
    .requestMatchers("/actuator/**").hasRole("ADMIN")
    .anyRequest().authenticated())
    .formLogin(form -> form
    .loginPage("/login")
    .loginProcessingUrl("/authUser")
    .permitAll())
    .logout(logout -> logout.permitAll())
    .exceptionHandling(configurer -> configurer.accessDeniedPage("/accessdenied"));

    return http.build();

}    

}
