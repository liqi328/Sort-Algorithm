package sort;

public abstract class AbstractQuickSort implements Sort {

	@Override
	public final void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	protected final void quickSort(int[] array, int low, int high){
		if(low < high){
			int pivotLoc = partition(array, low, high);
			quickSort(array, low, pivotLoc - 1);
			quickSort(array, pivotLoc + 1, high);
		}
	}
	
	protected abstract int partition(int[] array, int low, int high);

}
