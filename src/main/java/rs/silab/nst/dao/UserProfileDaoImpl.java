package rs.silab.nst.dao;

import org.springframework.stereotype.Repository;
import rs.silab.nst.model.RoleEntity;

import javax.persistence.NoResultException;
import java.util.List;


@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, RoleEntity> implements UserProfileDao {

    public RoleEntity findById(int id) {
        return getByKey(id);
    }

    public RoleEntity findByType(String type) {
        System.out.println("type: " + type);
        try {
            RoleEntity userProfile = (RoleEntity) getEntityManager()
                    .createQuery("SELECT p FROM UserProfile p WHERE p.type LIKE :type")
                    .setParameter("type", type)
                    .getSingleResult();
            return userProfile;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<RoleEntity> findAll() {
        List<RoleEntity> userProfiles = getEntityManager()
                .createQuery("SELECT p FROM UserProfile p  ORDER BY p.type ASC")
                .getResultList();
        return userProfiles;
    }

}
