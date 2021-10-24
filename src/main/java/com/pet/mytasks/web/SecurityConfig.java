package com.pet.mytasks.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                //.antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**/*.css", "/**/*.js", "/**/*.scss", "/**/*.ico").permitAll()
                .antMatchers(HttpMethod.PUT).permitAll()
                .anyRequest().permitAll()
        .and()
                .formLogin()
        .and()
                .logout()
                .permitAll();
    }

    @Bean
    public UserDetailsService user(){
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2y$12$vorCQV44fteaPYVzEeXE4.MfeasNH0UjEarymGUyQEn480FoOc.Va")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
