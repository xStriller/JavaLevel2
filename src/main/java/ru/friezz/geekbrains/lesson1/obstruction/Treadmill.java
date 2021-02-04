package ru.friezz.geekbrains.lesson1.obstruction;

import ru.friezz.geekbrains.lesson1.actor.CanRunAndJump;

public class Treadmill implements Obstruction{
    private final int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    @Override
    public boolean doPass(CanRunAndJump actor) {
       return actor.run(dist);
    }
}

