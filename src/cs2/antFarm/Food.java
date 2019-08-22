package cs2.antFarm;

import info.gridworld.actor.Actor;

import java.awt.*;


public abstract class Food extends Actor implements Processable {
    private int biteSize;
    private int size;

    public Food(int bite) {
        biteSize = bite;
        size = 200;

    }

    public String toString() {
        return super.toString() + "Bite Size:" + biteSize;
    }

    public void act() {
        if(size <= 0){
            removeSelfFromGrid();
        }
    }

    public void process(WorkerAnt s) {
        if(s.getFood() == 0) {
            s.setFood(biteSize);
            s.setColor(Color.red);
            size -= biteSize;
        }
        s.setFoodLoc(this.getLocation());
        s.setNewFoodLoc(s.getNewFoodLoc() + 1);
    }
}
