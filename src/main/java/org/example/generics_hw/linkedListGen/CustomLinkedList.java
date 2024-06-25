package org.example.generics_hw.linkedListGen;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> {
    private Node<T> head;

    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void print() {
        if (head != null) {
            Node<T> currentNode = head;
            System.out.print("[");
            while(currentNode.getNextNode() != null) {
                System.out.print(currentNode.getData() + ", " );
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData() + "]");
        } else {
            System.out.println("[]");
        }
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if(this.head == null) {
            this.head = node;
        } else {
            Node<T> currentNode = head;
            while(currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(node);
        }
        size++;
    }

    public void add(int index, T data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.setNextNode(head);
            head = newNode;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
        size++;
    }

    public T get(int index) {
        if (index == 0) {
            return getFirst();
        }  else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getNextNode().getData();
        }
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        int last = size - 1;
        return get(last);
    }

    boolean contains(T data) {
        Node<T> currentNode = head;

        if(head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        if(currentNode.getData() == data) {
            return true;
        }

        while(currentNode.getNextNode() != null) {
            if (currentNode.getNextNode().getData() == data) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int indexOf(T data) {
        Node<T> currentNode = head;
        int index = 0;

        if(currentNode.getData() == data) {
            return index;
        }

        while(currentNode.getNextNode() != null) {
            index += 1;
            if (currentNode.getNextNode().getData() == data) {
                return index;
            }

            currentNode = currentNode.getNextNode();
        }
        throw new NoSuchElementException("No such element in the list.");
    }

    public void remove(T data) {
        Node<T> currentNode = head;

        if(currentNode.getData() == data) {
            removeFirst();
            return;
        }

        while(currentNode.getNextNode() != null) {
            if (currentNode.getNextNode().getData() == data) {
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        size--;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            head = head.getNextNode();
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        }
        size--;

    }

    public void removeFirst() {
        head = head.getNextNode();
        size--;
    }

    public void removeLast() {
        int last = size-1;
        removeByIndex(last);
    }

    public void set(int index, T data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setData(data);

    }

    public int size(){
        return size;
    }

    public T[] toArray (){
        T[] array = (T[]) new Object[size];

        Node<T> currentNode = head;
        int index = 0;

        while (currentNode != null) {
            array[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }

        return array;
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
