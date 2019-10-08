package cs2.maze;

import cs2.stack.CS2Stack;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.Stack;

public class Mouse extends Actor {
    private CS2Stack<Location> all = new CS2Stack<Location>();
    private CS2Stack<Location> allBread = new CS2Stack<Location>();
    private boolean stop;
    public Mouse(){
        this.setColor(null);
        stop = false;
    }
    private Location findCheese() {
        ArrayList<Location> locList = new ArrayList<Location>();
        locList.add(this.getLocation().getAdjacentLocation(Location.NORTH));
        locList.add(this.getLocation().getAdjacentLocation(Location.EAST));
        locList.add(this.getLocation().getAdjacentLocation(Location.SOUTH));
        locList.add(this.getLocation().getAdjacentLocation(Location.WEST));
        for (Location l : locList) {
            if (this.getGrid().isValid(l) && this.getGrid().get(l) instanceof Cheese) {
                return l;
            }
        }
        return null;
    }

    private ArrayList<Location> getLocs(){
        ArrayList<Location> locList = new ArrayList<Location>();
        ArrayList<Location> retList = new ArrayList<Location>();
        locList.add(this.getLocation().getAdjacentLocation(Location.NORTH));
        locList.add(this.getLocation().getAdjacentLocation(Location.EAST));
        locList.add(this.getLocation().getAdjacentLocation(Location.SOUTH));
        locList.add(this.getLocation().getAdjacentLocation(Location.WEST));
        for (Location l : locList) {
            if (this.getGrid().isValid(l) && this.getGrid().get(l)==null) {
                retList.add(l);
            }
        }
        return retList;
    }

    public void act(){
        if(!stop) {
            if (findCheese() != null) {
                Location cur = getLocation();
                Breadcrumb a = new Breadcrumb();
                Location temp = findCheese();
                this.getGrid().get(findCheese()).removeSelfFromGrid();
                this.moveTo(temp);
                a.putSelfInGrid(getGrid(), cur);
                stop = true;
            } else {
                ArrayList<Location> ex = this.getLocs();
                System.out.println(all);
                for (Location x : ex) {
                    all.push(x);
                }
                Location current = this.getLocation();
                Location moveTo;
                if (ex.size() != 0) {
                    moveTo = all.pop();
                } else {
                    moveTo = allBread.pop();
                }
                this.setDirection(getLocation().getDirectionToward(moveTo));
                this.moveTo(moveTo);
                Breadcrumb b = new Breadcrumb();
                b.putSelfInGrid(getGrid(), current);
                if (ex.size() != 0) {
                    allBread.push(b.getLocation());
                }
            }
        }

    }
}
