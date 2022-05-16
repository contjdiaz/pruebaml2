package com.example.demo.controller;

import com.example.demo.entity.ContainerPO;
import com.example.demo.service.ContainerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

@RestController
public class ContainerController {
    
    private final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @RequestMapping("/")
    public String getHelloWorld(){
        return "Hello World";
    }
    
    @GetMapping("/containers")
    public List<ContainerPO> all() throws IOException {return containerService.getContainers();}


}
