package org.example.hw4;

import java.util.Random;
import java.util.Scanner;

public class hw4 {
    static char[][] map;
    static final int SIZE = 4;
    static final char DOT_PLAYER = 'X';
    static final char DOT_AI = '0';
    static final char DOT_EMPTY = '*';

    static final Scanner sc = new Scanner(System.in);

    static final Random random = new Random();

    public static void main(String[] args) {
        prepareMap();
        showMap();
        while (true) {
            playerTurn();
            showMap();

            if(isWinner()) {
                System.out.println("Победил игрок");
                break;
            }

            if(isDraw()) {
                System.out.println("Ничья");
                break;
            }

            botTurn();
            showMap();
            if(isWinner()) {
                System.out.println("Победил БОТ");
                break;
            }

            if(isDraw()) {
                System.out.println("Ничья");
                break;
            }

        }


    }

    public static boolean isWinner() {
        char symbol = DOT_PLAYER;

        for (int row = 0; row < SIZE; row++) {
            int count = 0;
            for (int col = 0; col < SIZE; col++) {
                if (map[row][col] == symbol) {
                    count++;
                }
            }
            if (count == SIZE) {
                System.out.println("Победил " + symbol);
                return true;
            }
        }

        for (int col = 0; col < SIZE; col++) {
            int count = 0;
            for (int row = 0; row < SIZE; row++) {
                if (map[row][col] == symbol) {
                    count++;
                }
            }
            if (count == SIZE) {
                System.out.println("Победил " + symbol);
                return true;
            }
        }

        int countMainDiagonal = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symbol) {
                countMainDiagonal++;
            }
        }
        if (countMainDiagonal == SIZE) {
            System.out.println("Победил " + symbol);
            return true;
        }

        int countSecondaryDiagonal = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][SIZE - 1 - i] == symbol) {
                countSecondaryDiagonal++;
            }
        }
        if (countSecondaryDiagonal == SIZE) {
            System.out.println("Победил " + symbol);
            return true;
        }

        return false;
    }

    public static boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void botTurn() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[j][i] = DOT_AI;
                    if (isWinner()) {
                        System.out.printf("Ход ИИ: [%d, %d]\n", (i + 1), (j + 1));
                        return;
                    }
                    map[j][i] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[j][i] = DOT_PLAYER;
                    if (isWinner()) {
                        map[j][i] = DOT_AI;
                        System.out.printf("Ход ИИ: [%d, %d]\n", (i + 1), (j + 1));
                        return;
                    }
                    map[j][i] = DOT_EMPTY;
                }
            }
        }

        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_AI;
        System.out.printf("Ход ИИ: [%d, %d]\n", (x + 1), (y + 1));
    }



    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_PLAYER;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void showMap(){
        for(int i = 0; i<= SIZE; i++){
            System.out.print(i+" ");
        }
        System.out.println(" ");

        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void prepareMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }


}
