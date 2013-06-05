package sort.test;

import java.util.Random;

public class RandomArrayGenerator {
	public static int[] generateIntArray(int n){
		int[] result = new int[n];
		
		Random rnd = new Random(System.currentTimeMillis());
		for(int i = 0; i < n; ++i){
			result[i] = rnd.nextInt();
		}
		
		return result;
	}
	
	
	/**
	 * 生成 n 个[fist,end)区间的整数
	 * @param n		个数
	 * @param firt  最小的整数
	 * @param end   最大的整数
	 * @return
	 */
	public static int[] generateIntArray(int n, int first, int end){
		int[] result = new int[n];
		
		Random rnd = new Random(System.currentTimeMillis());
		for(int i = 0; i < n; ++i){
			result[i] = rnd.nextInt(end - first) + first;
		}
		
		return result;
	}
}
