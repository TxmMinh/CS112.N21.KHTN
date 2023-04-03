package org.example;

import java.util.Arrays;
import java.util.Scanner;

import static org.example.MergeSortParallel.mergeSort;

public class Main {
    public static void main(String[] args) {

        // int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        Scanner scanner = new Scanner(System.in);

        // Nhập số phần tử của mảng
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        // Khởi tạo mảng
        int[] arr = new int[n];

        // Nhập các phần tử của mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        // In ra các phần tử của mảng
        System.out.println("Mảng vừa nhập: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("----------");

        mergeSort(arr);

        // In ra các phần tử của mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp: ");
        System.out.println(Arrays.toString(arr));
    }
}
