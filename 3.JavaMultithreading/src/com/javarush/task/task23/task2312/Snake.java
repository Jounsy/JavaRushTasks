package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work-TESTER on 06.06.2017.
 */
/*
Змейка(15)
Теперь осталось допилить змею.

Вот что я предлагаю насчет движения змеи:
Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
а самый последний — удалять. Тогда получится, что змея ползет.

Давай добавим два метода move, один без параметров, а другой с двумя параметрами типа int.

В методе move без параметров необходимо:
а) прекратить движение если змея умерла(isAlive == false)
б) вызвать метод move(0, -1) если направление движения равно SnakeDirection.UP
в) вызвать метод move(1, 0) если направление движения равно SnakeDirection.RIGHT
г) вызвать метод move(0, 1) если направление движения равно SnakeDirection.DOWN
д) вызвать метод move(-1, 0) если направление движения равно SnakeDirection.LEFT

Метод move с параметрами int, int пока оставим пустым.


Требования:
1. В методе move без параметров должен быть вызван метод move(0, -1), если направление движения равно SnakeDirection.UP.
2. В методе move без параметров должен быть вызван метод move(1, 0), если направление движения равно SnakeDirection.RIGHT.
3. В методе move без параметров должен быть вызван метод move(0, 1), если направление движения равно SnakeDirection.DOWN.
4. В методе move без параметров должен быть вызван метод move(-1, 0), если направление движения равно SnakeDirection.LEFT.
5. Метод move с параметрами (int, int) не должен быть вызван, если змея умерла (isAlive == false).
6. В классе Snake должен быть создан метод move без параметров.
7. В классе Snake должен быть создан метод move с параметрами int, int.
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
}
