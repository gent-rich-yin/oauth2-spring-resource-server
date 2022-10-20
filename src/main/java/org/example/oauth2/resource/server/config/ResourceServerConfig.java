package org.example.oauth2.resource.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.mvcMatcher("/**")
            .authorizeRequests()
                .anyRequest().authenticated()
//            .mvcMatchers("/articles")
//            .access("hasAuthority('SCOPE_articles.read')")
//            .mvcMatchers("/token")
//            .access("hasAuthority('SCOPE_openid')")
//            .mvcMatchers("/greeting")
//            .access("hasAuthority('SCOPE_openid')")
            .and()
            .oauth2ResourceServer()
            .jwt();
        return http.build();
    }
}