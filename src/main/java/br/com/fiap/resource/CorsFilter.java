package br.com.fiap.resource;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Controll-Allow-Headers", "origin, content-type accept, authorization");
        response.getHeaders().add("Access-Controll-Allow-Credrencials", "true");
        response.getHeaders().add("Access-Controll-Allow-Methods", "GET, POST, PUT, DELETE, OPTION, HEAD");
    }
}