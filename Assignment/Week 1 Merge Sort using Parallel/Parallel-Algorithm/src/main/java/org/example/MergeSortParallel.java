package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class MergeSortParallel {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
            int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);

            // Tạo ra một số lượng các luồng tương đương với số lượng các đoạn con.
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<int[]> leftResult = executorService.submit(() -> {
                // Sắp xếp đoạn con bên trái bằng thuật toán merge sort.
                mergeSort(leftArr);
                return leftArr;
            });
            Future<int[]> rightResult = executorService.submit(() -> {
                // Sắp xếp đoạn con bên phải bằng thuật toán merge sort.
                mergeSort(rightArr);
                return rightArr;
            });

            try {
                // Lấy kết quả từ các luồng và trộn lại.
                int[] left = leftResult.get();
                int[] right = rightResult.get();
                merge(arr, left, right);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }

}