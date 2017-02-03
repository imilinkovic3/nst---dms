package rs.silab.nst.dao;

import rs.silab.nst.model.RoleEntity;

import java.util.List;

public interface RoleDao {
    public List<RoleEntity> findAllRoles();
}
