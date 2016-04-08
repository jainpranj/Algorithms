package assignment;

import java.util.Arrays;

public class KDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1,5,4,3,2};
		int k=2;
		System.out.println(kDiffernce(array, k));


	}
	public static int kDiffernce(int[] array,int differnce){
		int count=0;
		Arrays.sort(array);
		for(int i=0;i<array.length-1;i++){
			int key=array[i]+differnce;
			if(Arrays.binarySearch(array, key)>0){
				count++;
			}
		}
		return count;
		
	}

}
