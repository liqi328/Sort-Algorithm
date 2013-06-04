package sort;

import java.util.Arrays;

public class ShellSort implements Sort {
	/**
	 * 根据数组长度求初始步长
	 * 
	 * 我们选择步长的公式为：2^k-1,2^(k-1)-1,...,15,7,3,1 ，其中2^k 减一即为该步长序列，k
	 * 为排序轮次
	 * 
	 * 初始步长：step = 2^k-1 
	 * 初始步长约束条件：step < len - 1 初始步长的值要小于数组长度还要减一的值（因
	 * 为第一轮分组时尽量不要分为一组，除非数组本身的长度就小于等于4）
	 * 
	 * 由上面两个关系试可以得知：2^k - 1 < len - 1 关系式，其中k为轮次，如果把 2^k 表 达式
	 * 转换成 step 表达式，则 2^k-1 可使用 (step + 1)*2-1 替换（因为 step+1 相当于第k-1
	 * 轮的步长，所以在 step+1 基础上乘以 2 就相当于 2^k 了），即步长与数组长度的关系不等式为
	 * (step + 1)*2 - 1 < len -1
	 * 
	 * @param len 数组长度
	 * @return
	 */
	private static int initialStep(int len) {
		/*
		 * 初始值设置为步长公式中的最小步长，从最小步长推导出最长初始步长值，即按照以下公式来推:
		 * 1,3,7,15,...,2^(k-1)-1,2^k-1
		 * 如果数组长度小于等于4时，步长为1，即长度小于等于4的数组不且分组，此时直接退化为直接插
		 * 入排序
		 */
		int step = 1;

		//试探下一个步长是否满足条件，如果满足条件，则步长置为下一步长
		while ((step + 1) * 2 - 1 < len - 1) {
			step = (step + 1) * 2 - 1;
		}

		System.out.println("初始步长 - " + step);
		return step;
	}
	
	private void sheelSort(int[] array, int dk){
		for(int i = dk; i < array.length; ++i){
			int tmp = array[i];
			int j = i - dk;
			while(j >= 0 && tmp < array[j]){
				array[j + dk] = array[j];
				j -= dk;
			}
			array[j + dk] = tmp;
		}
	}
	
	public void sort(int[] array){
		int step = initialStep(array.length);
		for(; step > 0; step = ((step+1)>>1) - 1){
			sheelSort(array, step);
		}
	}
	
	public static void main(String[] args){
		int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
		System.out.println(Arrays.toString(array));
		new ShellSort().sort(array);
		System.out.println(Arrays.toString(array));
	}
}
