package com.tzsw.config;

import com.tzsw.service.WebServiceAll;
import org.springframework.context.annotation.Configuration;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 15:38 2018/11/15
 */

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private WebServiceAll service;

    @SuppressWarnings(value = "all")
    @Bean
    public ServletRegistrationBean disServlet() {

        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }

    /*jax-ws*/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.publish("/businessWebService");
        return endpoint;
    }
}
