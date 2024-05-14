package org.example.hw8;

class Cat {
    private String name;
    private int maxRun;
    private int maxJump;

    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public void run() {
        System.out.println(name + " is running");
    }

    public void jump() {
        System.out.println(name + " is jumping");
    }

    public boolean run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " successfully ran " + distance);
            return true;
        } else {
            System.out.println(name + " can't run " + distance);
            return false;
        }
    }

    public boolean jump(int height) {
        if (height <= maxJump) {
            System.out.println(name + " successfully jumped "+ height );
            return true;
        } else {
            System.out.println(name + " can't jump " + height);
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
