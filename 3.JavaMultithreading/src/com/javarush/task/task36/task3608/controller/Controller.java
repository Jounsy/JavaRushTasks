package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;

/**
 * Created by Work-TESTER on 23.06.2017.
 */
public class Controller {
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers(){
        model.loadUsers();
    }
}
