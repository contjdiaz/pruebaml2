package com.example.demo.entity;

import java.util.List;

public class RoutePO {

    private String route;
    private List<ContainerPO> container;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public List<ContainerPO> getContainer() {
        return container;
    }

    public void setContainer(List<ContainerPO> container) {
        this.container = container;
    }

    public RoutePO()
    {   super();  }


    public RoutePO(String route,List<ContainerPO> container){
        this.route=route;
        this.container=container;
    }

}
