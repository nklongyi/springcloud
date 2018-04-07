package com.nklongyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by longyi on 2018-04-01.
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
//        Thread.sleep(5000);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
