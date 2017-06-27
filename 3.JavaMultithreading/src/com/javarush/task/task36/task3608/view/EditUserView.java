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
        StringBuilder makeStringEdit = new StringBuilder("User to be edited:");

        makeStringEdit.append("\n\t" + modelData.getActiveUser());

        makeStringEdit.append("\n===================================================");
        System.out.println(makeStringEdit.toString());
    }

    public void fireEventUserDeleted(long id){controller.onUserDelete(id);}


}
