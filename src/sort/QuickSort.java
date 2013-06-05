package sort;

import java.util.Arrays;


public class QuickSort extends AbstractQuickSort {
	protected int partition(int[] array, int low, int high){
		int pivot = array[low];
		
		while(low < high){
			while(low < high && array[high] >= pivot){
				--high;
			}
			array[low] = array[high];
			
			while(low < high && array[low] <= pivot){
				++low;
			}
			array[high] = array[low];
		}
		array[low] = pivot;
		
		return low;
	}

	
	public static void main(String[] args){
		int[] array = {9, 38, 65, 97, 76, 13, 27, 49};
		System.out.println(Arrays.toString(array));
		new QuickSort().sort(array);
		System.out.println(Arrays.toString(array));
	}

}
