package com.mycompany.springbasic.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	//Sorting an array using bubble sort
	//search the array
	//return the result
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}
	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}
	/*
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm =sortAlgorithm;
		
	} */
	public int binarySearch (int[] numbers, int numberToSearchFor) {
		//BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumber = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		return 3;
	}

}
