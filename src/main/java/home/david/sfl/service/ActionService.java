package home.david.sfl.service;

import home.david.sfl.model.Project;
import home.david.sfl.model.Task;

import java.util.List;

/**
 * Created by David on 6/16/2017.
 */
public interface ActionService {

    void save (Project project);

    void save (Task task);

    Project remove (Project project, String projectName);

    Task remove (Task task, String  taskSubject);

    Project findByProjectName (String projectName);

    Task findByTaskSubject (String taskSubject);

    List<Task> findAllSubject();

    List<Project> findAllProject();
}
