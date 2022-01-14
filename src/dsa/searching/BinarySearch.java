package dsa.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {-2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(binarySearch(A, 4));
        System.out.println(binarySearch(A, 11));
        System.out.println(binarySearch(A, 14));
        System.out.println(floorOfTarget(A, 14));
        System.out.println(floorOfTarget(A, 10));
        System.out.println(frequencySearch(new int[]{1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6, 9, 11}, 5));
    }

    // TC: O(logN), SC: O(1)
    public static int binarySearch(int[] A, int target) {
        // Define search space
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Find greatest element <= target, find floor of given element
    public static int floorOfTarget(int[] A, int target) {
        // Define search space
        int left = 0;
        int right = A.length - 1;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return A[mid];
            } else if (A[mid] < target) {
                ans = A[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Given a sorted array of N elements. Find frequency of element K
    public static int frequencySearch(int[] A, int K) {
        // Intution: lastOccurrenceIndex - firstOccurenceIndex + 1
        int left = 0;
        int right = A.length - 1;
        int firstOccurenceIndex = 0;
        int lastOccurrenceIndex = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == K) {
                firstOccurenceIndex = mid;
                right = mid - 1;
            } else if (A[mid] < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == K) {
                lastOccurrenceIndex = mid;
                left = mid + 1;
            } else if (A[mid] < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrenceIndex - firstOccurenceIndex + 1;
    }

    // Given an unsorted array of N distinct elements, find any one of the local minima
    // localMinima = both neighbours must be larger,
    // for A[0] consider only A[1],
    // for last Element consider only second last
    // It may have more than one local minima (countLocalMinima always >= 1).
    public static int localMinima(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        if (A[0] < A[1]) {
            return A[0];
        }
        if (A[A.length - 1] < A[A.length - 2]) {
            return A[A.length - 1];
        }

        int left = 1;
        int right = A.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                return A[mid];
            } else if (A[mid + 1] < A[mid]) {
                left = mid + 1;
            } else if (A[mid - 1] < A[mid]) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
