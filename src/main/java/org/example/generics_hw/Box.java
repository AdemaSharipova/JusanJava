package org.example.generics_hw;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;
    private Class<? extends Fruit> fruitType;


    public Box() {
        this.fruits = new ArrayList<>();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
        this.fruitType = fruit.getClass();
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit: fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box <?> box2) throws Exception {
        if (this.fruitType != box2.fruitType) {
            throw new Exception("The type of product is not the same");
        }

        if (this.fruits.isEmpty() || box2.fruits.isEmpty()) {
            return false;
        }

        return this.getWeight() == box2.getWeight();

    }

    public void pour(Box <?> box2) throws Exception{
        if (this.fruitType != box2.fruitType) {
            throw new Exception("The type of product is not the same");
        }
        if (this.fruits.isEmpty()) {
            throw new Exception("Nothing to pour. The box is empty");
        }

        box2.fruits.addAll(new ArrayList(this.fruits));
        this.fruits.clear();
    }



}
