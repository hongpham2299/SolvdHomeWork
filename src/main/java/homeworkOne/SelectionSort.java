package homeworkOne;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        /*
        Sorting algorithm implementation. Choose any from the list: Insertion sort,
        Selection sort, bubble sort, Merge sort, Quicksort.
        */

        int[] numbers = {5, 2, 12, 25, 4, 8, 9};
        selectionSort(numbers);
    }


    private static void selectionSort(int[] inputArray){
        for(int i=0; i<inputArray.length; i++){
            int minIndex = i;

            for(int j=i+1; j<inputArray.length; j++){
                if (inputArray[j] < inputArray[minIndex]){
                    minIndex = j;
                }
            }
            int tempValue = inputArray[i];
            inputArray[i] = inputArray[minIndex];
            inputArray[minIndex] = tempValue;
        }
        System.out.println(Arrays.toString(inputArray));
    }
}
