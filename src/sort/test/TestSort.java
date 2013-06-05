package sort.test;

import java.util.Arrays;

import sort.BinaryInsertionSort;
import sort.BubbleSort;
import sort.HeapSort;
import sort.QuickSort;
import sort.ShellSort;
import sort.Sort;
import sort.StraightInsertionSort;

public class TestSort {
	public static void testSort(Sort sorter, int[] array){
		int[] tmp = Arrays.copyOf(array, array.length);
		sorter.sort(tmp);
		System.out.println(Arrays.toString(tmp));
	}
	
	public static void main(String[] args){
		Sort[] sorters = new Sort[6];
		sorters[0] = new BinaryInsertionSort();
		sorters[1] = new BubbleSort();
		sorters[2] = new StraightInsertionSort();
		sorters[3] = new ShellSort();
		sorters[4] = new QuickSort();
		sorters[5] = new HeapSort();
		
		int[] array = RandomArrayGenerator.generateIntArray(100);
		System.out.println(Arrays.toString(array));
		for(Sort sorter: sorters){
			testSort(sorter, array);
		}
				
	}
}
