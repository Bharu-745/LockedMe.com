package phaseI_project_package;
import java.io.*;

class QuickSortNames{
	
// A utility function to swap two elements
static void swap(String[] arr, int i, int j)
{
	String temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

/* This function takes last element as pivot, places
the pivot element at its correct position in sorted
array, and places all smaller (smaller than pivot)
to left of pivot and all greater elements to right
of pivot */
static int partition(String[] arr, int low, int high)
{
	
	// pivot
	String pivot = arr[high];
	
	// Index of smaller element and
	// indicates the right position
	// of pivot found so far
	int i = (low - 1);

	for(int j = low; j <= high - 1; j++)
	{
		
		// If current element is smaller
		// than the pivot
		if (((Comparable<String>)arr[j]).compareTo(pivot) < 0)
		{
			
			// Increment index of
			// smaller element
			i++;
			swap(arr, i, j);
		}
	}
	swap(arr, i + 1, high);
	return (i + 1);
}

/* The main function that implements QuickSort
		arr[] --> Array to be sorted,
		low --> Starting index,
		high --> Ending index
*/
static void quickSort(String[] arr, int low, int high)
{
	if (low < high)
	{
		
		// pi is partitioning index, arr[p]
		// is now at right place
		int pi = partition(arr, low, high);

		// Separately sort elements before
		// partition and after partition
		quickSort(arr, low, pi - 1);
		quickSort(arr, pi + 1, high);
	}
}

// Function to print an array
static void printArray(String[] arr, int size)
{
	for(int i = 0; i < size; i++)
		System.out.print(arr[i] + "\n");
		
	System.out.println();
}

public static String[] sorted(String[] arr) {
	return arr;
}
/*
// Driver Code
public static void main(String[] args)
{
	String[] arr = { "Bubble Sort", "Array Vs Linked List", "Dos3", "Dos2", "Sets"};
	int n = arr.length;
	
	quickSort(arr, 0, n - 1);
	System.out.println("Sorted array: ");
	String[] sa = sorted(arr);
	for(int i = 0; i < sa.length; i++)
		System.out.print(sa[i] + "\n");
	System.out.println("Printed");
	printArray(arr, n);
}
*/

}


