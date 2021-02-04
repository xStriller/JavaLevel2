package ru.friezz.geekbrains.lesson1;

import ru.friezz.geekbrains.lesson1.actor.Actor;
import ru.friezz.geekbrains.lesson1.actor.Cat;
import ru.friezz.geekbrains.lesson1.actor.Human;
import ru.friezz.geekbrains.lesson1.actor.Robot;
import ru.friezz.geekbrains.lesson1.obstruction.Obstruction;
import ru.friezz.geekbrains.lesson1.obstruction.Treadmill;
import ru.friezz.geekbrains.lesson1.obstruction.Wall;

public class Main {
    public static void main(String[] args) {
        Actor[] actors = new Actor[]{new Cat(), new Human(), new Robot()};
        Obstruction[] obstructions = new Obstruction[]{new Treadmill(10), new Wall(10),
                new Treadmill(15), new Wall(15), new Treadmill(20), new Wall(20)};
        for (Actor actor : actors) {
            for (Obstruction obstruction : obstructions) {
                if(!actor.doPass(obstruction)){
                    break;
                }
            }
        }
    }
}
