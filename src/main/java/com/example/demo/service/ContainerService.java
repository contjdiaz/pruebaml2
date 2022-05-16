package com.example.demo.service;

import com.example.demo.Json;
import com.example.demo.entity.ContainerPO;
import com.example.demo.entity.RoutePO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContainerService {

    private List<ContainerPO> containers;
    private String costodeTransportar ="{\n" +
            "\"route\":\"Ruta_Reto\",\n" +
            "\"container\":[\n" +
            "   {\n" +
            "   \"name\":\"C1\",\n" +
            "   \"transportCost\": \"7630\",\n" +
            "   \"containerPrice\": \"327\"\n" +
            "   },\n" +
            "   \n" +
            "   {\n" +
            "   \"name\":\"C2\",\n" +
            "   \"transportCost\": \"9495\",\n" +
            "   \"containerPrice\": \"422\"\n" +
            "   },\n" +
            "   \n" +
            "   {\n" +
            "   \"name\":\"C3\",\n" +
            "   \"transportCost\": \"6025\",\n" +
            "   \"containerPrice\": \"241\"\n" +
            "   },\n" +
            "   \n" +
            "   {\n" +
            "   \"name\":\"C4\",\n" +
            "   \"transportCost\": \"12680\",\n" +
            "   \"containerPrice\": \"634\"\n" +
            "   },\n" +
            "   \n" +
            "   {\n" +
            "   \"name\":\"C5\",\n" +
            "   \"transportCost\": \"14240\",\n" +
            "   \"containerPrice\": \"712\"\n" +
            "   },\n" +
            "   \n" +
            "   {\n" +
            "   \"name\":\"C6\",\n" +
            "   \"transportCost\": \"6160\",\n" +
            "   \"containerPrice\": \"308\"\n" +
            "   },\n" +
            "   \n" +
            "   {\n" +
            "   \"name\":\"C7\",\n" +
            "   \"transportCost\": \"13224\",\n" +
            "   \"containerPrice\": \"551\"\n" +
            "   }\n" +
            "]\n" +
            "}";

    public ContainerService(List<ContainerPO> containers) {
        this.containers = containers;
    }

    public List<ContainerPO> getContainers() throws IOException  {
        JsonNode node = Json.parce(costodeTransportar);
        RoutePO pojo = Json.fromJson(node, RoutePO.class);
        List<ContainerPO> arrayContainer = pojo.getContainer();
        List<ContainerPO> containerPOList= new ArrayList<>();

        for(ContainerPO cont : arrayContainer){
            containerPOList.add(new ContainerPO(cont.getName(),cont.getTransportCost(),cont.getContainerPrice()));
        }
        return  containerPOList;
    }


}
