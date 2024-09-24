package graphs;

import java.util.LinkedList;

public class IslandsDetails {
    private static int rows;
    private static int columns;
    public static void mainFn(){
        int[][] matrix = {
                {0,1,0},
                {0,1,0},
                {0,1,0},
                {0,0,1},
                {0,0,1}};
        rows = matrix.length;
        columns = matrix[0].length;
        findIslandMetrices(matrix);
    }

    private static void findIslandMetrices(int[][] matrix) {
        int numberOfIslands = 0;
        int maxIslandSize =0;
        boolean[][] visitedMatrix = new boolean[rows][columns];

        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++) {
                if (matrix[i][j] == 1 && !visitedMatrix[i][j]) {
                    int islandSize = getIslandSize(matrix, i,j,visitedMatrix);
                    if (islandSize > maxIslandSize) {
                        maxIslandSize = islandSize;
                    };
                    numberOfIslands++;
                }
            }
        }
        System.out.println("Max island size: " + maxIslandSize);
        System.out.println("Number of islands: " + numberOfIslands);
    }

    private static int getIslandSize(int[][] matrix, int row, int col, boolean[][] visited) {
        int islandSize = 0;
        class MatrixCell{
            int row, col;
            MatrixCell(int row, int col) {
                this.col = col;
                this.row = row;
            }
        }

        LinkedList<MatrixCell> list = new LinkedList<>();
        list.add(new MatrixCell(row, col));
        int[] rowsMove = {-1,1,0,0};
        int[] colsMove = {0,0,1,-1};

        while (!list.isEmpty()) {
            islandSize++;
            MatrixCell firstElementInList = list.remove();
            row = firstElementInList.row;
            col = firstElementInList.col;
            visited[row][col] = true;
            for (int i=0;i<rowsMove.length;i++) {
                if ( ((row + rowsMove[i]) >0) && ((row + rowsMove[i])<rows) &&
                     ((col + colsMove[i]) >0) && ((col + colsMove[i])<columns) &&
                     (matrix[row+rowsMove[i]][col + colsMove[i]] == 1) &&
                     (!visited[row+rowsMove[i]][col + colsMove[i]])) {
                    list.add(new MatrixCell(row + rowsMove[i], col + colsMove[i]));
                }
            }
        }
        return islandSize;
    }
}
