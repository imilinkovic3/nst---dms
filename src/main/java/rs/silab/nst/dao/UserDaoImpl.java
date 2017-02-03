package rs.silab.nst.dao;

import org.springframework.stereotype.Repository;
import rs.silab.nst.model.UserEntity;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

    public UserEntity findById(int id) {
        UserEntity user = getByKey(id);
//		if(user!=null){
//			initializeCollection(user.getUserProfiles());
//		}
        return user;
    }

    public UserEntity findBySSO(String sso) {
        System.out.println("SSO : " + sso);
        try {
            UserEntity user = (UserEntity) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
                    .setParameter("ssoId", sso)
                    .getSingleResult();

//			if(user!=null){
//				initializeCollection(user.getUserProfiles());
//			}
            return user;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<UserEntity> findAllUsers() {
        List<UserEntity> users = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
                .getResultList();
        return users;
    }

    public void save(UserEntity user) {
        persist(user);
    }

    public void deleteBySSO(String sso) {
        UserEntity user = (UserEntity) getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
                .setParameter("ssoId", sso)
                .getSingleResult();
        delete(user);
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if (collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}
