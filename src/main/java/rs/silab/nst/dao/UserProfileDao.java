package rs.silab.nst.dao;

import rs.silab.nst.model.RoleEntity;

import java.util.List;


public interface UserProfileDao {

    List<RoleEntity> findAll();

    RoleEntity findByType(String type);

    RoleEntity findById(int id);
}
