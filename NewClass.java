/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
/**
 *
 * @author Welcome
 */
public class NewClass extends JFrame{
    int[][] maze={
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    List<Integer> path=new ArrayList<>();
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze, 1, 1, path);
        System.out.println(path);
    }
    @Override
    public void paint(Graphics g){
        g.translate(100, 100);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                switch(maze[i][j]){
                    case 1:
                        color=Color.BLACK;
                        break;
                    case 9:
                        color=Color.RED;
                        break;
                    default:
                        color=Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0;i<path.size();i=i+2){
            g.setColor(Color.GREEN);
            int pathX = path.get(i);
            int pathY = path.get(i+1);
            g.fillRect(30*pathX, 30*pathY, 20, 20);
        }
    }
    public static void main(String[] args){
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
