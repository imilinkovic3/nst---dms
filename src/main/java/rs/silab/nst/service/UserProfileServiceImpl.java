package rs.silab.nst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.silab.nst.dao.UserProfileDao;
import rs.silab.nst.model.Role;

import java.util.List;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao dao;

    public Role findById(int id) {
        return dao.findById(id);
    }

    public Role findByType(String type) {
        return dao.findByType(type);
    }

    public List<Role> findAll() {
        return dao.findAll();
    }
}
