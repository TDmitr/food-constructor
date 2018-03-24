package main;

import main.Entities.User;
import main.Entities.Authority;
import main.Repositories.AuthorityRepository;
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

	@Autowired
	AuthorityRepository authorityRepository;

	@Test
	public void contextLoads() {
		User user = new User();
		Authority authority = new Authority();
		user.setName("IgorAdmin");
		user.setEmail("iA@iA");
		user.setEnabled(true);
		user.setAuthority(authority);
		user.setPassword("123");
		authority.setAuthority("ADMIN");
		authority.setUsername("Igor Admin");
		//user.setAuthority();
		authorityRepository.save(authority);
		userRepository.save(user);
	}

}
