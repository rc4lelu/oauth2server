package com.rc4.authorizationserver.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class DynamicRedirectUriFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestedRedirectUri = request.getParameter("redirect_uri");
        System.out.println(requestedRedirectUri);
        if (requestedRedirectUri != null && isValidRedirectUri(requestedRedirectUri)) {
            // Ici, vous pouvez accepter dynamiquement l'URI de redirection
            // Par exemple, ajouter cette URI dans la réponse ou la base de données temporairement
        } else {
            // Vous pouvez choisir de rejeter ou gérer l'erreur autrement
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Redirect URI");
            return;
        }

        filterChain.doFilter(request, response);
    }

    // Ajoutez ici une logique de validation personnalisée pour les URI
    private boolean isValidRedirectUri(String redirectUri) {
        // Exemple : Autorisez les URI venant de certains domaines seulement
        return redirectUri.startsWith("http://localhost") || redirectUri.startsWith("https://trusted-domain.com");
    }
}
