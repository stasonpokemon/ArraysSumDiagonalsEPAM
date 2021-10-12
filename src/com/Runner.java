package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    private static Scanner scanner = new Scanner(System.in);

    public void run() {
        int[][] arrayEnterSize = enterSizeArray();
        int[][] array = enterArrayValues(arrayEnterSize);
        int[] finalArray = sumDiagonalsArray(array);
        showArray(array);
        System.out.println("Final array...");
        showFinalArray(finalArray);
    }

    private int[][] enterSizeArray() {
        int arrayLineSize = 0;
        int arrayColumnSize = 0;
        boolean arrayLineSizeValid = true;
        boolean arrayColumnSizeValid = true;

        System.out.println("Задайте размерность матрицы...");
        do {
            try {
                System.out.println("Введите количество столбцов...");
                arrayColumnSize = scanner.nextInt();
                arrayColumnSizeValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Введите числовое значение!!!");
                scanner.nextLine();
                System.out.println("Exception: " + e);
            }
        } while (arrayColumnSizeValid);

        do {
            try {
                System.out.println("Введите количество строк...");
                arrayLineSize = scanner.nextInt();
                arrayLineSizeValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Введите числовое значение!!!");
                scanner.nextLine();
                System.out.println("Exception: " + e);
            }
        } while (arrayLineSizeValid);


        int[][] array = new int[arrayColumnSize][arrayLineSize];
        return array;
    }

    private int[][] enterArrayValues(int[][] array) {
        int value = 0;
        int[][] array1 = array;
        boolean valueValid = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                do {
                    try {
                        System.out.println("Введите значение для поля array[" + i + "][" + j + "]:");
                        value = scanner.nextInt();
                        valueValid = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Введите числовое значение!!!");
                        scanner.nextLine();
                        System.out.println("Exception: " + e);
                    }
                } while (valueValid);
                array1[i][j] = value;
            }
        }
        return array1;
    }

    private int[] sumDiagonalsArray(int[][] array) {
        /**
         * Если размер строк матрицы равен i, то цикл будет выполняться (i * 2)-1
         * */

        int operationValue = (array.length * 2) - 1;
        int[] finalArray = new int[operationValue];
        int numPosition = 0;
        for (int j = array.length - 1; j >= 0; j--) {
            for (int k = 0; k < array.length - j; k++) {
                finalArray[numPosition] += array[k][j + k];
            }
            numPosition++;
        }
        for (int i = 1 ; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                finalArray[numPosition] += array[j][i+j];
            }
            numPosition++;
        }
        return finalArray;
    }

    private void showArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void showFinalArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

}
