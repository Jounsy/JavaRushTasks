package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Work-TESTER on 06.06.2017.
 */
/*

 */
public class Snake {

    public Snake(int x, int y){
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x,y));


        isAlive = true;
    }
    private List<SnakeSection> sections;
    private boolean isAlive;

    public int getX(){
        return sections.get(0).getX();
    }
    public int getY(){
        return sections.get(0).getY();
    }
    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    private SnakeDirection direction;

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public void move()
    {
        if(isAlive==true)
        {
            if(direction == SnakeDirection.UP) move(0, -1);
            if(direction == SnakeDirection.RIGHT) move(1, 0);
            if(direction == SnakeDirection.DOWN) move(0, 1);
            if(direction == SnakeDirection.LEFT) move(-1, 0);
        }
    }
    public void move(int x, int y){
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + x, head.getY() + y);
        checkBorders(head);
        checkBody(head);
        if(isAlive)
        {
            if(head.getX()==Room.game.getMouse().getX() && head.getY()==Room.game.getMouse().getY())
            {
                sections.add(0, head);
                Room.game.eatMouse();
            }
            else{
                sections.add(0, head);
                sections.remove(sections.size()-1);
            }
        }

    }

    public void checkBorders(SnakeSection head){
        if(head.getX() >= Room.game.getWidth()||head.getY() >= Room.game.getHeight()||head.getX()<0 || head.getY()<0)
        {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head){

        if(sections.size()>1)
        if (sections.subList(1,sections.size()).contains(head)){
            isAlive = false;
        }
    }
}
