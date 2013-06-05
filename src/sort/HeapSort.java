package sort;

import java.util.Arrays;

public class HeapSort implements Sort {

	@Override
	public void sort(int[] array) {
		for(int i = (array.length >> 1) - 1; i >=0; --i){
			adjustHeap(array, i, array.length - 1);
		}
		
		for(int i = array.length - 1; i > 0; --i){
			swap(array, 0, i);
			adjustHeap(array, 0, i - 1);
		}
	}
	
	private void adjustHeap(int[] array, int s, int m){
		int tmp = array[s];
		for(int i = s*2; i <= m; i *=2){
			if(i < m && array[i+1] > array[i]){
				++i;
			}
			if(tmp >= array[i]){
				break;
			}
			array[s] = array[i];
			s = i;
		}
		array[s] = tmp;
	}
	
	private void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	
	public static void main(String[] args){
		int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
		System.out.println(Arrays.toString(array));
		new HeapSort().sort(array);
		System.out.println(Arrays.toString(array));
	}

}
