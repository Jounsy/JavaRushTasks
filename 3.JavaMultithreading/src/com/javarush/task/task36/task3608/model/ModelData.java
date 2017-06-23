package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

/**
 * Created by Work-TESTER on 22.06.2017.
 */
public class ModelData {
    private User activeUser;
    private boolean displayDeletedUserList;

    public User getActiveUser() {
        return activeUser;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;
}
