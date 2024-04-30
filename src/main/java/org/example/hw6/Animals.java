package org.example.hw6;

class Animal {
    protected String name;
    protected int runLength;
    protected int jumpHeight;
    protected int swimLength;

    public Animal(String name, int runLength, int jumpHeight, int swimLength) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
        this.swimLength = swimLength;
    }

    public boolean run(int distance) {
        if (distance <= runLength) {
            return true;
        } else {
            return false;
        }
    }

    public boolean jump(int height) {
        if (height <= jumpHeight) {
            return true;
        } else {
            return false;
        }
    }

    public boolean swim(int distance) {
        if (swimLength == 0) {
            return false;
        } else if (distance <= swimLength) {
            return true;
        } else {
            return false;
        }
    }
}

class Dog extends Animal {
    public Dog(String name, int runLength, int jumpHeight, int swimLength) {
        super(name, runLength, jumpHeight, swimLength);
    }
}

class Cat extends Animal {
    public Cat(String name, int runLength, int jumpHeight, int swimLength) {
        super(name, runLength, jumpHeight, swimLength);
    }
}

public class Animals {
    public static void main(String[] args) {
        Animal dog = new Dog("Dog A", 500, 2, 300);
        Animal cat = new Cat("Cat A", 400, 4, 0);

        System.out.println(dog.run(400));
        System.out.println(dog.swim(5));
        System.out.println(dog.jump(1));

        System.out.println(cat.run(150));
        System.out.println(cat.swim(2));
        System.out.println(cat.jump(3));
    }
}
