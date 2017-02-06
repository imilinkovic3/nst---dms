package rs.silab.nst.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String pib;

    private String address;

    private String city;

    private String country;

    private String fax;

    private String name;

    private String phone;

    private BigInteger postalcode;

    @OneToMany(mappedBy = "companyBean")
    private List<User> users;

    public Company() {
    }

    public String getPib() {
        return this.pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigInteger getPostalcode() {
        return this.postalcode;
    }

    public void setPostalcode(BigInteger postalcode) {
        this.postalcode = postalcode;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User addUser(User user) {
        getUsers().add(user);
        user.setCompanyBean(this);

        return user;
    }

    public User removeUser(User user) {
        getUsers().remove(user);
        user.setCompanyBean(null);

        return user;
    }

}