package org.example.hw12;

public class ThreadComparison {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        method1(arr);
        method2(arr);
    }

    public static void method1(float[] arr) {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Method 1 Overall - " + (endTime - startTime) + " ms");
    }

    public static void method2(float[] arr) {
        final float[] a1 = new float[h];
        final float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long startTimeSplit = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        long endTimeSplit = System.currentTimeMillis();

        long startTimeCalc = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTimeCalc = System.currentTimeMillis();

        long startTimeMerge = System.currentTimeMillis();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);


        long endTimeMerge = System.currentTimeMillis();

        long splitTime = endTimeSplit - startTimeSplit;
        long calcTime = endTimeCalc - startTimeCalc;
        long mergeTime = endTimeMerge - startTimeMerge;
        System.out.println("Method 2 split - : " + (splitTime) + " ms");
        System.out.println("Method 2 calculation - " + (calcTime) + " ms");
        System.out.println("Method 2 Merging - " + (mergeTime) + " ms");

        // Просчет + Склейка + раздедение

        System.out.println("Method 2 Overall - " + (splitTime + calcTime + mergeTime));
    }
}

