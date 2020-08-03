package org.astashonok.assessmentsystem.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy;

    public CustomSuccessHandler() {
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = "/choose/role";
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

//    private String determineTargetUrl(Authentication authentication) {
//        String url;
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Set<String> roles = new HashSet<>();
//
//        for (GrantedAuthority a : authorities) {
//            roles.add(a.getAuthority());
//        }
//
//        if (isTutor(roles)) {
//            url = "/tutor";
//        } else if (isAdmin(roles)) {
//            url = "/admin";
//        } else if (isUser(roles)) {
//            url = "/user";
//        } else {
//            url = "/access-denied";
//        }
//
//        return url;
//    }

    private boolean isUser(Set<String> roles) {
        return roles.contains("ROLE_USER");
    }

    private boolean isAdmin(Set<String> roles) {
        return roles.contains("ROLE_ADMIN");
    }

    private boolean isTutor(Set<String> roles) {
        return roles.contains("ROLE_TUTOR");
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return this.redirectStrategy;
    }
}
