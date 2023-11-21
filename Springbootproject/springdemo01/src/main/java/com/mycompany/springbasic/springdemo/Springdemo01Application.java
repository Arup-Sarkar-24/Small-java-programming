package com.mycompany.springbasic.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springdemo01Application {

	public static void main(String[] args) {
		//BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new QuickSortAlgorithm());
		//implements SortAlgorithm int result = binarySearchImpl.binarySearch(new int[] {12,2,4},5);  
		//System.out.println(result);
		ApplicationContext applicationContext= SpringApplication.run(Springdemo01Application.class, args);
		BinarySearchImpl binarySearchImpl = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearchImpl.binarySearch(new int[] {12,2,4},5);
		System.out.println(result);
	}

}
