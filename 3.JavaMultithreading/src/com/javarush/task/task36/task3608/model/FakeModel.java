package com.javarush.task.task36.task3608.model;
import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Work-TESTER on 22.06.2017.
 */
public class FakeModel implements Model {
   private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        if(modelData==null){return new ModelData();}
        else {
            return modelData;
        }
    }

    @Override
    public void loadUsers() {

        List<User> users = new ArrayList<>();

        users.add(new User("C",3,3));
        users.add(new User("B", 2, 1));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }


//    public static void main(String[] args) {
//        FakeModel fakeModel = new FakeModel();
//        fakeModel.loadUsers();
        //
   // }
}
