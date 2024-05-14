package org.example.hw6and7;



class Cat extends Animal {
    private int appetite;
    private boolean isHungry;

    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public Cat(String name) {
        super(name);
        this.appetite = 105;
        this.isHungry = true;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            isHungry = false;
        } else {
            System.out.println("Not enough food in the plate");
            isHungry = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isHungry() {
        return isHungry;
    }



}
