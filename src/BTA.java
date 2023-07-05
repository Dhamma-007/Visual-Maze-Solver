import java.util.ArrayList;
import java.util.List;

public class BTA {

    private static int[][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,9,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1},
            {1,0,1,1,0,1,0,0,1,1,1,1,0,0,0,0,0,0,0,1},
            {1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,1},
            {1,1,0,0,0,1,0,0,1,1,0,1,0,0,0,0,0,1,0,1},
            {1,1,0,1,0,1,0,0,1,1,0,1,0,1,0,1,0,1,0,1},
            {1,1,0,1,0,1,0,0,1,1,0,1,0,0,0,1,0,1,0,1},
            {1,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,0,0,1},
            {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,1,1},
            {1,0,0,0,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1},
            {1,0,1,0,1,1,0,1,1,0,0,0,0,1,0,1,1,0,0,1},
            {1,0,1,0,0,1,0,1,1,0,1,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,1,1,0,0,0,0,1,1,0,1,0,1,0,0,0,1},
            {1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1},
            {1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,1,1,1,0,1,0,1,0,1,1,1,0,0,0,1,0,1,1,1},
            {1,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    private static final int SIZE = maze.length;

    private static int[][] solution = new int[SIZE][SIZE];

    private static void printSolution()
    {
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                System.out.print(solution[i][j]+"\t");
            }
            System.out.print("\n\n");
        }
    }

    private static boolean solveMaze(int r, int c)
    {

        if(maze[r][c]==9)
        {
            solution[r][c] = 1;
            return true;
        }

        if(r>0 && c>0 && r<SIZE && c<SIZE && solution[r][c] == 0 && (maze[r][c] == 0 || maze[r][c]==9))
        {

            solution[r][c] = 1;
            if(solveMaze(r+1, c))
                return true;
            if(solveMaze(r, c+1))
                return true;
            if(solveMaze(r-1, c))
                return true;
            if(solveMaze(r, c-1))
                return true;
            solution[r][c] = 0;
            return false;
        }
        return false;

    }
    public static List<Integer> retAns(List<Integer> sol,int m,int n){
        List<Integer> ans=new ArrayList<>();
        if (solveMaze(m,n)) {
//            printSolution();
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution.length; j++) {
                    if (solution[i][j] != 0) {
                        ans.add(j);
                        ans.add(i);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans=new ArrayList<>();
        if (solveMaze(1,1)) {
//            printSolution();
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution.length; j++) {
                    if (solution[i][j] != 0) {
                        ans.add(j);
                        ans.add(i);
                    }
                }
            }
        }
        else {
            System.out.println("No solution\n");
        }
        for (int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }


}
