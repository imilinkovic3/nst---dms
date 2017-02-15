package rs.silab.nst.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String name;
    private String title;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    private List<User> users;
    public Role() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<User> getUsers() {
        return this.users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}