package com.bhavna.Main;

import java.util.Scanner;

import com.bhavna.service.ZipLookup;
import com.bhavna.service.ZipService2;

public class MainClass {

	public static void main(String[] args) {
		ZipService2 z2=new ZipService2();
		
		ZipLookup z = z2.getImplementation();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Zip Code:");
		long zip = scanner.nextLong();
		z.getDetails(zip);
		
	}

}
