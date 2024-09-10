package Maze;
import Node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    char[][] maze;
    LinkedList<Node> nodeList = new LinkedList<>(); 
    Queue<Node> nodeQueue;
    Node finalNode;
    Node startNode;
    Node treasureNode;
    public Maze(int i,int j){
         maze = new char[i][j];
         intialize(i, j);
    }
    private void intialize(int i,int j){
        for(int a=0;a<i;a++){
            for(int b=0;b<j;b++){
                maze[a][b]='0';
            }
        }
    }
    public void printMaze(){
        for(int a=0;a<this.maze.length;a++){
            for(int b=0;b<this.maze[0].length;b++){
                System.out.print(maze[a][b]+" ");
            }
            System.out.println();
        }
    }
    public void setTreasure(int i,int j){
        if(i>maze.length || j>maze[0].length){
            System.out.println("invalid index");
        }
        maze[i-1][j-1]='T';
        Node newNode = new Node(i-1, j-1, 0, null);
        treasureNode = newNode;
    }
    public void setStart(int i,int j){
        i--;
        j--;
        if(i>maze.length || j>maze[0].length){
            System.out.println("invalid index");
            return;
        }
        if(maze[i][j]=='T'){
            System.out.println("treasure found in 0 steps.");
            return;
        }
        maze[i][j]='A';
        Node newNode;
        newNode = new Node(i, j, 0,null);
        System.out.println(newNode != null);
        startNode = newNode;
        nodeQueue.add(newNode);
       // nodeList.add(newNode);
    }
    public int findShortPath(){
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!nodeQueue.isEmpty()){
            Node currNode = nodeQueue.poll();
            int currentRow = currNode.row;
            int currentColumn = currNode.column;
            for(int[] direction:directions){
                int nextRow = currentRow + direction[0];
                int nextCol = currentColumn + direction[1];
                boolean rowCheck = nextRow<maze.length && nextRow>=0;
                boolean colCheck = nextCol<maze[0].length && nextCol>=0; 
                if(rowCheck && colCheck && !(maze[nextRow][nextCol] =='V')){
                    if(maze[nextRow][nextCol]=='T'){
                        finalNode = currNode;
                        return currNode.steps+1;
                    }
                    maze[nextRow][nextCol] = 'V';
                    Node newNode = new Node(nextRow, nextCol, currNode.steps+1,currNode);
                    nodeQueue.add(newNode);
                }
            }
        }
        return -1;
    }
    public void printResult(){
        intialize(6, 6);
        maze[startNode.row][startNode.column] = 'S';
        maze[treasureNode.row][treasureNode.column] = 'T';
        Node curr = finalNode;
        while(curr.previNode!=null){
            maze[curr.row][curr.column] = 'P';
            curr = curr.previNode;
        }
        for(int a=0;a<this.maze.length;a++){
            for(int b=0;b<this.maze[0].length;b++){
                System.out.print(maze[a][b]+" ");
            }
            System.out.println();
        }
    }
}
