package sort;

import java.util.Arrays;


public class QuickSort implements Sort {
	private int partition(int[] array, int low, int high){
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
	
	private void quickSort(int[] array, int low, int high){
		if(low < high){
			int pivotLoc = partition(array, low, high);
			quickSort(array, low, pivotLoc - 1);
			quickSort(array, pivotLoc + 1, high);
		}
	}

	@Override
	public void sort(int[] array) {
		// TODO Auto-generated method stub
		quickSort(array, 0, array.length - 1);
	}
	
	public static void main(String[] args){
		int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
		System.out.println(Arrays.toString(array));
		new QuickSort().sort(array);
		System.out.println(Arrays.toString(array));
	}

}
