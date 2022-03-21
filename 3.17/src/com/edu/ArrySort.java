package com.edu;

public class ArrySort {
	public static void main(String[] args) {
		// int[] intAry => {34, 25, 48, 12};
//		intAry[0] -> intAry[0+1]; // 34 25
		int[] intAry = { 34, 25, 48, 12 };
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[0] > intAry[1]) {
				int temp = intAry[0];
				intAry[0] = intAry[1];
				intAry[1] = temp;
			}
			if (intAry[1] > intAry[2]) {
				int temp = intAry[1];
				intAry[1] = intAry[2];
				intAry[2] = temp;
			}
			if (intAry[2] > intAry[3]) {
				int temp = intAry[2];
				intAry[2] = intAry[3];
				intAry[3] = temp;
			}
			if( intAry[0] > intAry[2]) {
				int temp = intAry[0];
				intAry[0] = intAry[2];
				intAry[2] = temp;
			}

			System.out.println(intAry[i]);
		}

	}
}
