package main;

import com.google.common.hash.Hashing;
import main.Entities.User;
import main.Entities.Authority;
import main.Repositories.AuthorityRepository;
import main.Repositories.UserRepository;
import main.configuration.SHA256PasswordEncoder;
import org.h2.security.SHA256;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;

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
		user.setUsername("igor@g.g");
		user.setEnabled(true);
		user.setAuthority(authority);
		String sha256hex = Hashing.sha256()
				.hashString("123", StandardCharsets.UTF_8)
				.toString();
		user.setPassword(sha256hex);
		authority.setAuthority("ADMIN");
		authority.setUsername("Igor Admin");
		user.setAuthority(authority);
		authorityRepository.save(authority);
		userRepository.save(user);
	}

}
