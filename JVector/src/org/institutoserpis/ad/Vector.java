package org.institutoserpis.ad;

import java.util.Random;

public class Vector {

	public static void main(String[] args) {
		int[] vector = new int [] {11, 24, 89, 25, 19};
		int numMenor = min(vector);
		System.out.println("El número menos del vector es: "+numMenor);
	}

	public static int min(int[] v){
		 int numMenor = v[0];
//		 for (int i=1; i<v.length; i++){
//			 if (v[i]<numMenor){
//				 numMenor = v[i];
//			 }
//		 }
		 for (int item : v){
			 if (item < numMenor){
				 numMenor = item;
			 }
		 }
		return numMenor;
	}
}