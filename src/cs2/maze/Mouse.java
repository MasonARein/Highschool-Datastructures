package cs2.maze;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Mouse extends Actor {
    public Mouse(){
        this.setColor(null);
        if(findCheese() != null){
            this.getGrid().get(findCheese()).removeSelfFromGrid();
            this.moveTo(findCheese());
        }
    }
    private Location findCheese(){
        for(int a = 0; a < 4; a++){
            if(getLocation().getAdjacentLocation(a * 90) != null || this.getGrid().get(getLocation().getAdjacentLocation(a * 90)) instanceof Cheese){
                return getLocation().getAdjacentLocation(a * 90);
            }
        }
        return null;
    }
    public ArrayList<Location> getLocations(){
        ArrayList<Location> ava = new ArrayList<Location>();
        for(int b = 0; b < 4; b++){
            if(this.getGrid().get(getLocation().getAdjacentLocation(b * 90)) == null){
                ava.add(getLocation().getAdjacentLocation(b * 90));
            }
        }
        return ava;
    }
    public void act(){

    }
}
