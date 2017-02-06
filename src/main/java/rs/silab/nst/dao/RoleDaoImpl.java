package rs.silab.nst.dao;

import org.springframework.stereotype.Repository;
import rs.silab.nst.model.Role;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    @SuppressWarnings("unchecked")
    public List<Role> findAllRoles() {
        List<Role> roles = getEntityManager()
                .createQuery("SELECT r FROM Role r ORDER BY r.name ASC")
                .getResultList();
        return roles;
    }

}
