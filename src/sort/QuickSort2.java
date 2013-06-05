package sort;

import java.util.Arrays;

public class QuickSort2 extends AbstractQuickSort {

	private void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	@Override
	protected int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;
		for(int j = low; j < high; ++j){
			if(array[j] <= pivot){
				++i;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		//System.out.println(Arrays.toString(array));
		return i + 1;
	}
	
	public static void main(String[] args){
		//int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
		int[] array = { 1000, 0, 6, 5, 4, 3, 2, 1, 7, 156, 44, 23, 123, 11, 5 };
		System.out.println(Arrays.toString(array));
		new QuickSort2().sort(array);
		System.out.println(Arrays.toString(array));
	}

}
