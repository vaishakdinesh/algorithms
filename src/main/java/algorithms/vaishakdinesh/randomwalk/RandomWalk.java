package algorithms.vaishakdinesh.randomwalk;
/*
 * Copyright (c) 2017. Phasmid Software
 */


import java.util.Random;

public class RandomWalk {
    // total distance moved along the x axis
    private int x = 0;
    // total distance moved along the y axis
    private int y = 0;
    
    private enum Direction{
        NORTH(1),
        SOUTH(2),
        WEST(3),
        EAST(4);
        
        private int dir;
        
        Direction(int val){
            this.dir = val;
        }
        public int getDir() {
            return dir;
        }
        
    }
    
    Random rg;
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    public void randomWalk(int n) {
        rg = new Random();
        Direction[] directions = Direction.values();
        
        for(int i=0;i<n;i++){
            Direction walkingDir = directions[rg.nextInt(directions.length)];
            switch (walkingDir.getDir()){
            case 1: move(0,1);
                    break;
            case 2: move(0,-1);
                    break;
            case 3: move(-1,0);
                    break;
            case 4: move(1,0);
                    break;
            }
        }
    }
    public double distance() {
        return Math.sqrt((Math.pow(x, 2.0)+Math.pow(y, 2.0)));
    }
}
