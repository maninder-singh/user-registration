package com.imaginea.user_registration.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * Created by maninders on 28/8/15.
 */
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public ContainerResponse filter(ContainerRequest containerRequest, ContainerResponse containerResponse) {

        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        return containerResponse;
    }
}
