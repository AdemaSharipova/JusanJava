package org.example.hw9;

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class hw9 {

    public static void main(String[] args) {
        String[][] allIsCorrect = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        String[][] invalidDataInput = {
                {"1", "2", "3", "4"},
                {"Hello", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeInput = {
                {"1", "2", "3", "4"},
                {"Hello", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] array = invalidSizeInput;

        try {
            int sum = calculateArraySum(array);
            System.out.println("Sum of array elements: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Array size is not 4x4");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Invalid data in array");
            e.printStackTrace();
        }
    }

    public static int calculateArraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Array size is not 4x4");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data in cell [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}

