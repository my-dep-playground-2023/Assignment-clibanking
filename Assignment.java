import java.util.Scanner;

public class Assignment {
private static final Scanner Scanner=new Scanner(System.in);
public static void main(String[] args) {
    
    final String CLEAR = "\033[H\033[2J";
    final String COLOR_BLUE_BOLD = "\033[34;1m";
    final String COLOR_RED_BOLD = "\033[31;1m";
    final String COLOR_GREEN_BOLD = "\033[33;1m";
    final String RESET = "\033[0m";
    final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
    final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

    final String DASHBOARD = "💵 Welcome to Smart Banking";
    final String CREATE_NEWACCOUNT = "➕ Create New Account";
    final String DEPOSITS = "DEPOSITS";
    final String WITHDRAWS = "🖨 WITHDRAWS";
    final String TRANSFERS = "🖨 TRANSFERS";
    final String CHECK_ACCOUNT_BALANCE = "🖨 CHECK ACCOUNT BALANCE";
    final String DELETE_ACCOUNT = "🖨 DELETE ACCOUNT";

    String screen=DASHBOARD;
do{
    final String APP_TITLE = String.format("%s%s%s",COLOR_BLUE_BOLD, screen, RESET);
    System.out.println(CLEAR);
    System.out.println("\t" + APP_TITLE + "\n");
     switch(screen){


        case DASHBOARD:
        
        System.out.println("\t[1]. Create New Account");
        System.out.println("\t[2]. Deposits");
        System.out.println("\t[3]. Withdrawals");
        System.out.println("\t[4]. Transfer");
        System.out.println("\t[5]. Print Statement");
        System.out.println("\t[6]. Delete Account");
        System.out.println("\t[7]. Exit");
        System.out.print("\tEnter an option to continue: ");

        int option=Scanner.nextInt();
        Scanner.nextLine();
        System.out.println(option);

        switch (option) {
            
                case 1: screen = CREATE_NEWACCOUNT; break;
                case 2: screen = DEPOSITS; break;
                case 3: screen = WITHDRAWS; break;
                case 4: screen = TRANSFERS; break;
                case 5: screen = CHECK_ACCOUNT_BALANCE; break;
                case 6: screen = DELETE_ACCOUNT; break;
                case 7: System.out.println(CLEAR); System.exit(0);
                default: continue;
            }
            break;
            
        

        case CREATE_NEWACCOUNT:
        //-------
        String [][] customers=new String[0][];
        
         String id;
         String Name;
         double Deposits;
         do{

            ///iD validation

            boolean valid;
            idValidation: do {
                valid = true;
                System.out.println("\n\tID format=SDB-####");
                System.out.print("\tID: ");
                id = Scanner.nextLine().strip();

                /* Empty */
                if (id.isEmpty()) {
                    valid = false;
                    System.out.printf(ERROR_MSG, "ID Can't be empty");
                    continue;
                }

                /* Format */
                if (!id.startsWith("SDB-") || id.length() != 8) {
                    valid = false;
                    System.out.printf(ERROR_MSG, "Invalid ID format");
                    continue;
                } else {
                    // 
                    String numberPart = id.substring(5);
                    for (int i = 0; i < numberPart.length(); i++) {
                        if (!Character.isDigit(numberPart.charAt(i))) {
                            valid = false;
                            System.out.printf(ERROR_MSG, "Invalid ID format");
                            continue idValidation;
                        }
                    }
                }

                /* Already Exists */
                for (int row = 0; row < customers.length; row++) {
                    if (customers[row][0].equals(id)) {
                        valid = false;
                        System.out.printf(ERROR_MSG, "ID already exists");
                        continue idValidation;
                    }
                }
            } while (!valid);

        /////////////////////////////////////////

         

         /////////////////////////////////////////
         nameValidation: do {
            valid = true;
            System.out.print("\tEnter Name: ");
            Name = Scanner.nextLine().strip();

            /* Empty */
            if (Name.isEmpty()) {
                valid = false;
                System.out.printf(ERROR_MSG, "Name can't be empty");
                continue;
            }

            /* Format */
            for (int i = 0; i < Name.length(); i++) {
                if (!(Character.isLetter(Name.charAt(i)) ||
                        Character.isSpaceChar(Name.charAt(i)))) {
                    valid = false;
                    System.out.printf(ERROR_MSG, "Invalid Name");
                    continue nameValidation;
                }
            }
        } while (!valid);
         /////////////////////////////////////////////////
         do {
            valid = true;
            System.out.print("\tDeposite Amount: ");
            Deposits = Scanner.nextDouble();
            Scanner.nextLine();

            /* Range */
            if (Deposits < 3500) {
                valid = false;
                System.out.printf(ERROR_MSG, "Insufficient Deposite");
            }
        } while (!valid);

         ////////////////////////////////////////////////
      
        

     

         String[][] newcustomers=new String[customers.length+1][3];
         for (int i = 0; i < customers.length; i++) {
            newcustomers[i]=customers[i];
         }

         newcustomers[newcustomers.length-1][0]=id;
         newcustomers[newcustomers.length-1][1]=Name;
         newcustomers[newcustomers.length-1][2]=""+Deposits;

         customers=newcustomers;

         System.out.println();
         System.out.print("\tDetails added sucessfully.\n\tDo you want to add new Account (Y/n)? ");
         if (Scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
         screen = DASHBOARD;
         break;
                  
        }while(true);
        //-------
         
        
      
        // case DEPOSITS:
        // System.out.println();
        // break;
        // case WITHDRAWS:
        // System.out.println();
        // break;
        // case TRANSFERS:
        // System.out.println();
        // break;
        // case CHECK_ACCOUNT_BALANCE:
        // System.out.println();
        // break;
        // case DELETE_ACCOUNT:
        // System.out.println();
        // break;
    }


     

}while(true);


}
    
}