package home.david.sfl.dao;

import home.david.sfl.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by David on 6/16/2017.
 */
public interface TaskDao extends JpaRepository <Task, Long> {


    Task findBySubject (String Subject);
}
