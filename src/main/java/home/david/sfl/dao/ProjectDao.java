package home.david.sfl.dao;

import home.david.sfl.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by David on 6/16/2017.
 */
@Repository
public interface ProjectDao extends JpaRepository <Project, Long> {
    Project findByName (String name);
}
