package com.test.iot;

import java.util.HashMap;

import com.google.gson.Gson;

public class json {

	public static void main(String[] args) {
		
		String json = "{\"id\":\"test\"}";
		Gson gs = new Gson();
		
		HashMap hm = gs.fromJson(json, HashMap.class);
		System.out.println(json);
		System.out.println(hm);
	}
	
}
