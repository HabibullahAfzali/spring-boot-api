package SpringApiJavaApplication.api.controller;

import SpringApiJavaApplication.api.model.User;
import SpringApiJavaApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://192.168.1.181:8080/")
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

	@GetMapping()
	public List<User> getAllUsers(){

		return userService.getUsers();
	}
}
