package rs.silab.nst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.silab.nst.dao.UserDao;
import rs.silab.nst.model.UserEntity;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public UserEntity findById(int id) {
        return dao.findById(id);
    }

    public UserEntity findBySSO(String sso) {
        UserEntity user = dao.findBySSO(sso);
        return user;
    }

    public void saveUser(UserEntity user) {
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(UserEntity user) {
//		User entity = dao.findById(user.getId());
//		if(entity!=null){
//			entity.setSsoId(user.getSsoId());
//			entity.setPassword(user.getPassword());
//			entity.setFirstName(user.getFirstName());
//			entity.setLastName(user.getLastName());
//			entity.setEmail(user.getEmail());
//			entity.setUserProfiles(user.getUserProfiles());
//		}
    }


    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    public List<UserEntity> findAllUsers() {
        return dao.findAllUsers();
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        UserEntity user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

}
