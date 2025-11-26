package com.example.Spring_Boot_Start_Project.config;

import com.example.Spring_Boot_Start_Project.config.filters.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    public UserDetailsManager userDetailsManager (DataSource dataSource) {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        return userDetailsManager;
//    }


//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/students").hasRole("USER");
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

    private AuthFilter authFilter;

    @Autowired
    public SecurityConfig(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        http.authorizeHttpRequests(
                api -> api//.requestMatchers("/eraa-soft**").hasRole("ADMIN")
                .requestMatchers("/auth/**").permitAll().anyRequest().authenticated()
                //.requestMatchers(HttpMethod.GET, "/user").permitAll()//.hasAnyRole("ADMIN", "USER")
        );
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//        http.httpBasic(Customizer.withDefaults());
        http.httpBasic(AbstractHttpConfigurer::disable);
        return http.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails1 =
//                User.withUsername("ahmed").password("{noop}ahmed123").build();
//        UserDetails userDetails2 =
//                User.withUsername("eslam").password("{noop}eslam123").build();
//        UserDetails userDetails3 =
//                User.withUsername("mona").password("{noop}mona123").build();
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails1 =
//                User.withUsername("ahmed").password("{bcrypt}$2a$12$ixOCwlKFbsG0j5zw9GvFuuQfRMKeCB3fY09ePl1etyBxITZ2MztZK")
//                        .roles("USER", "ADMIN").build();
//        UserDetails userDetails2 =
//                User.withUsername("eslam").password("{bcrypt}$2a$12$8AgErbwdNPQTPRJ8bL2kmul8hFRn.GrggPkAb4Lxj63hSi3bT7yVS")
//                        .roles("USER").build();
//        UserDetails userDetails3 =
//                User.withUsername("mona").password("{bcrypt}$2a$12$c8x3FNavgfJT.89TeTqjbOqvlGeBe8iHj2NVBAgQZaRzDRtqwSz7W")
//                        .roles("USER", "ADMIN", "MANGER").build();
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
