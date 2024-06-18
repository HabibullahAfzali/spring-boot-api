package SpringApiJavaApplication.api.controller;

import SpringApiJavaApplication.api.model.User;
import SpringApiJavaApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}

	@GetMapping("/user/id")
	public User getUser(@RequestParam Integer id){
		Optional<User> user = userService.getUser(id);
		return (User) user.orElse(null);
	}
	public List<User> getAllUsers(){

		return userService.getUsers();
	}
}
