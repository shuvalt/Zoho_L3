import java.util.*;
class SnakeGame {
    public static void main(String[] args) {
        Snake snake = new Snake(6,6);
        snake.snakeMove(0,0);
    }
}

class Snake{
    char[][] snakeBoard;
    Queue<Node> tail = new LinkedList<>();
    public Snake(int i,int j){
        snakeBoard = new char[i][j];
        for(int a=0;a<snakeBoard.length;a++){
            for(int b=0;b<snakeBoard.length;b++){
                snakeBoard[a][b]='*';
            }
        }
        tail.add(new Node(0,0));
        snakeBoard[5][5] = 'x';
        snakeBoard[4][4] = 'x';
        snakeBoard[2][5] = 'x';
        snakeBoard[3][1] = 'x';     
    }
    public String snakeMove(int row,int col){
        Scanner sc = new Scanner(System.in);
        if(!(row >= 0 && col >= 0 && row<snakeBoard.length && col<snakeBoard.length)){
            System.out.println("game over....");
            tail.clear();;
            return "game over";
        }
        if(snakeBoard[row][col] == 'o'){
            System.out.println("game over...");
            tail.clear();
            return "game over ";
        }
        if(snakeBoard[row][col] != 'x'){
            Node temp = tail.remove();
            int preRow = temp.getRow();
            int preCol = temp.getCol();
            snakeBoard[preRow][preCol] = '*';
        }
        tail.add(new Node(row,col));
        snakeBoard[row][col] = 'o';
        while(!tail.isEmpty()){
            printBoard();
            char c = sc.nextLine().charAt(0);
            if(c=='u'){
                snakeMove(--row,col);
            }else if(c=='d'){
                snakeMove(++row,col);
            }else if(c=='r'){
                snakeMove(row,++col);
            }else if(c=='l'){
                snakeMove(row,--col);
            }else{
                System.out.println("invalid move..");
            }
        }
        return "next ";
    }
    public void printBoard(){
        for(int i=0;i<snakeBoard.length;i++){
            for(int j=0;j<snakeBoard[0].length;j++){
                System.out.print(snakeBoard[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}

class Node{
    int row;
    int col;
    public Node(int row,int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}

