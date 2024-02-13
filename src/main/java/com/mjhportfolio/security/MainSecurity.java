
package com.mjhportfolio.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class MainSecurity {


    

 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
             .csrf(csrf -> csrf.disable())
             .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
             .authorizeHttpRequests((authorize) -> authorize
             .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.OPTIONS,"/email/send")).permitAll()
             .requestMatchers(AntPathRequestMatcher.antMatcher("/email/send")).permitAll()
             .anyRequest().authenticated()
             );
            

            return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        System.out.println("Setting up CORS configuration...");
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("POST", "OPTIONS"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}

