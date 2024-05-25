package org.example.hw10;

import java.util.NoSuchElementException;

public class CustomLinkedList {
    private Node head;

    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void add(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        } else {
            Node currentNode = head;
            while(currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(node);
        }
        size++;
    }

    public void add(int index, int data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node newNode = new Node(data);
        if (index == 0) {
            newNode.setNextNode(head);
            head = newNode;
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
        size++;
    }

    public void remove(int data) {
        Node currentNode = head;

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

    public void removeFirst() {
        head = head.getNextNode();
        size--;
    }

    public void removeLast() {
        int last = size-1;
        removeByIndex(last);
    }

    public void print() {
        if (head != null) {
            Node currentNode = head;
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

    public int get(int index) {
        if (index == 0) {
            return getFirst();
        }  else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getNextNode().getData();
        }
    }

    public int getFirst() {
        return head.getData();
    }

    public int getLast() {
        int last = size - 1;
        return get(last);
    }

    boolean contains(int data) {
        Node currentNode = head;

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

    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            head = head.getNextNode();
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        }
        size--;

    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int indexOf(int data) {
        Node currentNode = head;
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

    public void set(int index, int data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setData(data);

    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
