package cs2.antFarm;

import info.gridworld.actor.Actor;

import java.awt.*;

public abstract class Food extends Actor implements Processable {
    private int biteSize;

    public Food(int bite) {
        biteSize = bite;

    }

    public String toString() {
        return super.toString() + "Bite Size:" + biteSize;
    }

    public void act() {

    }

    public void process(WorkerAnt s) {
        if(s.getFood() == 0) {
            s.setFood(biteSize);
            s.setColor(Color.red);
        }
        s.setFoodLoc(this.getLocation());
        s.setNewFoodLoc(s.getNewFoodLoc() + 1);
    }
}
