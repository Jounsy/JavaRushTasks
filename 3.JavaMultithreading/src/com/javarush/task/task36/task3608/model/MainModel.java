package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.Util;
import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;


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

        List<User> users = userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(false);

    }
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user); //юзер иквалс айди
    }

    @Override
    public void deleteUserById(long userId) {
        User user = userService.deleteUser(userId);
        modelData.setDisplayDeletedUserList(false); //?
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers(){
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
    }

    List<User> filterOnlyActiveUsers(List<User> allUsers){
        return null;
    }

}
