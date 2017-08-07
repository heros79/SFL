package home.david.sfl.service;

import home.david.sfl.dao.ProjectDao;
import home.david.sfl.dao.TaskDao;
import home.david.sfl.model.Project;
import home.david.sfl.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


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
    public Project remove(Project project, String projectName) {
        findAllProject().remove(findByProjectName(projectName));
        return null;
    }

    @Override
    public Task remove(Task task, String taskSubject) {
        return null;
    }

    @Override
    public Project findByProjectName(String projectName) {
        return projectDao.findByName(projectName);
    }

    @Override
    public Task findByTaskSubject(String taskSubject) {
        return taskDao.findBySubject(taskSubject);
    }

    @Override
    public List<Task> findAllSubject() {

        for (Task subject: taskDao.findAll()) {
            findAllSubject().add(subject);
        }

        return findAllSubject();
    }

    @Override
    public List<Project> findAllProject() {

        for (Project project: projectDao.findAll()) {
            findAllProject().add(project);
        }

        return findAllProject();
    }
}
