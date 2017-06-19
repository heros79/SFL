package home.david.sfl.service;

import home.david.sfl.dao.ProjectDao;
import home.david.sfl.dao.TaskDao;
import home.david.sfl.model.Project;
import home.david.sfl.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


/**
 * Created by David on 6/16/2017.
 */
@Service ()
@Transactional
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private TaskDao taskDao;

    @Override
    public void save(Project project) {
        project = new Project("", "", true, new Date(19191989), new Date(19191989) );
        projectDao.save(project);
    }

    @Override
    public void save(Task task) {
        task = new Task("","", true, new Date(19191989), new Date(19191989));
        taskDao.save(task);
    }

    @Override
    public Project findByProjectName(String projectName) {
        return projectDao.findByName(projectName);
    }

    @Override
    public Task findByTaskSubject(String taskSubject) {
        return taskDao.findBySubject(taskSubject);
    }
}
