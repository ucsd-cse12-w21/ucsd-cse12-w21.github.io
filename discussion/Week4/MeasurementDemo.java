//  -Djava.compiler=NONE    <----- don't forget to use this flag!
class MeasurementDemo {

	// finds the max difference between any two elements in an array
	static int maxDifference(int[] arr){
		int max = 0;
		for (int i = 0; i < arr.length; i +=1){
			for (int j = 0; j < arr.length; j += 1){
				if (arr[i] - arr[j] > max){
					max = arr[i] - arr[j];
				}
			}
		}
		return max;
	}
	
	// returns whether or not an array has no elements that are 0
	static boolean isNonZeroArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 0){
				return false;
			}
		}
		return true;
	}
	
	// a method with lots of loops
	static int loopCeption(int[] arr){
		int count = 0;
		for (int a = 0; a < arr.length; a += 1){
			for (int b = 0; b < arr.length; b += 1){
				for (int c = 0; c < arr.length; c += 1){
					count += 1;
				}
			}
		}
		return count;
	}
	
	// dummy calls to all above methods
	static void callDummies(){
		int[] dummy = {0,0,0};
		maxDifference(dummy);
		isNonZeroArray(dummy);
		loopCeption(dummy);
	}
	
	
	public static void main(String[] args){
		// three differently-sized arrays used to demo runtime differences
		int[] smallArr = {0, 1, 2};
		int[] largeArr = new int[100];
		int[] reallyLargeArr = new int[10000];

		for(int i = 0; i < largeArr.length; i++){
			largeArr[i] = i;
		}
		
		for(int i = 0; i < reallyLargeArr.length; i++){
		reallyLargeArr[i] = i;
		}
		
		callDummies(); //get first calls out of the way for more accurate measurements below
		
		
		// General process to measure runtime of a method is the following:
		//    1. Get start time with System.nanoTime()
		//    2. Call the method you want to time
		//    3. Get elapsed time by getting finish time with System.nanoTime() and subtracting start time

		
		// Runtime differences for maxDifference
		long smallStart = System.nanoTime();
		int smallDifference = maxDifference(smallArr);
		long smallDuration = System.nanoTime() - smallStart;
		System.out.println("maxDifference on small array took: " + smallDuration + " nanoseconds.");
		
		long largeStart = System.nanoTime();
		int largeDifference = maxDifference(largeArr);
		long largeDuration = System.nanoTime() - largeStart;
		System.out.println("maxDifference on large array took: " + largeDuration + " nanoseconds.");
		
		long reallyLargeStart = System.nanoTime();
		int reallyLargeDifference = maxDifference(reallyLargeArr);
		long reallyLargeDuration = System.nanoTime() - reallyLargeStart;
		System.out.println("maxDifference on reallyLarge array took: " + reallyLargeDuration + " nanoseconds.");
	
		
		// Runtime differences for loopCeption
		smallStart = System.nanoTime();
		smallDifference = loopCeption(smallArr);
		smallDuration = System.nanoTime() - smallStart;
		System.out.println("loopCeption on small array took: " + smallDuration + " nanoseconds.");
		
		largeStart = System.nanoTime();
		largeDifference = loopCeption(largeArr);
		largeDuration = System.nanoTime() - largeStart;
		System.out.println("loopCeption on large array took: " + largeDuration + " nanoseconds.");

		
		// Runtime differences for isNonZeroArray
		// NOTE: these times are similar because each array is a best case for this method
		smallStart = System.nanoTime();
		isNonZeroArray(smallArr);
		smallDuration = System.nanoTime() - smallStart;
		System.out.println("isNonZeroArray on small array took: " + smallDuration + " nanoseconds.");
		
		largeStart = System.nanoTime();
		isNonZeroArray(largeArr);
		largeDuration = System.nanoTime() - largeStart;
		System.out.println("isNonZeroArray on large array took: " + largeDuration + " nanoseconds.");
		
	}
}
