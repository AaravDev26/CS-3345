/* 
Aarav Dev
Assignment 3 Programming Problem
*/

import java.util.Random;

public class ArraySorting
{
	public static void main(String[] args) 
	{
		// creating and sorting arrays of length 50
		int[] insertionSort50 = generateRandomIntArray(50, 1, 50); // creating random array of length 50
		// copying into other arrays because initial array will be sorted and thus changed
		int[] heapSort50 = copyArray(insertionSort50);
		int[] mergeSort50 = copyArray(insertionSort50);
		int[] quickSort50 = copyArray(insertionSort50);
		// Sorting size 50 arrays
		System.out.println("Time taken to sort a 50 element array\n");
		insertionSort(insertionSort50);
		heapSort(heapSort50);
		mergeSort(mergeSort50);
		quickSort(quickSort50);
		System.out.println("\n");
		
		// creating and sorting arrays of length 500
		int[] insertionSort500 = generateRandomIntArray(500, 1, 500); // creating random array of length 500
		// copying into other arrays because initial array will be sorted and thus changed
		int[] heapSort500 = copyArray(insertionSort500);
		int[] mergeSort500 = copyArray(insertionSort500);
		int[] quickSort500 = copyArray(insertionSort500);
		// Sorting size 500 arrays
		System.out.println("Time taken to sort a 500 element array\n");
		insertionSort(insertionSort500);
		heapSort(heapSort500);
		mergeSort(mergeSort500);
		quickSort(quickSort500);
		System.out.println("\n");
		
		// creating and sorting arrays of length 1000
		int[] insertionSort1000 = generateRandomIntArray(1000, 1, 1000); // creating random array of length 1000
		// copying into other arrays because initial array will be sorted and thus changed
		int[] heapSort1000 = copyArray(insertionSort1000);
		int[] mergeSort1000 = copyArray(insertionSort1000);
		int[] quickSort1000= copyArray(insertionSort1000);
		// Sorting size 1000 arrays
		System.out.println("Time taken to sort a 1000 element array\n");
		insertionSort(insertionSort1000);
		heapSort(heapSort1000);
		mergeSort(mergeSort1000);
		quickSort(quickSort1000);
		System.out.println("\n");
		
		// creating and sorting arrays of length 2000
		int[] insertionSort2000 = generateRandomIntArray(2000, 1, 2000); // creating random array of length 2000
		// copying into other arrays because initial array will be sorted and thus changed
		int[] heapSort2000 = copyArray(insertionSort2000);
		int[] mergeSort2000 = copyArray(insertionSort2000);
		int[] quickSort2000 = copyArray(insertionSort2000);
		// Sorting size 2000 arrays
		System.out.println("Time taken to sort a 2000 element array\n");
		insertionSort(insertionSort2000);
		heapSort(heapSort2000);
		mergeSort(mergeSort2000);
		quickSort(quickSort2000);
		System.out.println("\n");
		
		// creating and sorting arrays of length 5000
		int[] insertionSort5000 = generateRandomIntArray(5000, 1, 5000); // creating random array of length 5000
		// copying into other arrays because initial array will be sorted and thus changed
		int[] heapSort5000 = copyArray(insertionSort5000);
		int[] mergeSort5000 = copyArray(insertionSort5000);
		int[] quickSort5000 = copyArray(insertionSort5000);
		// Sorting size 5000 arrays
		System.out.println("Time taken to sort a 5000 element array\n");
		insertionSort(insertionSort5000);
		heapSort(heapSort5000);
		mergeSort(mergeSort5000);
		quickSort(quickSort5000);
		System.out.println("\n");
		
		// creating and sorting arrays of length 10000
		int[] insertionSort10000 = generateRandomIntArray(10000, 1, 10000); // creating random array of length 10000
		// copying into other arrays because initial array will be sorted and thus changed
		int[] heapSort10000 = copyArray(insertionSort10000);
		int[] mergeSort10000 = copyArray(insertionSort10000);
		int[] quickSort10000 = copyArray(insertionSort10000);
		// Sorting size 10000 arrays
		System.out.println("Time taken to sort a 10000 element array\n");
		insertionSort(insertionSort10000);
		heapSort(heapSort10000);
		mergeSort(mergeSort10000);
		quickSort(quickSort10000);
		System.out.println("\n");
	}
	
	// generates a random number array of specified length, minimum value, and maximum value
	public static int[] generateRandomIntArray(int length, int minVal, int maxVal) 
	{
        Random rand = new Random();
        int[] arr = new int[length]; // Initializing array
        for (int i = 0; i < length; i++) 
        {
            arr[i] = rand.nextInt(maxVal - minVal + 1) + minVal; // inserting random values within specified range
        }
        return arr;
    }
    

    // Returns a copy of the given array
    public static int[] copyArray(int[] originalArray) 
    {
        // Create a new array with the same length as the original array
        int[] copiedArray = new int[originalArray.length];
    
        // Copy each element of the original array into the new array
        for (int i = 0; i < originalArray.length; i++) {
            copiedArray[i] = originalArray[i];
        }
    
        // Return the new array
        return copiedArray;
    }
    
    // Sorts the array in the parameter using insertion sort
	public static void insertionSort(int[] arr) 
	{
        // Record the start time using nanoTime()
        long startTime = System.nanoTime();
        
        // Loop through the array from index 1
        for (int i = 1; i < arr.length; i++) {
            // Set the current element as the key
            int key = arr[i];
            // Initialize j as the previous element's index
            int j = i - 1;
            
            // Move elements greater than the key to the right
            while (j >= 0 && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert the key at the correct position in the sorted subarray
            arr[j + 1] = key;
        }
        
        // Record the end time using nanoTime()
        long endTime = System.nanoTime();
        // Calculate the total time taken
        long totalTime = endTime - startTime;
        // Print the time taken in nanoseconds
        System.out.println("Insertion sort:            " + totalTime + " nanoseconds");
    }
    
    public static void heapSort(int[] arr) 
    {
        // Record the start time using nanoTime()
        long startTime = System.nanoTime();
    
        // Build max heap by repeatedly calling maxHeapify()
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    
        // Extract elements from heap in sorted order
        for (int i = arr.length - 1; i > 0; i--) {
            // Swap root of heap with last element of heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
    
            // Call maxHeapify on the reduced heap
            maxHeapify(arr, i, 0);
        }
    
        // Record the end time using nanoTime()
        long endTime = System.nanoTime();
        // Calculate the total time taken
        long totalTime = endTime - startTime;
        // Print the time taken in nanoseconds
        System.out.println("Heap sort:                 " + totalTime + " nanoseconds");
    }

    // Helper method to maintain the max heap property
    private static void maxHeapify(int[] arr, int heapSize, int index) 
    {
        int largest = index;  // Initialize largest as root
        int left = 2 * index + 1;
        int right = 2 * index + 2;
    
        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
    
        // If right child is larger than largest so far
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
    
        // If largest is not root
        if (largest != index) {
            // Swap arr[index] and arr[largest]
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
    
            // Recursively call maxHeapify on the affected sub-tree
            maxHeapify(arr, heapSize, largest);
        }
    }
    
    public static void mergeSort(int[] arr) 
    {
        // Record the start time using nanoTime()
        long startTime = System.nanoTime();
    
        // Call the recursive merge sort method
        mergeSortRecursive(arr, 0, arr.length - 1);
    
        // Record the end time using nanoTime()
        long endTime = System.nanoTime();
        // Calculate the total time taken
        long totalTime = endTime - startTime;
        // Print the time taken in nanoseconds
        System.out.println("Merge sort:                " + totalTime + " nanoseconds");
    }
    
    // Helper method for merge sort
    private static void mergeSortRecursive(int[] arr, int left, int right) 
    {
        if (left < right) {
            int mid = (left + right) / 2;
            // Recursively call mergeSortRecursive on left and right sub-arrays
            mergeSortRecursive(arr, left, mid);
            mergeSortRecursive(arr, mid + 1, right);
            // Merge the sorted sub-arrays
            merge(arr, left, mid, right);
        }
    }
    
    // Helper method to merge two sorted sub-arrays
    private static void merge(int[] arr, int left, int mid, int right) 
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
    
        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
    
        // Merge the temporary arrays back into arr[]
        int i = 0;  // Index of left sub-array
        int j = 0;  // Index of right sub-array
        int k = left;  // Index of merged sub-array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
    
        // Copy any remaining elements of L[]
        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }
    
        // Copy any remaining elements of R[]
        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void quickSort(int[] arr) 
    {
        // Record the start time using nanoTime()
        long startTime = System.nanoTime();
    
        // Call the recursive quick sort method
        quickSortRecursive(arr, 0, arr.length - 1);
    
        // Record the end time using nanoTime()
        long endTime = System.nanoTime();
        // Calculate the total time taken
        long totalTime = endTime - startTime;
        // Print the time taken in nanoseconds
        System.out.println("Quick sort without cutoff: " + totalTime + " nanoseconds");
    
        // Call the recursive quick sort method with cutoff options
        for (int cutoff : new int[] {10, 50, 200}) 
        {
            // Record the start time using nanoTime()
            startTime = System.nanoTime();
    
            // Call the recursive quick sort method with cutoff
            quickSortRecursiveWithCutoff(arr, 0, arr.length - 1, cutoff);
    
            // Record the end time using nanoTime()
            endTime = System.nanoTime();
            // Calculate the total time taken
            totalTime = endTime - startTime;
            // Print the time taken in nanoseconds
            System.out.println("Quick sort with cutoff " + cutoff + ": " + totalTime + " nanoseconds");
        }
    }
    
    // Helper method for quick sort
    private static void quickSortRecursive(int[] arr, int left, int right) 
    {
        if (left < right) 
        {
            int pivot = partition(arr, left, right);
            // Recursively call quickSortRecursive on left and right sub-arrays
            quickSortRecursive(arr, left, pivot - 1);
            quickSortRecursive(arr, pivot + 1, right);
        }
    }
    
    // Helper method for quick sort with cutoff
    private static void quickSortRecursiveWithCutoff(int[] arr, int left, int right, int cutoff) 
    {
        if (right - left + 1 <= cutoff) 
        {
            // Use insertion sort for small sub-arrays
            insertionSort(arr, left, right);
        } 
        else 
        {
            int pivot = partition(arr, left, right);
            // Recursively call quickSortRecursiveWithCutoff on left and right sub-arrays
            quickSortRecursiveWithCutoff(arr, left, pivot - 1, cutoff);
            quickSortRecursiveWithCutoff(arr, pivot + 1, right, cutoff);
        }
    }
    
    // Helper method to partition the array around a pivot
    private static int partition(int[] arr, int left, int right) 
    {
        int pivot = arr[(right+left)/2];
        int i = left - 1;
        for (int j = left; j < right; j++) 
        {
            if (arr[j] < pivot) 
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    
    // Helper method to swap two elements in an array
    private static void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Helper method for insertion sort
    private static void insertionSort(int[] arr, int left, int right) 
    {
        for (int i = left + 1; i <= right; i++) 
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    // method to print the array, used for checking if sorting methods are functioning properly
    public static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) // Loooping through array
        {
            System.out.print(arr[i] + " "); // printing each element
        }
        System.out.println();
    }
}
