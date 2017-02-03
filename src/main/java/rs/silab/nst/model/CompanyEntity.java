package rs.silab.nst.model;

import javax.persistence.*;

/**
 * Created by milinkoi on 02.02.2017.
 */
@Entity
@Table(name = "company", schema = "nst", catalog = "")
public class CompanyEntity {
    private long pib;
    private String name;
    private String city;
    private String phone;
    private String country;
    private String address;
    private Long postalcode;
    private String fax;

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

        CompanyEntity that = (CompanyEntity) o;

        if (pib != that.pib) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (postalcode != null ? !postalcode.equals(that.postalcode) : that.postalcode != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;

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
}
