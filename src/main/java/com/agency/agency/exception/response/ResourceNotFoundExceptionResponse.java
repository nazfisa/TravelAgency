package com.agency.agency.exception.response;
/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
public class ResourceNotFoundExceptionResponse {
    private String resource;

    public ResourceNotFoundExceptionResponse(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
