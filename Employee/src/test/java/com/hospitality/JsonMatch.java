package com.hospitality;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMatch {

	public static void main(String[] args) throws JsonProcessingException {
		List<String> list1 = List.of("[{'internal1':{'value':'true','desc':'All'},'internal2':{'value':'true','desc':'All'}}]");
        List<String> list2 = List.of("[{'internal1':{'value':'false','desc':'All'},'internal2':{'value':'true','desc':'None'}}]");
        List<String> list3 = List.of("[{'internal1':{'value':'false','desc':'All'},'internal2':{'value':'true','desc':'None'}}]");

        ObjectMapper mapper = new ObjectMapper();
        String str1 = mapper.writeValueAsString(list1);
        String str2 = mapper.writeValueAsString(list2);
        String str3 = mapper.writeValueAsString(list2);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        if (str1.equals(str2)) {
        	System.out.println("Matched");
        }
        if (str2.equals(str3)) {
        	System.out.println("str2 and str3 are Matched");
        }
	}

}
