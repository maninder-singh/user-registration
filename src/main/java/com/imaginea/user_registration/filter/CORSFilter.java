package com.imaginea.user_registration.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.apache.log4j.Logger;

/**
 * <h1> CORSFilter.class</h1>
 * This class is to filter response by implementing ContainerResponseFilter interface 
 * 
 * @author maninders
 */
public class CORSFilter implements ContainerResponseFilter {

    static final Logger log = Logger.getLogger(CORSFilter.class);
    
    /** 
     * This method, filter will only be executed for a response for which the request has been 
     * matched to a resource or sub-resource method.
     * 
     * @param containerRequest 
     * @param containerResponse
     * @return ContainerResponse
     */
    @Override
    public ContainerResponse filter(ContainerRequest containerRequest, ContainerResponse containerResponse) {

        log.info("Inside ContainerResponse functions");
        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        containerResponse.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        log.info("containerResponse : " + containerResponse.toString());
        log.info("containerResponse.getHttpHeaders : " + containerResponse.getHttpHeaders().toString());
        return containerResponse;
    }
}
