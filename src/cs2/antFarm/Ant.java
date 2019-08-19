package cs2.antFarm;

import info.gridworld.actor.Actor;

public class Ant extends Actor implements Processable {
    private int food;
    public Ant(){
        food = 0;
    }
    public void process (WorkerAnt s){

    }
    public void act(){

    }
    public int getFood(){
        return food;
    }
    public void setFood(int v){
        food = v;
    }
    public String toString(){
        return super.toString() + "Food:" + food;
    }
}
