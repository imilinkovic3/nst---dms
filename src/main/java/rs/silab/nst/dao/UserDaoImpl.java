package rs.silab.nst.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import rs.silab.nst.model.Role;
import rs.silab.nst.model.User;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

//    public User findById(int id) {
//        User user = getByKey(id);
//
//        return user;
//    }
//
//    public User findBySSO(String sso) {
//        System.out.println("SSO : " + sso);
//        try {
//            User user = (User) getEntityManager()
//                    .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
//                    .setParameter("ssoId", sso)
//                    .getSingleResult();
//
//            return user;
//        } catch (NoResultException ex) {
//            return null;
//        }
//    }
//
   @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.firstname ASC")
                .getResultList();
        return users;
    }


    public void save(User user) {
        persist(user);
    }

//    public void deleteBySSO(String sso) {
//        User user = (User) getEntityManager()
//                .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
//                .setParameter("ssoId", sso)
//                .getSingleResult();
//        delete(user);
//    }
//
//    //An alternative to Hibernate.initialize()
//    protected void initializeCollection(Collection<?> collection) {
//        if (collection == null) {
//            return;
//        }
//        collection.iterator().hasNext();
//    }


    @Override
    public User findByUsername(User user) {

        System.out.println("user iz dao klase : " + user);
        try {
            User u = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.username LIKE :username")
                    .setParameter("username", user.getUsername())
                    .getSingleResult();
           // Hibernate.initialize(u);
          //  System.out.println("inicijalizovano u:***************88"+u );

            //  System.out.println("user iz dao klase iz baze : " + u);


            return u;
            //return user;
        } catch (NoResultException ex) {
           System.out.print("usao u catch");
            return null;
        }


    }
}
