package ru.friezz.geekbrains.lesson1.actor;

import ru.friezz.geekbrains.lesson1.obstruction.Obstruction;

public class Cat implements CanRunAndJump, Actor {
    private final int runDist = 10;
    private final int jumpHeight = 20;

    @Override
    public boolean run(int dist) {
        if (runDist >= dist){
            System.out.println("Кот пробежал " + dist + " метров");
            return true;
        } else {
            System.out.println("Кот не смог пробежать " + dist + " метров");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (jumpHeight >= height){
            System.out.println("Кот перепрыгнул " + height + " метров");
            return true;
        } else {
            System.out.println("Кот не смог перепрыгнуть " + height + " метров");
            return false;
        }
    }

    @Override
    public boolean doPass(Obstruction obstruction) {
        return obstruction.doPass(this);
    }
}
