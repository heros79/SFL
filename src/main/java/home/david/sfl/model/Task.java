package home.david.sfl.model;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by David on 6/12/2017.
 */
@Entity
@Table (name = "tasks")
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subject")
    private String subject;

    @Column (name = "description")
    private String description;

    @Column (name = "done")
    private boolean done;

    @Column (name = "date_create")
    private Date createdDate;

    @Column (name = "date_done")
    private Date doneDate;

    @ManyToOne
    private User assignedToUser;

    @ManyToOne
    private Project project;

    public Task(String subject, String description, boolean done, Date createdDate, Date doneDate) {
        this.subject = subject;
        this.description = description;
        this.done = done;
        this.createdDate = createdDate;
        this.doneDate = doneDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public User getAssignedToUser() {
        return assignedToUser;
    }

    public void setAssignedToUser(User assignedToUser) {
        this.assignedToUser = assignedToUser;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
