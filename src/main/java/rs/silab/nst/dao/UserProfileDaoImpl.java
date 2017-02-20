package rs.silab.nst.dao;

import org.springframework.stereotype.Repository;
import rs.silab.nst.model.Role;


@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, Role> implements UserProfileDao {

}
