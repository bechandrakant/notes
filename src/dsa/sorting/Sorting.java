package dsa.sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sorting {
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] A = {9, 3, 8, 6, 7, -2, 11, 4, 5};
        int[] selectionSortedArray = sorting.selectionSort(A);
        for (int n: selectionSortedArray) {
            System.out.print(n + " ");
        }
        System.out.println(" Selection Sort");

        int[] bubbleSortedArray = sorting.bubbleSort(A);
        for (int n: bubbleSortedArray) {
            System.out.print(n + " ");
        }
        System.out.println(" Bubble Sort");

        int[] insertionSortedArray = sorting.insertionSort(A);
        for (int n: insertionSortedArray) {
            System.out.print(n + " ");
        }
        System.out.println(" Insertion Sort");

        int[] countingSortedArray = sorting.countingSort(A);
        for (int n: countingSortedArray) {
            System.out.print(n + " ");
        }
        System.out.println(" Counting Sort");
    }
    public int[] selectionSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            int min = A[i];
            for (int j = i + 1; j < A.length; j++) {
                if (min > A[j]) {
                    min = A[j];
                    minIndex = j;
                }
            }
            int temp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = temp;
        }
        return A;
    }
    public int[] bubbleSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

    public int[] insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while(j > 0 && A[j] < A[j - 1]) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j--;
            }
        }
        return A;
    }

    public int[] countingSort(int[] A) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int n: A) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int i = 0;

        for (Map.Entry<Integer, Integer> m: map.entrySet()) {
            for (int j = 0; j < m.getValue(); j++) {
                A[i] = m.getKey();
                i++;
            }
        }
        return A;
    }




}


