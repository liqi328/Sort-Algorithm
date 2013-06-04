package sort;

import java.util.Arrays;


/**
 * 折半插入排序
 * @author Liqi
 *
 */
public class BinaryInsertionSort implements Sort {
	public void sort(int[] array){
		int low = 0; 
		int high = 0;
		int mid = 0;
		int tmp = 0;
		for(int i = 1; i < array.length; ++i){
			low = 0; 
			high = i - 1;
			tmp = array[i];
			while(low <= high){
				mid = low + ((high - low) >> 1);
				if(array[mid] > tmp){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}
			
			for(int j = i - 1; j >= high + 1; --j){
				array[j + 1] = array[j];
			}
			array[high + 1] = tmp;
		}
	}
	
	public static void main(String[] args){
		int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
		System.out.println(Arrays.toString(array));
		new BinaryInsertionSort().sort(array);
		System.out.println(Arrays.toString(array));
	}
}
