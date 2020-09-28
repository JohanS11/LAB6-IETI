package edu.eci.ieti.springIETI.Services.impl;

import edu.eci.ieti.springIETI.Services.UserService;
import edu.eci.ieti.springIETI.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private ArrayList<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
        this.users.add(new User("2146195","chan1100","chan@mail.com","chan123"));
        this.users.add(new User("2146196","johan","johan@mail.com","johan123"));
        this.users.add(new User("2146197","sebas1100","sebas@mail.com","sebas123"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(String userId) {

        for (User user : users){
            if (user.getId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        User newUser = getById(user.getId()) ;
        if (!(user.getEmail() == null)){
            newUser.setEmail(user.getEmail());
        }
        if (!(user.getName() == null)){
            newUser.setName(user.getName());
        }
        if (!(user.getPassword() == null)){
            newUser.setPassword(user.getPassword());
        }
        return newUser;
    }

    @Override
    public void remove(String userId) {
        User newUser = getById(userId);
        users.remove(newUser);
    }
}
