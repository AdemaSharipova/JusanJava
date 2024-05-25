package org.example.hw11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //  1.Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
        //  уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз
        //  встречается каждое слово.

        String[] words = {"Hi",  "Barbie", "Hi", "Ken", "You", "want", "to", "go", "for", "a", "ride",
                "Sure", "Ken", "Jump" ,"in", "I'm", "a", "Barbie", "girl", "in", "the", "Barbie", "world",
                "Life", "in", "plastic", "it's", "fantastic"};

        Set<String> noDuplicates = new HashSet<>();
        for (String word: words) {
            noDuplicates.add(word);
        }
        System.out.println(noDuplicates);

        Map<String, Integer> countOfWords = new HashMap<>();
        for (String word : words) {
            if (countOfWords.containsKey(word)) {
                countOfWords.put(word, countOfWords.get(word) + 1);
            } else {
                countOfWords.put(word, 1);
            }
        }

//        for (Map.Entry<String, Integer> entry : countOfWords.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        // Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи.
        // С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
        // несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

        PhoneBook pb = new PhoneBook();
        pb.add("Smith", "87777");
        pb.add("Smith", "87324");
        pb.add("Smith", "87324");
        pb.add("Kim", "23423432");
        pb.add("Riza", "23423432");

        System.out.println(pb.get("Smith"));
        System.out.println(pb.get("Kim"));

    }
}
