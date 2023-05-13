//package com.controller.service.configuracion;
//
//import java.util.Arrays;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import static org.springframework.security.config.Customizer.withDefaults;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class CorsConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(withDefaults())
//                .csrf().disable()
//                .authorizeHttpRequests(requests
//                        -> requests
//                        .requestMatchers("/**").permitAll()
//                        .anyRequest().permitAll()
//                );
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration confg = new CorsConfiguration();
//        confg.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
//        confg.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
//        confg.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", confg);
//        return source;
//    }
//}
