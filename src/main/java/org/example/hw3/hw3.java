package org.example.hw3;

import java.util.Scanner;
import java.util.Random;


public class hw3
{
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main( String[] args )
    {
        // first exercise
//        guessNumber();

        // second exercise
        guessWord();
    }

    // first exercise
    public static void guessNumber() {
        int maxAttempts = 3;
        int userGuess;

        while (true) {
            int randNum = random.nextInt(10); // Генерация случайного числа от 0 до 9
            int attempt = 0;
            boolean isGuessed = false;

            while (attempt < maxAttempts) {
                System.out.print("Введите число: ");
                userGuess = scanner.nextInt();

                if (userGuess == randNum) {
                    isGuessed = true;
                    System.out.println("Вы угадали число!");
                    break;
                } else if (userGuess < randNum) {
                    System.out.println("Загадонное число больше вашего");
                } else {
                    System.out.println("Загадонное число меньше вашего");
                }

                attempt++;
            }

            if (!isGuessed) {
                System.out.println("Вы проиграли. Загаданное число было: " + randNum);
            }

            System.out.print("Повторить игру еще раз? 1 – да / 0 – нет: ");
            int playAgain = scanner.nextInt();

            if (playAgain != 1) {
                break;
            }

        }

    }

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        String selectedWord = words[random.nextInt(words.length)];
        String userGuess;
        while(true) {
            System.out.print("Введите ваше слово: ");
            userGuess = scanner.nextLine().toLowerCase();

            if (userGuess.equals(selectedWord)) {
                System.out.println("Вы угадали слово!");
                break;
            } else {
                int minLength = Math.min(userGuess.length(), selectedWord.length());

                for (int i = 0; i < minLength; i++) {
                    if (userGuess.charAt(i) == selectedWord.charAt(i)) {
                        System.out.print(userGuess.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                for (int i = minLength; i < 15; i++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        }




    }

}



//2 * Создать массив из слов
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно, можно пользоваться:
//String str = "apple";
//str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово
//Используем только маленькие буквы
//