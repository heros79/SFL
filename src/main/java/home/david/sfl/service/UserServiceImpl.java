package home.david.sfl.service;

import home.david.sfl.dao.UserDao;
import home.david.sfl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by David on 6/16/2017.
 */
@Service ("User")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));
        user.setRole(User.Role.ROLE_USER);
        userDao.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
