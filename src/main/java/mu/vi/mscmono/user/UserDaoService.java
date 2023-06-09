package mu.vi.mscmono.user;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static ArrayList<UserBean> users=new ArrayList<UserBean>();
	public static int uniqueId=1;
	static {
		users.add(new UserBean(uniqueId++,"Vicky Dhakar",LocalDate.now().minusYears(22)));
		users.add(new UserBean(uniqueId++,"Muskan Dhakar",LocalDate.now().minusYears(25)));
		users.add(new UserBean(uniqueId++,"Golu Bandil",LocalDate.now().minusYears(15)));
	}
	
	public ArrayList<UserBean> getAllUsers(){
		return users;
	}
	
	public UserBean getUserById(int id) {
		return users.stream().filter(t ->t.getId()==id ).findFirst().orElse(null);
	}
	public UserBean createUser(UserBean user) {
		user.setId(uniqueId++);
		users.add(user);
		return user;
	}
}
