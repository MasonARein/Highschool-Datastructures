package cs2.antFarm;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class WorkerAnt extends Ant {

    public void act(){
        Grid gr = this.getGrid();
        Location loc = this.getLocation();
        ArrayList<Actor> actors = gr.getNeighbors(loc);
        for (Actor actor : actors) {
            actor.process(this);
        }

    }
    public void process (WorkerAnt)

}
