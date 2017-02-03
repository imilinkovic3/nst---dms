package rs.silab.nst.dao;

import org.springframework.stereotype.Repository;
import rs.silab.nst.model.RoleEntity;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, RoleEntity> implements RoleDao {

    @SuppressWarnings("unchecked")
    public List<RoleEntity> findAllRoles() {
        List<RoleEntity> roles = getEntityManager()
                .createQuery("SELECT r FROM Role r ORDER BY r.name ASC")
                .getResultList();
        return roles;
    }

}
