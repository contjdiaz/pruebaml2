package com.example.demo.entity;

public class ContainerPO {

    private String name;
    private Double transportCost;
    private Double containerPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(Double transportCost) {
        this.transportCost = transportCost;
    }

    public Double getContainerPrice() {
        return containerPrice;
    }

    public void setContainerPrice(Double containerPrice) {
        this.containerPrice = containerPrice;
    }

    public ContainerPO()
    {   super();  }

    public ContainerPO (String name,Double transportCost,Double containerPrice) {
        this.name = name;
        this.transportCost = transportCost;
        this.containerPrice = containerPrice;
    }

}
