package ecms.placement.portal.service;

import java.util.List;

import ecms.placement.portal.model.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

	List<User> findAll();

	void delete(long id);

	User findOne(String username);

	User findById(Long id);
}
