package org.example.hw8;

class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void jump(Person human) {
        if (human.jump(height)) {
            System.out.println(human.getName() + " passed the wall");
        } else {
            System.out.println(human.getName() + " failed the wall");
        }
    }

    public void jump(Cat cat) {
        if (cat.jump(height)) {
            System.out.println(cat.getName() + " passed the wall");
        } else {
            System.out.println(cat.getName() + " failed the wall");
        }
    }

    public void jump(Robot robot) {
        if (robot.jump(height)) {
            System.out.println(robot.getName() + " passed the wall");
        } else {
            System.out.println(robot.getName() + " failed the wall");
        }
    }
}
