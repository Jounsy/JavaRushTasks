package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 * Created by Work-TESTER on 23.06.2017.
 */
public class Controller {
    private EditUserView editUserView;
    private Model model;
    private UsersView usersView;


    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {

        this.usersView = usersView;

    }

    public void onShowAllDeletedUsers() {

        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
    model.loadUserById(userId);
    editUserView.refresh(model.getModelData());
    }
    public void onUserDelete(long userId){
        model.deleteUserById(userId);
        usersView.refresh(model.getModelData());
       // editUserView.refresh(model.getModelData()); //не проходит валидацию не трогать
    }
}
