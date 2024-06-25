package org.example.generics_hw;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit: fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box <T> box2) {

        return Math.abs(this.getWeight() - box2.getWeight()) < 0.0001;

    }

    public void pour(Box <T> box2) throws Exception {

        if (this.fruits.isEmpty()) {
            throw new Exception("Nothing to pour. The box is empty");
        }

        box2.fruits.addAll(new ArrayList(this.fruits));
        this.fruits.clear();
    }



}
