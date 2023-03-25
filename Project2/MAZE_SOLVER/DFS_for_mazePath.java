package MAZE_SOLVER;

import java.util.List;

public class DFS_for_mazePath {
    
    public static boolean SearchMazePath(int[][] maze, int x, int y, List<Integer> path){
        
        //base case -> if we reach the destination then we add path and return the function

        if(maze[y][x] == 9){
            path.add(x);
            path.add(y);
            return true;
        }

        //go for the next block to chech the next block is valid or not

        if(maze[y][x] == 0){ // if its valid

            // first mark as visited block
            maze[y][x] = 2;

            //then check for up direction block
            int dx = -1;
            int dy = 0;

            if(SearchMazePath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

            //then check for down direction block
            dx = 1;
            dy = 0;

            if(SearchMazePath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

            //then check for left direction block
            dx = 0;
            dy = -1;

            if(SearchMazePath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

            //then check for right direction block
            dx = 0;
            dy = 1;

            if(SearchMazePath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

        }
        // if above block is not execute means block has 1 or not reach destination then return false
        return false;
    }

}
