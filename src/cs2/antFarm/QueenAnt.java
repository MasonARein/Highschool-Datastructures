package cs2.antFarm;

import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class QueenAnt extends Ant {

    public QueenAnt() {
        this.setColor(Color.MAGENTA);
    }

    public void process(WorkerAnt s) {
        setFood(s.getFood() + getFood());
        s.setFood(0);
        s.setQueenLoc(this.getLocation());
        s.setColor(Color.black);
        s.setNewQueenLoc(s.getNewQueenLoc() + 1);
    }
    public void act(){

    }
}
