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
}
