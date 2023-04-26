package homeworkOne;

public class InsertionSort {
    public static void main(String[] args) {
    /*
    Sorting algorithm implementation. Choose any from the list: Insertion sort,
    Selection sort, bubble sort, Merge sort, Quicksort.
     */
        int numbers[] = {4, 8, 7, 9, 4, 10, 0};

        insertionSort(numbers);
        printArray(numbers);
    }

    private static void insertionSort(int[] inputArray){
        for (int i=1; i< inputArray.length; i++){
            int tempValue = inputArray[i];

            int j = i-1;
            while (j>=0 && inputArray[j] > tempValue) {
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = tempValue;
        }
    }

    private static void printArray(int[] inputArrays){
        for (int inputArray: inputArrays){
            System.out.println(inputArray);
        }
    }
}
