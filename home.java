package two;
import two.one.registering;
import java.util.Scanner;

public class home {
    static Scanner sc = new Scanner(System.in);

    public static void login() {
        System.out.println("WELCOME TO THE VEHICLE RENTING COMPANY");
        	System.out.println("1) Register");
        	System.out.println("2) Login");
        int input = sc.nextInt();
        if (input == 1) {
            registering.registration();
	    log();
        }
        if (input == 2) {
	    log();
        }

        if (input != 1 && input != 2) {
            System.out.println("Enter a valid Number for selecting Registration or Log in");
            re_enter();
        }
    }


										//login method start
   public static void log()
	    {
            	System.out.println("1) Login");
            	System.out.println("2) Forgot Password");
            	int LF = sc.nextInt();
            	if (LF == 1) {
                	registering.logging();
            	}
            	if (LF == 2) {
                	registering.forgotpsw();
			log();
            	}
            	if (LF != 1 && LF != 2) {
                	System.out.println("Enter a valid Number from Given");
                	log();
            	}
	    }


									//login method end

									//re enter method start 

    public static void re_enter() {
        System.out.println("1) Register");
        System.out.println("2) Login");
        int input = sc.nextInt();
        if (input == 1) {
            registering.registration();
        }
        if (input == 2) {
            registering.logging();
        }

        if (!(input == 2 || input == 1)) {
            System.out.println("Enter a valid Number for selecting Registration or Log in");
            re_enter();
        }
    }

									

   
}
