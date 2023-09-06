import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RewardsCategory {

/** In redeemRewards() method we construct HashMaps for different reward cartegories
 * and based on the user input, reward points are redeemed and if there are insufficient
 * reward points, a message is displayed.
 *
 * @param  User A registered user
 * */
    public boolean redeemRewards(User user){
        boolean exitOption=true;
        int points;

        ArrayList<String> categories= new ArrayList<>() ;
        categories.add("1.Electronics");
        categories.add("2.Clothing");
        categories.add("3.Gift Cards");
        categories.add("4.exit");

        System.out.println("Here are the Rewards categories to redeem your points:");
        categories.forEach(i-> System.out.println(i));

        System.out.println("Enter your choice:");
        Scanner input=new Scanner(System.in);
        int UserChoice=input.nextInt();

        HashMap<Integer,String> Electronics =new HashMap<>();
        Electronics.put(1,"Mobile Phone : 400 points");
        Electronics.put(2,"Smart Watch : 200 points");

        HashMap<Integer,String> Clothing =new HashMap<>();
        Clothing.put(1,"Ethnic dress : 200 points");
        Clothing.put(2,"Shirts : 100 points");
        Clothing.put(3,"Trousers : 100 points");

        HashMap<Integer,String> GiftCards =new HashMap<>();
        GiftCards.put(1,"Amazon : 2000 points");
        GiftCards.put(2,"Myntra : 1000 points");
        GiftCards.put(3,"Tanishq : 3000 points");

        int choice;

        switch (UserChoice){
            case 1:
                System.out.println("==========================================================================");
                System.out.println("These are the options available under Electronics category: ");
                for(Map.Entry<Integer,String> entry:Electronics.entrySet()){
                    System.out.println(entry.getKey()+ "> "+entry.getValue());
                }
                System.out.println("Please enter your choice:");
                choice=input.nextInt();

                if(choice==1){
                    if((user.getPoints() -400)>0) {
                        points = user.getPoints() - 400;
                        user.setPoints(points);
                        user.giftrewards.add("Electronics -Mobile Phone");
                        System.out.println("You have redeemed 400 points.");
                    }
                    else{
                        System.out.println("Insufficient points to redeem.");
                    }
                }
                if(choice==2){
                    if((user.getPoints() -200)>0) {
                        points = user.getPoints() - 200;
                        user.setPoints(points);
                        user.giftrewards.add("Electronics -Smart Watch");
                        System.out.println("You have redeemed 200 points.");
                    }
                    else{
                        System.out.println("Insufficient points to redeem.");
                    }
                }
                break;
            case 2:
                System.out.println("==========================================================================");
                System.out.println("These are the options available under Clothing category: ");
                for(Map.Entry<Integer,String> entry:Clothing.entrySet()){
                    System.out.println(entry.getKey()+ "> "+entry.getValue());
                }
                System.out.println("Please enter your choice:");
                 choice=input.nextInt();
                if(choice==1){
                    if((user.getPoints() -200)>0) {
                        points = user.getPoints() - 200;
                        user.setPoints(points);
                        user.giftrewards.add("Clothing -Ethnic dress");
                        System.out.println("You have redeemed 200 points.");
                    }
                    else{
                        System.out.println("Insufficient points to redeem.");
                    }
                }
                if(choice==2){
                    if((user.getPoints() -100)>0) {
                        points = user.getPoints() - 100;
                        user.setPoints(points);
                        user.giftrewards.add("Clothing -Shirt");
                        System.out.println("You have redeemed 100 points.");
                    }
                    else{
                        System.out.println("Insufficient points to redeem.");
                    }
                }
                if(choice==3){
                    if((user.getPoints() -100)>0) {
                        points = user.getPoints() - 100;
                        user.setPoints(points);
                        user.giftrewards.add("Clothing -Trouser");
                        System.out.println("You have redeemed 100 points.");
                    } else{
                        System.out.println("Insufficient points to redeem.");
                    }

                }
                break;
            case 3:
                System.out.println("==========================================================================");
                System.out.println("These are the options available under Gift Card category: ");
                for(Map.Entry<Integer,String> entry:GiftCards.entrySet()){
                    System.out.println(entry.getKey()+ "> "+entry.getValue());
                }
                System.out.println("Please enter your choice of Gift card:");
                choice=input.nextInt();
                if(choice==1){
                    if((user.getPoints() -2000)>0) {
                        points = user.getPoints() - 2000;
                        user.setPoints(points);
                        long Coupon=generateRandomNumber();
                        user.giftrewards.add("GiftCards -Amazon");
                        System.out.println("You have redeemed 2000 points.");
                        System.out.println("Here is your AMAZON gift coupon : "+"AMZGFT"+Coupon);
                    }
                    else{
                        System.out.println("Insufficient points to redeem.");
                    }

                }
                if(choice==2){
                    if((user.getPoints() -1000)>0){
                        points = user.getPoints() - 1000;
                        user.setPoints(points);
                        long Coupon=generateRandomNumber();
                        user.giftrewards.add("GiftCards -Myntra");
                        System.out.println("You have redeemed 1000 points");
                        System.out.println("Here is your MYNTRA gift coupon : "+"MYNT"+Coupon);
                    }else{
                        System.out.println("Insufficient points to redeem.");
                    }
                }
                if(choice==3){
                    if((user.getPoints() -3000)>0) {
                        points = user.getPoints() - 3000;
                        user.setPoints(points);
                        long Coupon=generateRandomNumber();
                        user.giftrewards.add("GiftCards -Tanishq");
                        System.out.println("You have redeemed 3000 points");
                        System.out.println("Here is your TANISHQ gift coupon : "+"EASYGOLD"+Coupon);
                    }
                    else{
                        System.out.println("Insufficient points to redeem.");
                    }
                }
                break;
            default:
                exitOption=false;
                System.out.println("==========================================================================");
                System.out.println("See you again...");

                break;
        }

        return exitOption;
    }

    /** generateRandomNumber() method generates and returns random long number.
     * */
public long generateRandomNumber(){
    Random rand = new Random();
    return ThreadLocalRandom.current().nextLong();
    }
}
