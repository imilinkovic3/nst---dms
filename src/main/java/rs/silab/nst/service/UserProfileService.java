package rs.silab.nst.service;

import rs.silab.nst.model.RoleEntity;

import java.util.List;


public interface UserProfileService {

	RoleEntity findById(int id);

	RoleEntity findByType(String type);
	
	List<RoleEntity> findAll();
	
}
