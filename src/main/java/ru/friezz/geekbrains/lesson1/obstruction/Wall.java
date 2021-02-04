package ru.friezz.geekbrains.lesson1.obstruction;

import ru.friezz.geekbrains.lesson1.actor.CanRunAndJump;

public class Wall implements Obstruction {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doPass(CanRunAndJump actor) {
        return actor.jump(height);
    }
}
