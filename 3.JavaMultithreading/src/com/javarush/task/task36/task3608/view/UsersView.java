package com.javarush.task.task36.task3608.view;


import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;



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


        StringBuilder makeString = modelData.isDisplayDeletedUserList()?new StringBuilder("All deleted users:"):new StringBuilder("All users:");

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
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
