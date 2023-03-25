package MAZE_SOLVER;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;

public class NewClass extends JFrame{
    
    // create a grid for a maze
    // 1 -> obstacle
    // 0 -> path to which we go to destination
    // 9 -> destination

    private int[][] maze = {{1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,0,1,0,1,0,1,0,0,0,0,0,1},
    {1,0,1,0,0,0,1,0,1,1,1,0,1},
    {1,0,1,1,1,1,1,0,0,0,0,0,1},
    {1,0,0,1,0,0,0,0,1,1,1,0,1},
    {1,0,1,0,1,1,1,0,1,0,0,0,1},
    {1,0,1,0,1,0,0,0,1,1,1,0,1},
    {1,0,1,0,1,1,1,0,1,0,1,0,1},
    {1,0,0,0,0,0,0,0,0,0,1,9,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1}};


    // create a list to store the path from source to destination

    public List<Integer> path = new ArrayList<>();
    
    //create a constructor for NewClass

    public NewClass(){
        
        //to set window title
        setTitle("< Maze Solver >");

        //set the window size to display
        setSize(500, 600);

        //to close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //call function DFS for to generate a path from src to dest
        DFS_for_mazePath.SearchMazePath(maze, 1, 1, path);
        //System.out.println(path);

    }

    //to set the graphics design of the grid i.e grid location, obstacle color, path color and available path to move

    @Override
    public void paint(Graphics g){

         // to set grid at centre
         g.translate(50,50);

         //to set the colors in the grid
 
         for(int i = 0; i < maze.length; i++){
             for(int j = 0; j < maze[0].length; j++){
 
                 //color class
                 Color color;

                 //use switch case to use set the color to the box in the grid i.e for obstacle, destination point and path point

                 switch(maze[i][j]){
                    
                    case 1 : color = Color.BLUE; // obstacles(1)
                    break;

                    case 9 : color = Color.RED; //dest(9)
                    break;

                    default : color = Color.BLACK; //available path(0)
                    break;

                 }

                 // set and fill the color in the rectangles in the grid

                 g.setColor(color);
                 g.fillRect(30*j, 30*i, 30, 30);

                 // to differentiate the adjecent rectangle i.e a verticle and horizontal line in the grid
                 g.setColor(Color.MAGENTA);
                 g.drawRect(30*j, 30*i, 30, 30);


             }
         }

         // to go through the path list and set the path color
         for(int i = 0; i < path.size(); i+=2){

            int pathx = path.get(i);
            int pathy = path.get(i+1);

            // System.out.println(pathx+" ");
            
            // System.out.print(pathy+" ");

            //set and fill color
            g.setColor(Color.WHITE);
            g.fillRect(30*pathx, 30*pathy, 15, 15);

         }
       
    }

    public static void main(String[] args){

        NewClass view = new NewClass();
        view.setVisible(true);

    }

}
