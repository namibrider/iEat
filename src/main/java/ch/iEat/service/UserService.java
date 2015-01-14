package ch.iEat.service;

/**
 * Database operation service for userRepository interface
 */
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.iEat.entity.Dish;
import ch.iEat.entity.Role;
import ch.iEat.entity.User;
import ch.iEat.repository.DishRepository;
import ch.iEat.repository.RoleRepository;
import ch.iEat.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private DishRepository dishRepository;
	

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithAds(int id) {
		User user = findOne(id);
		List<Dish> dishes = dishRepository.findByCook(user);
		user.setDishes(dishes);
		return user;
	}

	//added Transactional
	@Transactional
	public User findOneWithAds(String name) {
		User user = userRepository.findByName(name);
		return findOneWithAds(user.getId());
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);

		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.delete(id);
	}

	public User findOneByName(String username) {
		return userRepository.findByName(username);
	}

	@Transactional
	public User findOneById(int id) {
		User user = findOne(id);
		List<Dish> dishes = dishRepository.findByCook(user);
		user.setDishes(dishes);
		return user;
	}
	
}
