package org.example.oauth2.resource.server.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ArticlesController {

    @GetMapping("/articles")
    @PreAuthorize("hasAuthority('SCOPE_articles.read')")
    public String[] getArticles() {
        return new String[]{"Article 1", "Article 2", "Article 3"};
    }

    @GetMapping("/token")
    @PreAuthorize("hasAuthority('SCOPE_openid')")
    public Jwt token(@AuthenticationPrincipal Jwt jwt) {
        return jwt;
    }

    @GetMapping("/greeting")
    @PreAuthorize("hasAuthority('SCOPE_openid')")
    public String greeting(@AuthenticationPrincipal Jwt jwt) {
        return "Hello " + jwt.getSubject();
    }
}