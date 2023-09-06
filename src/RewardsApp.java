public class RewardsApp {

	public static void main(String[] args) {
		displayWelcome();
		UserService userService=new UserService();
		UserLoginValidation loginUser=new UserLoginValidation();
		User regUser=loginUser.validateUser(userService);
		if(null!=regUser) {
			Transaction trans = new Transaction(regUser);
			Thread t = new Thread(trans);
			t.start();
		}
		else{
			System.out.println("Please try again later");

		}
	}
	public static void displayWelcome() {
		System.out.println("==========================================================================");
		System.out.println("             Welcome to rewards application.                                      ");
        System.out.println("On every 100/- spent, you will get 1 point as reward.");
        System.out.println("You can redeem these points to purchase items from various categories.");
		System.out.println("==========================================================================");
	}
}
