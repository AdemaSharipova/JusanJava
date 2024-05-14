package org.example.hw6and7;

public class Plate {

    private int capacity;
    private int food;

    public Plate(int capacity) {
            this.capacity = capacity;
            this.food = 0;
        }
    public void fillMax() {
        food = capacity;
    }

    public void info() {
        System.out.printf("Plate: %d / %d\n", food, capacity);
    }

    public void decreaseFood(int amount) {
        if (food >= amount) { //to ensure that the amount is not exceed the food
            food -= amount;
            System.out.println("Ate");
        } else {
            System.out.println("Not enough food in the plate\n");
        }
    }

    public void addFood(int amount) {
        if (food + amount <= capacity) {
            setFood(food+amount);
            System.out.printf("Added %d food to the plate \n", amount);
        } else {
            System.out.println("Cannot add food, plate capacity exceeded\n");
        }
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }
}
