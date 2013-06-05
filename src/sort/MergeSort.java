package sort;

import java.util.Arrays;

public class MergeSort implements Sort {

	@Override
	public void sort(int[] array) {
		int[] temp = new int[array.length];
		mergeSort(array, 0, array.length - 1, temp);
	}
	
	private void mergeSort(int[] array, int s, int t, int[] temp){
		if(s < t){
			int mid = s + ((t - s) >> 1);
			mergeSort(array, s, mid, temp);
			mergeSort(array, mid + 1, t, temp);
			merge(array, s, mid, t, temp);
		}
	}
	
	private void merge(int[] array, int s, int m, int t, int[] temp){
		int i = s;
		int j = m + 1;
		int k = 0;
		for(; i <= m && j <= t;){
			if(array[i] <= array[j]){
				temp[k++] = array[i++];
			}else{
				temp[k++] = array[j++];
			}
		}
		while(i <= m){
			temp[k++] = array[i++];
		}
		
		while(j <= t){
			temp[k++] = array[j++];
		}
		
		for(j = 0; j < k; ++j){
			array[s + j] = temp[j];
		}
	}
	
	
	public static void main(String[] args){
		int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
		System.out.println(Arrays.toString(array));
		new MergeSort().sort(array);
		System.out.println(Arrays.toString(array));
	}

}
