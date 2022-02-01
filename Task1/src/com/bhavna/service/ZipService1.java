package com.bhavna.service;

import java.util.HashMap;

import com.bhavna.Entity.Area;

public class ZipService1 implements ZipLookup {

	@Override
	public void getDetails(long zipCode) {
		for(long key:hash.keySet()) {
			if(key==zipCode) {
				System.out.println (hash.get(key));
			}
			
		}
		
		
	}
	
	static HashMap<Long, Area> hash;
	static {
		hash=new HashMap<>();
		hash.put(522006L, new Area("India", "AP", 522006));
		hash.put(522002L, new Area("India", "TS", 522002));
		hash.put(522111L, new Area("India", "MP", 522111));
		hash.put(511000L, new Area("India", "MH", 511000));
		
	}
	
	
	
	
	

}
