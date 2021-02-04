package ru.friezz.geekbrains.lesson1.actor;

import ru.friezz.geekbrains.lesson1.obstruction.Obstruction;

public class Human implements CanRunAndJump, Actor {
    private final int runDist = 15;
    private final int jumpHeight = 10;

    @Override
    public boolean run(int dist) {
        if (runDist >= dist){
            System.out.println("Человек пробежал " + dist + " метров");
            return true;
        } else {
            System.out.println("Человек не смог пробежать " + dist + " метров");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (jumpHeight >= height){
            System.out.println("Человек перепрыгнул " + height + " метров");
            return true;
        } else {
            System.out.println("Человек не смог перепрыгнуть " + height + " метров");
            return false;
        }
    }

    @Override
    public boolean doPass(Obstruction obstruction) {
       return obstruction.doPass(this);
    }
}
