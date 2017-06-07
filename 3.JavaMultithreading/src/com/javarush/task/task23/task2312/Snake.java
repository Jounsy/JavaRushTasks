package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work-TESTER on 06.06.2017.
 */
/*
Змейка(16)
Ничто не вечно. Так и змея должна умирать, если она врезается в стену или саму себя.

Для определения, не пересекается ли змея сама с собой, можно сделать очень простую проверку:
содержит ли список sections «новую голову змеи«.

Код для этого будет выглядеть примерно так:
if (sections.contains(head))

При этом head должен быть еще не добавлен в список sections, иначе будет всегда true.
Но чтобы этот код работал, надо реализовать методы сравнения объектов (equals и hashCode) в классе SnakeSection.

Подсказка:
Используй Ctrl+O в Intellij IDEA для автоматической генерации методов equals и hashCode.

Задание:
а) реализуй методы equals и hashCode в классе SnakeSection.
б) реализуй метод checkBorders(SnakeSection head): если голова змеи за границами комнаты — змея умирает (isAlive = false)
в) реализуй метод checkBody(SnakeSection head): если голова змеи пересекается с ее телом — змея умирает (isAlive = false)


Требования:
1. В классе SnakeSection должен быть метод equals.
2. В классе SnakeSection должен быть метод hashCode.
3. В классе Snake должен быть реализован, в соответствии с условием, метод checkBorders.
4. В классе Snake должен быть реализован, в соответствии с условием, метод checkBody.
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
    public void move(int x, int y){}

    public void checkBorders(SnakeSection head){
        if(getX() >= Room.game.getWidth()||getY() >= Room.game.getHeight())
        {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head){

        if (sections.contains(head)){
            isAlive = false;
        }
    }
}
