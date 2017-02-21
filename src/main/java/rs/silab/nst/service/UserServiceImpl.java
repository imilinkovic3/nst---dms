package rs.silab.nst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.silab.nst.dao.UserDao;
import rs.silab.nst.model.User;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public User findByUsername(User user) {
        return userDao.findByUsername(user);
    }

    @Override
    public User findByEmail(User user) {
        return userDao.findByEmail(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public void updateUser(User user) {
        if (user.getId() != 0) {
            User entity = userDao.findById(user.getId());

            if (entity != null) {
                entity.setEmail(user.getEmail());
                entity.setFirstname(user.getFirstname());
                entity.setLastname(user.getLastname());
                entity.setUsername(user.getUsername());
//            entity.setRoles(user.getRoles());
            }
            userDao.save(entity);
        } else {
            userDao.save(user);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

}
