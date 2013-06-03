package sort;

import java.util.Arrays;

public class BubbleSort {
	
	private static void swap(int a, int b){
		a = a + b;
		b = a - b;
		a = a - b;
	}
	
	private static void swap2(int a, int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}
	
	/**
	 * 冒泡排序是非常容易理解和实现，，以从小到大排序举例：
     * 设数组长度为N。
	 * 1．比较相邻的前后二个数据，如果前面数据大于后面的数据，就将二个数据交换。
	 * 2．这样对数组的第0个数据到N-1个数据进行一次遍历后，最大的一个数据就“沉”到数组第N-1个位置。
	 * 3．N=N-1，如果N不为0就重复前面二步，否则排序完成。
	 * 
	 * @param array
	 */
	public static void sort(int[] array){
		int swapCount = 0;
		for(int i = 0; i < array.length; ++i){
			for(int j = 1; j < array.length - i; ++j){
				if(array[j - 1] > array[j]){
					/* 交换两个变量  method 1*/
//					array[j] = array[j] + array[j - 1];
//					array[j - 1] = array[j] - array[j - 1];
//					array[j] = array[j] - array[j - 1];
					
					/* 交换两个变量 method 2*/
					array[j] = array[j] ^ array[j - 1];
					array[j - 1] = array[j] ^ array[j - 1];
					array[j] = array[j] ^ array[j - 1];
				}
				++swapCount;
			}
		}
		
		System.out.println("Sort 交换次数: " + swapCount);
	}
	
	/**
	 * 下面对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。
	 * 明显如果有一趟没有发生交换，说明排序已经完成。
	 *
	 * @param array
	 */
	public static void sort2(int[] array){
		int swapCount = 0;
		
		int k = array.length;
		boolean flag = true;
		while(flag){
			flag = false;
			for(int i = 1; i < k; ++i){
				if(array[i - 1] > array[i]){
					array[i] = array[i] ^ array[i - 1];
					array[i - 1] = array[i] ^ array[i - 1];
					array[i] = array[i] ^ array[i - 1];
					flag = true;
				}
				++swapCount;
			}
			--k;
		}
		
		System.out.println("Sort2 交换次数: " + swapCount);
	}
	
	
	/**
	 * 再做进一步的优化。如果有100个数的数组，仅前面10个无序，
	 * 后面90个都已排好序且都大于前面10个数字，那么在第一趟遍历后，
	 * 最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
	 * 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
	 * 
	 * @param array
	 */
	public static void sort3(int[] array){
		int swapCount = 0;
		
		int flag = array.length;
		int k = flag;
		while(flag > 0){
			k = flag;
			flag = 0;
			for(int i = 1; i < k; ++i){
				if(array[i - 1] > array[i]){
					array[i] = array[i] ^ array[i - 1];
					array[i - 1] = array[i] ^ array[i - 1];
					array[i] = array[i] ^ array[i - 1];
					flag = i;
				}
				++swapCount;
			}
		}
		
		System.out.println("Sort3  交换次数: " + swapCount);
	}
	
	public static void main(String[] args){
		int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 89, 100, 120, 134};
		System.out.println(Arrays.toString(array));
		
		int [] tmp = Arrays.copyOf(array, array.length);
		sort(tmp);
		System.out.println(Arrays.toString(tmp));
		
		tmp = Arrays.copyOf(array, array.length);
		sort2(tmp);
		System.out.println(Arrays.toString(tmp));
		
		tmp = Arrays.copyOf(array, array.length);
		sort3(tmp);
		System.out.println(Arrays.toString(tmp));
	}
}
