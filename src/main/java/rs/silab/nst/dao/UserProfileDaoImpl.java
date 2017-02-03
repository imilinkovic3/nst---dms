package rs.silab.nst.dao;

import org.springframework.stereotype.Repository;
import rs.silab.nst.model.Role;

import javax.persistence.NoResultException;
import java.util.List;


@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, Role> implements UserProfileDao {

    public Role findById(int id) {
        return getByKey(id);
    }

    public Role findByType(String type) {
        System.out.println("type: " + type);
        try {
            Role userProfile = (Role) getEntityManager()
                    .createQuery("SELECT p FROM UserProfile p WHERE p.type LIKE :type")
                    .setParameter("type", type)
                    .getSingleResult();
            return userProfile;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        List<Role> userProfiles = getEntityManager()
                .createQuery("SELECT p FROM UserProfile p  ORDER BY p.type ASC")
                .getResultList();
        return userProfiles;
    }

}
