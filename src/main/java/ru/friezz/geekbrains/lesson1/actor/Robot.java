package ru.friezz.geekbrains.lesson1.actor;

import ru.friezz.geekbrains.lesson1.obstruction.Obstruction;

public class Robot implements CanRunAndJump, Actor {
    private final int runDist = 50;
    private final int jumpHeight = 50;

    @Override
    public boolean run(int dist) {
        if (runDist >= dist){
            System.out.println("Робот пробежал " + dist + " метров");
            return true;
        } else {
            System.out.println("Робот не смог пробежать " + dist + " метров");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (jumpHeight >= height){
            System.out.println("Робот перепрыгнул " + height + " метров");
            return true;
        } else {
            System.out.println("Робот не смог перепрыгнуть " + height + " метров");
            return false;
        }
    }

    @Override
    public boolean doPass(Obstruction obstruction) {
        return obstruction.doPass(this);
    }
}
