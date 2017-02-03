package rs.silab.nst.dao;

import rs.silab.nst.model.UserEntity;

import java.util.List;


public interface UserDao {

    UserEntity findById(int id);

    UserEntity findBySSO(String sso);

    void save(UserEntity user);

    void deleteBySSO(String sso);

    List<UserEntity> findAllUsers();

}

