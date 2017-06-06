package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work-TESTER on 06.06.2017.
 */
/*
Змейка(8)
Настала очередь конструктора класса Snake.

Змея у нас будет поначалу состоять из одного кусочка — головы.
А что для него требуется?
Что необходимо передать в конструктор?
Координаты змеи, конечно же.

Надо:
а) Передать в конструктор координаты головы змеи (x и y)
б) создать в нем первый «кусочек змеи» (голову) и добавить его в коллекцию sections.
в) isAlive выставить в true
г) не забудь в конструкторе инициализировать переменную sections. В null не много-то и добавишь!
д) создать и реализовать метод int getX(). Метод должен вернуть координату Х головы змеи.
е) создать и реализовать метод int getY(). Метод должен вернуть координату Y головы змеи.
ж) еще добавить классу метод move()— он нам пригодится попозже.
з) созданный конструктор должен быть публичным.


Требования:
1. В классе Snake должен быть создан корректно работающий public конструктор (согласно условию задачи) с двумя параметрами типа int.
2. В классе Snake должен быть создан метод getX() без параметров, возвращающий координату x нулевого элемента списка sections.
3. В классе Snake должен быть создан метод getY() без параметров, возвращающий координату y нулевого элемента списка sections.
4. В классе Snake должен быть создан метод move.
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
    public void move(){}
}
