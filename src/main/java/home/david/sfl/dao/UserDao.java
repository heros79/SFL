package home.david.sfl.dao;

import home.david.sfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by David on 6/16/2017.
 */
@Repository
public interface UserDao extends JpaRepository <User, Long> {
    User findByUserName (String userName);
}
