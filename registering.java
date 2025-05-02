package two.one;

import java.util.*;

public class registering {
    static String name;
    static String email;
    private static String pass;
    static String RE_pass;
    public static Scanner sc = new Scanner(System.in);

													//registration part start

    public static void registration() {
        System.out.println("Please enter your Name");
        name = sc.next().trim(); 
	boolean s=cn();
	if(s==true)
	{
        System.out.println("Please enter your email");
        email = sc.next().trim(); 
	boolean e=ce();
	if(e==true)
	{
        System.out.println("Please set your password -(Must satisfy all conditions of password setup)");
        pass = sc.next().trim(); 
	boolean p=cp();
	if(p==true)
	{
        System.out.println("***** REGISTRATION SUCCESSFUL *****");
	}
	else
	{
		System.out.println("*** PLEASE SATISFY ALL CONDITIONS OF PASSWORD ***");
		System.out.println("Password must contain a Capital letter");
		System.out.println("Password must contain a samll letter");
		System.out.println("Password must contain a special character");
		System.out.println("Password must contain a digit");
		System.out.println("------ REGISTER AGAIN ------");
		System.out.println();
		registration();
	}
	}
	else
	{
		System.out.println("*** PLEASE ENTER EMAIL PROPERLY ***");
		System.out.println();
		System.out.println("------ REGISTER AGAIN ------");
		System.out.println();
		registration();
	}
	}
	else
	{
		System.out.println("*** PLEASE ENTER NAME PROPERLY ***");
		System.out.println();
		System.out.println("------ REGISTER AGAIN ------");
		System.out.println();
		registration();
	}
    }

													//registration part end
													
													//login part start
   
 public static void logging() {
        System.out.println("Please enter your email");
        String mail = sc.next().trim(); 
	if(mail.equals(email)){
        	System.out.println("Please enter your password");
        	String inputPass = sc.next().trim(); 

        	if (mail.equals(email) && inputPass.equals(pass)) {
            	System.out.println("***** LOGIN SUCCESSFUL *****");
        	} 
		else {
            		System.out.println("*** INVALID EMAIL OR PASSWORD ***");		
        	}
	}
	else
	{
		System.out.println("*** USER ACCOUNT NOT FOUND ***");
		logging();
	}
    }
	
													//login part end



													//forgot password part start

    public static void forgotpsw() {
        System.out.println("Please enter your email");
        String mail_f = sc.next().trim(); 

													//OTP part start 	
        int OTP;
        if (mail_f.equals(email)) {
            Random r = new Random();
            OTP = 1000 + r.nextInt(9000);
            System.out.println("Sending OTP to " + email);
            System.out.println("\n***** please wait *****\n");
            System.out.println("Your OTP is: " + OTP);
        } 
	else {
            System.out.println("Email does not match.");
            return;
        }

        System.out.print("Enter OTP  : ");
        int E_OTP = sc.nextInt();
        sc.nextLine(); 

        if (E_OTP == OTP) {
              otp();
	      reEnter();
        } 
	else {
            System.out.println("*** INVALID OTP ***");
        }
    }

													//OTP part end

													//forgot password part end 

													//setter method 
    public void set(String pass) {
        registering.pass = pass;
    }



													//getter method
    public String get() {
        return pass;
    }




													//password entering method start 
    static void otp()
	{	
		System.out.print("Enter New Password : ");
           	 registering ex = new registering();
                 ex.set(sc.next().trim());
	    System.out.println(); 
            System.out.print("Re-Enter Password  : ");
             RE_pass = sc.next().trim();
	    System.out.println();
	    
	}

													//password entering method end 

													// re enter method start
    static void reEnter()
    {
     	if (RE_pass.equals(pass)) {
                System.out.println("***** PASSWORD CHANGED SUCCESSFULLY *****");
            } 
	    else {
                System.out.println("*** PASSWORD DID NOT MATCH ***");
			otp();
		 if (RE_pass.equals(pass)) {
                	System.out.println("***** PASSWORD CHANGED SUCCESSFULLY *****");
            	}
		else
		{
			System.out.println("*** PASSWORD DID NOT MATCH ***");
			otp();
		 	if (RE_pass.equals(pass)) {
                		System.out.println("***** PASSWORD CHANGED SUCCESSFULLY *****");
            		}	
		}	
           }
     }

													//re enter method end

	public static Boolean cn(){
		for(int i=0;i<name.length();i++)
		{
			char c=name.charAt(i);
			if(c>='0' && c<='9')
			{
				return false;
			}
		}
		return true;
	}
	


	public static boolean cp() {
    		boolean hasUpper = false;
    		boolean hasDigit = false;
    		boolean hasSpecial = false;
		boolean hassmall = false;
    		if (pass.length() < 8) {
        		return false; // Too short
    		}

    		for (int i = 0; i < pass.length(); i++) {
        		char c = pass.charAt(i);

        		if (c >= 'A' && c <= 'Z') {
            			hasUpper = true;
        		} 
			else if (c >= '0' && c <= '9') {
            			hasDigit = true;
        		} 
			else if (c>='a' && c<='z')
			{
				hassmall=true;
			}
			else if (!( (c >= 'A' && c <= 'Z') || 
                                (c >= 'a' && c <= 'z') ||(c>='a' && c<='z') || 
                                (c >= '0' && c <= '9') )) {
            			hasSpecial = true;
        		}
    		}

    		return hasUpper && hasDigit && hasSpecial && hassmall;
	}

	
	

    public static boolean ce() {
        String suffix = "@gmail.com";  // required ending
        int el = email.length();
        int sl = suffix.length();

        // If email is shorter than domain, it cannot be valid
        if (el < sl) {
            return false;
        }

        // Compare characters one by one from the end
        for (int i = 0; i < sl; i++) {
            // Check if characters at the end of email match the domain
            if (email.charAt(el - sl + i) != suffix.charAt(i)) {
                return false; // mismatch found
            }
        }

        return true; // all characters matched, it's a valid Gmail
    }



}
