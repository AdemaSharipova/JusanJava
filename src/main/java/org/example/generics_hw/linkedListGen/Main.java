package org.example.generics_hw.linkedListGen;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(1);
        list.add(0,1);
//        System.out.println(list.get(3));
//        System.out.println(list.getFirst());
//        System.out.println(list.getLast());

        list.print();

    }
}
