package rs.silab.nst.dao;

import rs.silab.nst.model.User;


public interface UserDao {

    // User findById(int id);

    //  User findBySSO(String sso);

    void save(User user);

    // void deleteBySSO(String sso);

    //  List<User> findAllUsers();

    User findByUsername(User user);

    User findByEmail(String email);
}

