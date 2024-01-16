package ex_3_2;

public class MainActivity {
    static public void start(int numberOfRooms) {
        Maze maze = new Maze();
        maze.buildMaze(numberOfRooms);
        Location current = maze.rooms[maze.mc.currentLocation];
        int[] ways = Activities.lookForDoors(maze.mc, current);


    }
}
