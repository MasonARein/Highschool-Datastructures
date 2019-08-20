package cs2.antFarm;

import cs2.gridWorld.MyBug;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

public class AntFarmRunner {
    public static void main(String[] args) {
        Grid<Actor> g = new BoundedGrid<Actor>(19, 19);
        ActorWorld world = new ActorWorld(g);

        world.add(new Cookie());
        world.add(new Cake());
        world.add(new QueenAnt());
        for(int a =0; a < 10; a++){
            world.add(new WorkerAnt());
        }
        world.show();
    }
}
