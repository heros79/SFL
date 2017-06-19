package home.david.sfl.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by David on 6/12/2017.
 */

@Entity
@Table (name = "projects")
public class Project {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "status")
    private boolean status;

    @Column (name = "start_date")
    private Date startDate;

    @Column (name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public Project(String name, String description, boolean status, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
