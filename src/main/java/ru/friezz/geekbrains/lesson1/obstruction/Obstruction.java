package ru.friezz.geekbrains.lesson1.obstruction;

import ru.friezz.geekbrains.lesson1.actor.CanRunAndJump;

public interface Obstruction {
    boolean doPass(CanRunAndJump actor);

}
