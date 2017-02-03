package rs.silab.nst.dao;

import rs.silab.nst.model.Role;

import java.util.List;


public interface UserProfileDao {

    List<Role> findAll();

    Role findByType(String type);

    Role findById(int id);
}
