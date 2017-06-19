package home.david.sfl.model;

import javax.persistence.*;
import java.util.List;


/**
 * The User Model class
 * Created by David on 6/12/2017.
 */

@Entity
@Table (name = "users")
public class User {

    public enum Role {
        ROLE_USER, ROLE_ADMIN
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "username")
    private String userName;

    @Column  (name = "password")
    private String passwordHash;

    @Column (name = "user_role")
    private Role role;

    @OneToMany(mappedBy = "assignedToUser")
    private List<Task> tasks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
