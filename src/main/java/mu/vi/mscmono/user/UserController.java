package mu.vi.mscmono.user;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mu.vi.mscmono.Exceptions.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userDao;
	
	@GetMapping(path = "users")
	public ArrayList<UserBean> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@GetMapping(path = "users/{id}")
	public UserBean getUserById(@PathVariable int id)
	{
		UserBean user=userDao.getUserById(id);
		if(user==null)
		{
			throw new UserNotFoundException("User "+id+" Not Found");
		}
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<UserBean> createUser(@RequestBody UserBean user) {
		UserBean savedUser =userDao.createUser(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
