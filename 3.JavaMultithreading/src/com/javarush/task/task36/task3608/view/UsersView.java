package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work-TESTER on 23.06.2017.
 */
public class UsersView implements View{

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        StringBuilder makeString = new StringBuilder("All users:");
       // List<User> userData = new ArrayList<>(modelData.getUsers());
        for(int i = 0; i < modelData.getUsers().size();i++){
            makeString.append("\n\t" + modelData.getUsers().get(i));
        }
        makeString.append("\n===================================================");
        System.out.println(makeString.toString());
    }



    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
    controller.onShowAllDeletedUsers();
    }
}
