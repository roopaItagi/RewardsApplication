import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Transaction implements Runnable{

	/** run() method of Runnable interface is implemented to generate
	 * reward points for registered user and redeem the points based on
	 * user input.
	 * */
	User user;
	Transaction(User user){
		this.user=user;
	}
		
	public void run() {
		boolean flag = true;
			try {
				RewardsCategory rewards = new RewardsCategory();
				Random rand = new Random();
				int max = 1000000;
				int min = 500000;
				int randomAmount = ThreadLocalRandom.current().nextInt(min, max);
				user.setAmount(randomAmount);
				Thread.sleep(5000);
				System.out.println("==========================================================================");
				System.out.println("Your total transaction amount is: " + user.getAmount());
				int points = randomAmount / 100;
				user.setPoints(points);

				boolean exitOption=true;
				while (flag) {
					System.out.println("Total Redeemable points: " + user.getPoints());
					System.out.println("==========================================================================");
					exitOption=rewards.redeemRewards(user);

					if(!user.giftrewards.isEmpty()) {
						System.out.println("==========================================================================");
						int redeemedPoints=points-user.getPoints();
						System.out.println("You have redeemed "+ redeemedPoints+" points under following categories");
						user.giftrewards.forEach(System.out::println);
					}

					System.out.println();
					System.out.println("You have " + user.getPoints() + " reward points remaining");
					System.out.println("==========================================================================");
					if(user.getPoints()>0) {
						if(!exitOption){
							flag=false;
						}
						else {
							System.out.println("Do you want to redeem more points: Y/N ");
							Scanner input = new Scanner(System.in);
							String playAgain = input.next();
							if (playAgain.equalsIgnoreCase("y"))
								flag = true;
							else if (playAgain.equalsIgnoreCase("n"))
								flag = false;
							else {
								System.out.println("Invalid input..Try again");
							}
						}
					}
					else{
						System.out.println("You do not have any points left to redeem.");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			catch(InputMismatchException mismatchException){
				System.out.println("Invalid input.Enter integer values");
			}
	}
	
}
