package org.example.generics_hw;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;
/*
ДЗ: 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
*/

public class Main {

    // first exercise
    public static <T> void swap(T[] arr, int ind1, int ind2) {
        if (ind1 < 0 || ind1 >= arr.length || ind2 < 0 || ind2 >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        T temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    // second exercise
    public static <T> List<T> convertToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) throws Exception {
        // test for second exercise
        Integer[] intArray = {1, 2, 3, 4};
        List<Integer> arrayList = convertToArrayList(intArray);
        // System.out.println(arrayList.getClass().getSimpleName());

        // test for the exercise with Fruit
        Box<Apple> box1 = new Box<>();
        box1.addFruit(new Apple());

        Box<Orange> box2 = new Box<>();
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());

        Box<Apple> box3 = new Box<>();
        box3.addFruit(new Apple());
        box3.addFruit(new Apple());


//        System.out.println(box1.compare(box3));
        box3.pour(box1);
        System.out.println(box3.getFruits());
        System.out.println(box1.getFruits());


    }

}
