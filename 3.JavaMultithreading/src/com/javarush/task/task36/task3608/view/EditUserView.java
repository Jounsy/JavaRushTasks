package com.javarush.task.task36.task3608.view;

/**
 * Created by Work-TESTER on 23.06.2017.
 */


import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;


/**
 * Created by Work-TESTER on 23.06.2017.
 */
public class EditUserView implements View{

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        StringBuilder makeString = new StringBuilder("User to be edited:");

        makeString.append("\n\t" + modelData.getActiveUser());

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
