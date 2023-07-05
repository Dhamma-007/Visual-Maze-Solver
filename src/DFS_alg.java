import java.util.List;
public class DFS_alg {
    public static boolean searchPath(int [][] maze, int x, int y, List<Integer> path){

        System.out.println(x +" "+y);
        if (maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }

        if (maze[x][y]==0){
            maze[x][y]=2;

            int dx=1,dy=0;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx=-1;
            dy=0;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx=0;
            dy=-1;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx=0;
            dy=1;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

        }
        return false;
    }


}
