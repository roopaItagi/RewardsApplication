import java.util.Scanner;
public class UserLoginValidation {

	/** validateUser method validates the login credentials entered by the user
	 * and returns User object to the calling method if the user is valid.
	 *
	 * @param  UserService A list of registered users.
	 * */
	public User validateUser(UserService userService)  {
		Scanner scan = new Scanner(System.in);
		boolean loginSuccess = false;
		User regUser=null;
		try {
			System.out.println("Enter Username :");
			String userName = scan.next();
			System.out.println("Enter Password :");
			String userPassword = scan.next();

			for ( User user : userService.users) {
				if (null!=user &&(userName.equalsIgnoreCase(user.getName()) && userPassword.equals(user.getPassword()))) {
					loginSuccess = true;
					System.out.println("==========================================================================");
					System.out.println("You Logged in Successfully.");
					System.out.println("Fetching your points...");
					regUser=user;
					return regUser;
				}

			}
			if (!loginSuccess) {
				InvalidUserException iue = new InvalidUserException("Wrong credentials");
				System.out.println(iue.getMessage());
				throw iue;
			}
		} catch (InvalidUserException e) {
			System.out.println("Please enter correct credentials otherwise you will be BLOCKED");
			System.out.println("==========================================================================");
			try {
				System.out.println("Enter Username :");
				String userName = scan.next();
				System.out.println("Enter Password :");
				String userPassword = scan.next();
				for (User user : userService.users) {
					if (null!=user && (userName.equalsIgnoreCase(user.getName()) && userPassword.equals(user.getPassword()))) {
						loginSuccess = true;
						System.out.println("==========================================================================");
						System.out.println("You have Logged in Successfully.");
						System.out.println("Fetching your points...");
						regUser=user;
						return regUser;
					}
				}
				if (!loginSuccess) {
					InvalidUserException iue = new InvalidUserException("Wrong credentials");
					System.out.println(iue.getMessage());
					throw iue;
				}

			} catch (InvalidUserException ee) {
				System.out.println("You are BLOCKED now");
			}
		} catch (Exception eee) {
			eee.printStackTrace();
		}
		return regUser;
	}
}

