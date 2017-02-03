package rs.silab.nst.service;

import rs.silab.nst.model.UserEntity;

import java.util.List;


public interface UserService {
	
	UserEntity findById(int id);
	
	UserEntity findBySSO(String sso);
	
	void saveUser(UserEntity user);
	
	void updateUser(UserEntity user);
	
	void deleteUserBySSO(String sso);

	List<UserEntity> findAllUsers();
	
	boolean isUserSSOUnique(Integer id, String sso);

}