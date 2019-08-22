package cs2.antFarm;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class WorkerAnt extends Ant {
    private Location queenLoc;
    private Location foodLoc;
    private int newFoodLoc;
    private int newQueenLoc;

    public WorkerAnt() {
        this.setColor(Color.black);
    }
    private Location bestLoc(Location a){
        Grid gr = this.getGrid();
        int direct = getLocation().getDirectionToward(a);
        ArrayList <Location> cvc = gr.getEmptyAdjacentLocations(getLocation());
        int directAva = 359;
        Location next = null;
        for(int i = 0; i < cvc.size(); i++){
            if(Math.abs(direct - getLocation().getDirectionToward(cvc.get(i))) < directAva){
                directAva = Math.abs(direct - getLocation().getDirectionToward(cvc.get(i)));
                next = cvc.get(i);
            }
        }
        if(next != null) {
            return next;
        }
        else{
            return getLocation();
        }
    }

    public void act() {
        Grid gr = this.getGrid();
        Location loc = this.getLocation();
        Location to = null;
        if(getFood() == 0 && getFoodLoc() != null){
            to = bestLoc(getFoodLoc());
            if(to.equals(getFoodLoc()) && !(gr.get(to) instanceof Food)){
                setNewFoodLoc(getNewFoodLoc()+1);
                setFoodLoc(null);
            }
        }
        else if(getFood() != 0 && getQueenLoc() != null ){
            to = bestLoc(getQueenLoc());
            if(to.equals(getQueenLoc()) && !(gr.get(to) instanceof QueenAnt)){
                setNewQueenLoc(getNewQueenLoc()+1);
                setQueenLoc(null);
            }

        }
        else{
            ArrayList<Location> locations = gr.getEmptyAdjacentLocations(loc);
            if(locations.size() > 0) {
                to = locations.get((int) (Math.random() * locations.size()));
            }
            else{
                to = getLocation();
            }
            this.setDirection(loc.getDirectionToward(to));
        }
            this.moveTo(to);
        ArrayList<Actor> actors = gr.getNeighbors(loc);
        for (Actor a : actors) {
            Processable p = (Processable) a;
            p.process(this);
        }
    }

    public void process(WorkerAnt s) {
        if(s.getQueenLoc() != null && s.getNewQueenLoc() >= getNewQueenLoc()){
            setQueenLoc(s.getQueenLoc());
        }
        if(s.getFoodLoc() != null && s.getNewFoodLoc() >= getNewFoodLoc()){
            setFoodLoc(s.getFoodLoc());
        }
    }

    public Location getQueenLoc() {
        return queenLoc;
    }

    public Location getFoodLoc() {
        return foodLoc;
    }

    public void setQueenLoc(Location a) {
        queenLoc = a;
    }

    public void setFoodLoc(Location a) {
        foodLoc = a;
    }

    public int getNewFoodLoc() {
        return newFoodLoc;
    }

    public int getNewQueenLoc() {
        return newQueenLoc;
    }

    public void setNewFoodLoc(int newFoodLoc) {
        this.newFoodLoc = newFoodLoc;
    }

    public void setNewQueenLoc(int newQueenLoc) {
        this.newQueenLoc = newQueenLoc;
    }

    public String toString() {
        return super.toString() + "Queen Location: " + queenLoc + "Food Location: " + foodLoc;
    }

}
