package com.lab.algo2;

import java.util.Scanner;

public class MakePayment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations:");
		int size = sc.nextInt();
		
		System.out.println("Enter the currency denominations value:");
		int[] currencyValue = new int[size];
		for(int i = 0; i < size; i++) {
			currencyValue[i] = sc.nextInt();
		}
		
		sortCurrency(currencyValue, 0, size-1);
		
		System.out.println("Enter the amount you want to pay:");
		int amount = sc.nextInt();
		
		int[] notesCount = new int[size];
		for(int i = 0; i < size && amount > 0; i++) {
			notesCount[i] = amount / currencyValue[i];
			amount -= (currencyValue[i] * notesCount[i]);
		}
		
		System.out.println("Your payment approach in order to give minimum number of notes will be:");
		for(int i = 0; i < size; i++) {
			if(notesCount[i] != 0) {
				System.out.println(currencyValue[i] + " : " + notesCount[i]);			
			}
		}
		
		sc.close();
	}
	
	public static void sortCurrency(int array[], int l, int h) {
		if(l < h) {
			int p = partition(array, l, h);
			sortCurrency(array, l, p);
			sortCurrency(array, p+1, h);
		}
	}
	
	public static int partition(int array[], int l, int h) {
		
		int pivot = array[l];
		int i = l-1, j = h+1;
		
		while(true)
		{
			do {
				i++;
			}while(array[i] > pivot);
			
			do {
				j--;
			}while(array[j] < pivot);
			
			if(i >= j) {
				return j;
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	
}
