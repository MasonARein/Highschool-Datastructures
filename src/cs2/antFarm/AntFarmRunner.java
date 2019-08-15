package cs2.antFarm;

import cs2.gridWorld.MyBug;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

public class AntFarmRunner {
    public static void main(String[] args) {
        Grid<Actor> gr = new BoundedGrid<Actor>(40, 40);
        ActorWorld world = new ActorWorld(gr);

        world.show();
    }
}
