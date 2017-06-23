package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work-TESTER on 23.06.2017.
 */
public class MainModel implements Model {
    private ModelData modelData = new ModelData();



    private UserService userService = new UserServiceImpl();


    @Override
    public ModelData getModelData() {
        if(modelData==null){return new ModelData();}
        else {
            return modelData;
        }
    }

    @Override
    public void loadUsers() {

        List<User> users = userService.getUsersBetweenLevels(1,100);
        modelData.setUsers(users);

    }
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }
}
