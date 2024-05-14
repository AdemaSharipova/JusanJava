package org.example.hw8;

class Treadmill {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public void run(Person human) {
        if (human.run(length)) {
            System.out.println(human.getName() + " passed the treadmill");
        } else {
            System.out.println(human.getName() + " failed the treadmill");
        }
    }

    public void run(Cat cat) {
        if (cat.run(length)) {
            System.out.println(cat.getName() + " passed the treadmill");
        } else {
            System.out.println(cat.getName() + " failed the treadmill");
        }
    }

    public void run(Robot robot) {
        if (robot.run(length)) {
            System.out.println(robot.getName() + " passed the treadmill");
        } else {
            System.out.println(robot.getName() + " failed the treadmill");
        }
    }
}
