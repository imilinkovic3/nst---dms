package rs.silab.nst.model;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String username;
    @ManyToOne
    @JoinColumn(name = "company")
    @Cascade(value = CascadeType.ALL)
    private Company companyBean;
    @ManyToMany(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id")})
    private List<Role> roles;
    public User() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return this.firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Company getCompanyBean() {
        return this.companyBean;
    }
    public void setCompanyBean(Company companyBean) {
        this.companyBean = companyBean;
    }
    public List<Role> getRoles() {
        return this.roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", companyBean=" + companyBean +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
           User user = (User)obj;
           if(user.getId()==this.getId()){
               return true;
           }
        }

        return false;
    }
}