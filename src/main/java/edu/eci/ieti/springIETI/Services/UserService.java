package edu.eci.ieti.springIETI.Services;

import edu.eci.ieti.springIETI.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);

}
