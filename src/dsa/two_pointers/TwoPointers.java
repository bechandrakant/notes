package dsa.two_pointers;

import java.util.Arrays;

public class TwoPointers {
    public static void main(String[] args) {
        TwoPointers tp = new TwoPointers();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        int[] C = tp.subArraySumV2(arr, target);
        for (int n: C)
            System.out.print(n + " ");
    }

    // Given a sorted array of distinct integers A and an integer B,
    // find and return how many pair of integers ( A[i], A[j] )
    // such that i != j have sum equal to B.
    public int pairWithGivenSum(int[] A, int B) {
        int pairs = 0;
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int sum = A[left] + A[right];
            if (sum == B) {
                pairs++;
                left++;
                right--;
            } else if (sum < B) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

    // Given a one-dimensional integer array A of size N and an integer B.
    // Count all distinct pairs with difference equal to B.
    // A[j] - A[i] = B
    public int pairWithGivenDifference(int[] A, int B) {
        Arrays.sort(A);
        int leftPointer = 0;
        int rightPointer = 1;
        int pairsCount = 0;

        while(leftPointer < rightPointer && rightPointer < A.length) {
            int diff = A[rightPointer] - A[leftPointer];
            if (diff == B) {
                int leftElement = A[leftPointer];
                int rightElement = A[rightPointer];

                while(leftPointer < rightPointer && A[leftPointer] == leftElement) {
                    leftPointer++;
                }

                while(rightPointer < A.length && A[rightPointer] == rightElement) {
                    rightPointer++;
                }

                pairsCount++;

            } else if (diff < B) {
                rightPointer++;
            } else {
                leftPointer++;
            }
            if (leftPointer == rightPointer) {
                rightPointer++;
            }
        }

        return pairsCount;
    }

    // Given array of positive integers, return subarray with sum = target
    // return -1, if no such subarray found
    public int[] subArraySum(int[] arr, int target) {
        // TC: O(n), SC: O(n)
        long[] prefixSum = new long[arr.length];
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefixSum[i] = sum;
        }

        int left = 0;
        int right = 1;

        while (right < arr.length && left <= right) {
            long subArraySum = prefixSum[right];
            if (left > 0) {
                subArraySum -= prefixSum[left - 1];
            }
            if (subArraySum == target) {
                return Arrays.copyOfRange(arr, left, right + 1);
            } else if (subArraySum < target) {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                right++;
            }
        }

        // Single element case
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return new int[]{arr[i]};
            }
        }

        return new int[]{-1};
    }

    public int[] subArraySumV2(int[] arr, int target) {
         // TC: O(n), SC: O(1)
         int left = 0;
         int right = 1;
         long sum = arr[0];

         while (right < arr.length && left <= right) {
             if (sum == target) {
                 return Arrays.copyOfRange(arr, left, right);
             } else if (sum < target) {
                 if (arr[right] == target) {
                   return new int[]{arr[right]};
                 }
                 sum += arr[right];
                 right++;
             } else if (sum > target) {
                 sum -= arr[left];
                 left++;
             }
             if (left == right) {
                 sum += arr[left];
                 right++;
             }
         }

         return new int[]{-1};
    }
}
