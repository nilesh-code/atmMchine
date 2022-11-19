package design;

import model.UserDetails;
import org.springframework.stereotype.Component;
import utils.AccountUtils;

import java.util.Scanner;

@Component
public class ATMDesign {
    double atmCash = 200000.0, withdraw, deposit;
    long atmNo;
    int cvv;
    String expiry;
    int count = 0, pin;

    public void design() throws Exception {


        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a card");

        System.out.println("Please Enter a ATM Number:");
        atmNo = sc.nextLong();
        System.out.println("Please Enter a cvv");
        cvv = sc.nextInt();
        System.out.println("Please Enter a expiry");
        expiry = sc.next();
        UserDetails userDetails = AccountUtils.getUserDetailsData(atmNo);
        double totalBalance = 0.0;

        if (null!=userDetails && userDetails.getValidCardDetails(atmNo, cvv, expiry)) {

            totalBalance=userDetails.getBalance();
            if(getLogin(userDetails,sc))

                while (true) {

                System.out.println("ATM MACHINE");
                System.out.println("Select 1 for WITHDRAW");
                System.out.println("Select 2 for DEPOSIT");
                System.out.println("Select 3 for BALANCE CHECK");
                System.out.println("Select 4 for EXIT");
                System.out.println("Select the option:");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        if (atmCash >= totalBalance) {
                            System.out.println("Enter money to be withdrawn:");
                            withdraw = sc.nextDouble();
                                getWithdraw(userDetails,withdraw);
                        } else {
                            System.out.println("ATM MACHINE TEMPRORILY OUT OF SERVICE");
                        }
                        break;

                    case 2:
                        System.out.println("Enter money to be deposit");
                        deposit = sc.nextDouble();
                        getDeposit(userDetails);
                        break;

                    case 3:
                        getBalance(userDetails);
                        break;

                    case 4:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice entered");
                }
            }
        } else {
            System.out.println("Card details are incorrect");
        }
    }


    public boolean getLogin(UserDetails userDetails,Scanner sc){
        while (count < 4) {
            count++;

            System.out.println("Enter the 4 digit pin:");
            pin = sc.nextInt();

            if (userDetails.getPin() == pin) {
                System.out.println("Welcome " + userDetails.getUserName());
                break;
            } else {
                System.out.println("Invalid pin");
            }
        }
        if (count == 4) {
            System.out.println("Your Card is blocked..");
            return false;
        }
        return true;
    }

    public void getDeposit(UserDetails userDetails){
        userDetails.setBalance(userDetails.getBalance() + deposit);
        System.out.println(deposit + " rupees deposited successfully");
    }

    public void getWithdraw(UserDetails userDetails,double withdraw){
        double totalBalance=userDetails.getBalance();
        if (totalBalance >= withdraw) {
            userDetails.setBalance(totalBalance - withdraw);
            System.out.println(withdraw + " rupees withdraw successfully");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void getBalance(UserDetails userDetails){
        System.out.println("Available Balance:" + userDetails.getBalance());
    }


}
