package home.david.sfl.service;

import home.david.sfl.model.User;

/**
 * Created by David on 6/16/2017.
 */
public interface UserService {

    void save (User user);

    User findByUserName (String userName);
}
