package sort;

import java.util.Arrays;

public class StraightInsertionSort implements Sort {
	public void sort(int[] array){
		int tmp, j;
		for(int i = 1; i < array.length; ++i){
			j = i;
			tmp = array[j];
			while(j > 0 && tmp < array[j - 1]){
				array[j] = array[j - 1];
				--j;
			}
			array[j] = tmp;
		}
	}
	
	
	public static void main(String[] args){
		int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
		System.out.println(Arrays.toString(array));
		new StraightInsertionSort().sort(array);
		System.out.println(Arrays.toString(array));
	}
}
