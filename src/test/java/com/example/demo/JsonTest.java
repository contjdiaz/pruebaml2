package com.example.demo;

import com.example.demo.entity.ContainerPO;
import com.example.demo.entity.RoutePO;
import com.example.demo.testObjects.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonTest {

    static HashSet<ArrayList<Integer>> result = new HashSet<>();
    String containerSplit[]={};
    private List<ContainerPO> containers;
    ObjectMapper mapper = new ObjectMapper();

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


    @Test
    void cargadeData() throws IOException {
        JsonNode node = Json.parce(costodeTransportar);
        RoutePO pojo = Json.fromJson(node, RoutePO.class);
        int[] intArray= {308, 327, 551, 634, 712};
        ArrayList<Integer> integerArray=(ArrayList<Integer>) Arrays.stream(intArray).boxed().collect(Collectors.toList());

        for (ContainerPO containerPO: pojo.getContainer()) {
            for(int i=0; i<intArray.length; i++) {
                if(integerArray.get(i).equals(containerPO.getContainerPrice().intValue())) {
                    System.out.println("El container es " + containerPO.getName());
                }
            }
        }
    }

    /*
    public List<ContainerPO> getContainers(){
        List<ContainerPO> containerPOList= new ArrayList<>();
        for(int i=0; i< containerPOList.size(); i++){
            containerPOList.add((ContainerPO) containers);
        }
        return  containerPOList;
    }

     */
    @Test
    void cargadeData2() throws IOException {
        JsonNode node = Json.parce(costodeTransportar);
        RoutePO pojo = Json.fromJson(node, RoutePO.class);
        //List
        for (ContainerPO containerPO: pojo.getContainer()) {
            System.out.println("El container es " + containerPO.getName());

        }

    }

    @Test
    void principal() throws IOException, NumberFormatException {
        JsonNode node = Json.parce(costodeTransportar);
        RoutePO pojo = Json.fromJson(node, RoutePO.class);
        ArrayList<Integer> price = new ArrayList<>();
        int search=1610;

        for(ContainerPO cP: pojo.getContainer()){
            price.add(cP.getContainerPrice().intValue());
        }

        if( price.stream().noneMatch(num ->num<0) && price.stream().reduce(0, Integer::sum)< search
        ){
            System.out.println("No Hay combinaciones");
        }
        else if(price.stream().noneMatch(num ->num>0) && price.stream().reduce(0,Integer::sum)> search
        )       {
            System.out.println("No Hay combinaciones");
        }
        else{
            getNCombinations(price, 0, search, search);

            List<Integer> list = new ArrayList<>();
            Stream<ArrayList<Integer>> streamrs = result.stream();
            streamrs.forEach(list::addAll);

            for (ContainerPO containerPO: pojo.getContainer()) {
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).equals(containerPO.getContainerPrice().intValue())) {
                        System.out.println("Container : " + containerPO.getName());
                        System.out.println("Transport Cost : " + containerPO.getTransportCost());
                        System.out.println("Price:  " + containerPO.getContainerPrice());
                    }
                }
            }

        }

    }



    public static ArrayList<Integer> getNCombinations(ArrayList<Integer> nums, int idx, int search, int abs) {

        ArrayList<Integer> combinations = new ArrayList<>(2);

        int temp2 = nums.remove(idx);
        int min=1607;
        for (int i = 0; i < nums.size(); ++i) {
            combinations = getNCombinations(nums, i, search - temp2, abs);
            combinations.add(nums.get(i));
            combinations.add(temp2);
            Collections.sort(combinations);
            if (combinations.stream().distinct().reduce(0, Integer::sum) > min && combinations.stream().distinct().reduce(0, Integer::sum) < abs)
                result.add(combinations.stream().distinct().collect(Collectors.toCollection( ArrayList::new )));
        }

        nums.add(idx, temp2);

        if (++idx < nums.size()) {
            getNCombinations(nums, idx, search, abs);
        }

        return combinations;
    }
}
