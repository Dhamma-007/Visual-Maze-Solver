import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class maze_game extends JFrame {
    private int [][] maze =
            {
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1},
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

    private final List<Integer> path = new ArrayList<Integer>();
    private int path_index;

    public maze_game(){
        setTitle("Maze Solver using DFS");
        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DFS_alg.searchPath(maze,1,1,path);
        try {
            path_index=path.size()-2;
            Collections.reverse(path);
            int temp;
            for (int i=0;i<path.size();i++){
                if(i%2!=0){{
                    temp=path.get(i-1);
                    path.set(i-1,path.get(i));
                    path.set(i,temp);
                }}
            }
            System.out.println(path);
        } catch (Exception e) {
            System.out.println("No solution exists");
        }


    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                maze_game mg=new maze_game();
                mg.setVisible(true);
            }
        });

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.translate(30,30);



        for (int i=0;i<maze.length;i++){
            for (int j=0;j<maze[i].length;j++){
                Color color;
                switch (maze[j][i]){
                    case 1: color = Color.cyan;
                            break;
                    case 9: color = Color.GREEN;
                            break;
                    default: color = Color.BLACK;
                            break;
                }
                g.setColor(color);
                g.fillRect(30*i,30*j,30,30);
                g.setColor(Color.BLACK);
                g.drawRect(30*i,30*j,30,30);
            }
        }
      /*  Scanner sc=new Scanner(System.in);
        System.out.println("Press 1 for path");
        int a=sc.nextInt();*/

            for(int i=0;i<path.size();i+=2) {
                int pathXX = path.get(i);
                int pathYY = path.get(i + 1);
                try {
                    TimeUnit.MILLISECONDS.sleep(90);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                g.setColor(Color.white);
                g.fillOval(pathYY * 30, pathXX * 30, 30, 30);


            }


        //ball drawing
        int pathX=path.get(path.get(0));
        int pathY=path.get(path.get(1));
        g.setColor(Color.YELLOW);
        g.fillOval(pathX*30,pathY*30,30,30);



    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        if(e.getID()!=KeyEvent.KEY_PRESSED){
            return;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            path_index -= 2;
            if(path_index<0){
                path_index=0;
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            path_index+=2;
            if (path_index>path.size()-2){
                path_index=path.size()-2;
            }
        }

//        repaint();
    }
}
