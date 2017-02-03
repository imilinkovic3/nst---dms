package rs.silab.nst.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by milinkoi on 03.02.2017.
 */
@Entity
public class Company {
    private long pib;
    private String name;
    private String city;
    private String phone;
    private String country;
    private String address;
    private Long postalcode;
    private String fax;
    private Collection<User> usersByPib;

    @Id
    @Column(name = "pib")
    public long getPib() {
        return pib;
    }


    public void setPib(long pib) {
        this.pib = pib;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "postalcode")
    public Long getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Long postalcode) {
        this.postalcode = postalcode;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (pib != company.pib) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (city != null ? !city.equals(company.city) : company.city != null) return false;
        if (phone != null ? !phone.equals(company.phone) : company.phone != null) return false;
        if (country != null ? !country.equals(company.country) : company.country != null) return false;
        if (address != null ? !address.equals(company.address) : company.address != null) return false;
        if (postalcode != null ? !postalcode.equals(company.postalcode) : company.postalcode != null) return false;
        if (fax != null ? !fax.equals(company.fax) : company.fax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pib ^ (pib >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "companyByCompany")
    public Collection<User> getUsersByPib() {
        return usersByPib;
    }

    public void setUsersByPib(Collection<User> usersByPib) {
        this.usersByPib = usersByPib;
    }
}
