package cs2.antFarm;

import info.gridworld.actor.Actor;

public abstract class Food extends Actor implements Processable{
    private int biteSize;
    public Food(int bite){
        biteSize = bite;

    }

    public String toString(){
        return super.toString() + "Bite Size:" + biteSize;
    }
    public void act(){

    }
    public void process (WorkerAnt s){

    }
}
