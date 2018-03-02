package main;

import main.Entities.User;
import main.Entities.UserRoles;
import main.Repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiplomApplicationTests {
	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setName("IgorAdmin");
		user.setEmail("iA@iA");
		user.setUserRole(UserRoles.admin);
		userRepository.save(user);
	}

}
