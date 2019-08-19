package cs2.antFarm;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class WorkerAnt extends Ant {
    Location queenLoc;
    Location foodLoc;
    public WorkerAnt(){
        this.setColor(Color.black);
    }
    public void act(){
        Grid gr = this.getGrid();
        Location loc = this.getLocation();
        ArrayList<Location> locations = gr.getEmptyAdjacentLocations(loc);
        Location to  = locations.get((int)(Math.random() * locations.size()));
        this.setDirection(loc.getDirectionToward(to));
        this.moveTo(to);
        ArrayList<Actor> actors = gr.getNeighbors(loc);
        for(Actor a: actors){
           Processable p = (Processable)a;
           p.process(this);
        }
    }
    public void process (WorkerAnt s){

    }
    public Location getQueenLoc(){
        return queenLoc;
    }
    public Location getFoodLoc(){
        return foodLoc;
    }
    public void setQueenLoc(Location a){
        queenLoc = a;
    }
    public void setFoodLoc(Location a){
        foodLoc = a;
    }

}
