import Maze.Maze;
class MazeRunner{
    public static void main(String[] args) {
        Maze maze = new Maze(6,6);
        //maze.printMaze();
        maze.setTreasure(5, 5);
        maze.setStart(2, 1);
        maze.printMaze();
        int result = maze.findShortPath();
        System.out.println(result);
       // maze.printResult();
    }
}