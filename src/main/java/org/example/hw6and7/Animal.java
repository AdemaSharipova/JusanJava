package org.example.hw6and7;

class Animal {
    protected String name;
    protected String color;
    protected int age;
    protected int runLength;
    protected int jumpHeight;
    protected int swimLength;

    public Animal(String name, int runLength, int jumpHeight, int swimLength) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
        this.swimLength = swimLength;
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runLength = 0;
        this.jumpHeight = 0;
        this.swimLength = 0;
    }

    public Animal(String name) {
        this.name = name;
    }

    public boolean run(int distance) {
        return distance <= runLength;
    }

    public boolean jump(int height) {
        return height <= jumpHeight;
    }

    public boolean swim(int distance) {
        if (swimLength == 0) {
            return false;
        } else return distance <= swimLength;
    }
}
