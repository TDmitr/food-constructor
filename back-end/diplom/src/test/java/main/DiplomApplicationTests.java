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
		Authority authority = new Authority();
		authority.setAuthority("ROLE_ADMIN");
		String sha256hex = Hashing.sha256()
				.hashString("123", StandardCharsets.UTF_8)
				.toString();
		User user = User.builder()
				.name("IgorAdmin")
				.username("igor@g.g")
				.password(sha256hex)
				.enabled(true)
				.authority(authority)
				.build();
		authorityRepository.save(authority);
		userRepository.save(user);
	}

}
