public class sudoku {
    public boolean isSafe(int[][] mat, int i, int j, int no) {
        for(int k=0;k<9;k++){
            if(mat[k][j]==no || mat[i][k]==no){
                return false;
            }
        }
        int sx = (i/3)*3;
        int sy = (j/3)*3;
        for(int x=sx;x<sx+3;x++){
            for(int y=sy;y<sy+3;y++){
                if(mat[x][y]==no){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solveSudoku(int[][] mat, int i, int j, int n) {
        if (i == n) {
            for(int a=0;a<9;a++){
                for(int b=0;b<9;b++){
                    System.out.print(mat[a][b]+" ");
                }
                System.out.println();
            }
            return true;
        }
        if (j == n) {
            return solveSudoku(mat, i + 1, 0, n);
        }
        //predefined skip
        if (mat[i][j] != 0) {
            return solveSudoku(mat, i, j + 1, n);
        }
        for (int no = 1; no <= n; no++) {
            if (isSafe(mat, i, j, no)) {
                mat[i][j] = no;
                boolean solveSubProblem = solveSudoku(mat, i, j + 1,n);
                if (solveSubProblem == true) {
                    return true;
                }
            }
        }
        mat[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        int n = 9;
        int matrix[][]={{6,0,0,0,7,0,3,0,0},
                          {0,0,0,8,0,0,0,0,4},
                          {0,0,0,0,0,0,0,0,0},
                          {0,5,8,0,0,0,0,0,0},
                          {0,4,0,0,3,0,0,0,0},
                          {0,0,0,0,0,6,9,0,0},
                          {7,0,0,5,0,0,0,9,0},
                          {2,0,0,0,0,0,6,0,0},
                          {0,0,0,4,0,0,0,0,0}};
        sudoku ob = new sudoku();
        if (!(ob.solveSudoku(matrix,0,0,n))) {
            System.out.println("no solution found!!!!");
        }                  
    }
}
