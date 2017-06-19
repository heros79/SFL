package home.david.sfl.service;

import home.david.sfl.model.Project;
import home.david.sfl.model.Task;

/**
 * Created by David on 6/16/2017.
 */
public interface ActionService {

    void save (Project project);

    void save (Task task);

    Project findByProjectName (String projectName);

    Task findByTaskSubject (String taskSubject);
}
