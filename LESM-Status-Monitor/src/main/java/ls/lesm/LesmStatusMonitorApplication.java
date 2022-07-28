package ls.lesm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ls.lesm.payload.response.ForeignkeyResponse;
import ls.lesm.repository.AddressRepositoy;

@SpringBootApplication
public class LesmStatusMonitorApplication  implements CommandLineRunner {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	public static void main(String[] args) {
		SpringApplication.run(LesmStatusMonitorApplication.class, args);
		
	}	
		
	
	@Override
	public void run(String... args) throws Exception{
		
		
		
		
		
		/*System.out.println("execution start");
		
		User user=new User();
		
		user.setEmail("user1@gmail.com");
		user.setFirstName("test");
		user.setLastName("user");
		
		user.setPhoneNo("7350957167");
		user.setPassword(bCryptPasswordEncoder.encode("user"));
		user.setUsername("user");
		
		Role role=new Role();
		role.setRoleId(11);
		role.setRoleName("USER");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		System.out.println("exc end");*/

}
}
