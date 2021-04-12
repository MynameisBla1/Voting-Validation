import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Welcome message
        System.out.println("Welcome to the Peterborough 2022 Election");
        //create an object of VotePersonalIdentification class
        VotePersonalIdentification voters = new VotePersonalIdentification();
        //Scan user input
        Scanner input = new Scanner(System.in);
        //use the do-while loops to get all user valid input, loop until confirmation == true
        Boolean confirmation = false;
        do {
            Boolean check = false; //used to validate user input
            String userInput = " "; //store user input
            int confirm = 0; //used to confirm whether the user enters all the information correctly
            //this do while loop asks the user to enter their last name
            //call validateLastName() method to validate the last name
            //pass true or false to the variable check
            //if check == false, display the string, and ask the user to re-enter their last name
            //until they enter a valid last name
            do {
                System.out.print("Enter your last name: ");
                userInput = input.nextLine();
                check = voters.validateLastName(userInput);
                if (check == false) {
                    System.out.println("*** Invalid Last Name ***");
                }
            } while (check == false);
            voters.setVoterLastName(userInput);
            //this do while loop asks the user to enter their first name
            //call validateFirstName() method to validate the first name
            //pass true or false to the variable check
            //if check == false, display the string, and ask the user to re-enter their first name
            //until they enter a valid first name
            do {
                System.out.print("Enter your first name: ");
                userInput = input.nextLine();
                check = voters.validateFirstName(userInput);
                if (check == false) {
                    System.out.println("*** Invalid First Name ***");
                }
                } while (check == false) ;
                voters.setVoterFirstName(userInput);
            //this do while loop asks the user to enter their SIN number
            //call validateSIN() method to validate the SIN number
            //pass true or false to the variable check
            //if check == false, display the string, and ask the user to re-enter their SIN number
            //until they enter a valid SIN number
           do{
               System.out.print("Enter you SIN number (no spaces): ");
               userInput = input.nextLine();
               check = voters.validateSIN(userInput);
               if (check == false) {
                   System.out.println("*** Invalid SIN Number ***");
               }
           }while (check == false) ;
           int toInt = Integer.parseInt(userInput);
           voters.setVoterSIN(toInt);
            //this do while loop asks the user to enter their postal code
            //call validatePostalCode() method to validate the postal code
            //pass true or false to the variable check
            //if check == false, display the string, and ask the user to re-enter their postal code
            //until they enter a valid postal code
           do{
               System.out.print("Enter your postal code: ");
               userInput = input.nextLine();
               check = voters.validatePostalCode(userInput);
               if (check == false) {
                   System.out.println("*** Invalid Postal Code ***");
                   System.out.println("Valid postal code: A1A 1A1");
               }
           }while(check==false);
           voters.setVoterPostalCode(userInput);
            //Check whether all the information entered correct
           do{
            System.out.println(voters.toString()); //display the information that the user has entered
            System.out.print("Is the above information correct?(1 for Yes, 2 for No): ");
            confirm = input.nextInt(); //get user input
            input.nextLine(); //this prevents the program skipping a .nextLine() when the loop loops again
            //if the user input 1, meaning yes, all the information is correct
            //confirmation = true, call successfullyRegistered() method
            //and get the user a voting ID number
            if (confirm ==1) {
                confirmation = true;
                System.out.println(voters.successfullyRegistered());
                System.out.println("Your voting ID is " + voters.voterID());
            }
            //if the information is incorrect, the user has to re-enter the information
            //confirmation is still false
            else if (confirm == 2) {
                confirmation = false;
                System.out.println("Please re-enter your information.");
            }
            //if the user enters a number that not 1 or 2, then loop again
            else{
                System.out.println("Invalid input. Try again.");
            }
               }while (confirm != 1 && confirm != 2);
        } while (confirmation == false);
        //Create an array of size 3 in Candidate class
        Candidate[] candidates = new Candidate[3];
        //each element of the array contains the candidate's name and their biography
        candidates[0] = new Candidate("Denzel Washington",
                "Don't be afraid to fail.");
        candidates[1] = new Candidate("Russel Crowe",
                "My name is Maximus Decimus Meridius, " +
                        "commander of the Armies of the North, General of the Felix Legions.");
        candidates[2] = new Candidate("Robin Williams","Everyone you meet " +
                "is fighting a batter you know nothing about. Be kind.");
        BallotCreation voteBallot = new BallotCreation(voters,"Peterborough 2022 Election",candidates);
        //call displayBallot() method to display the ballot name, candidates name and their biography
        voteBallot.displayBallot("Candidates for Peterborough 2022 Election",candidates);
        //call submitBallot() method to display whom the voter has voted for
        System.out.println(voteBallot.submitBallot());
        //display the thank you note for voting with the voter's first and last name
        System.out.println("Thank you for your vote, "+voters.getVoterFirstName()+" "
                +voters.getVoterLastName()+".");

    }
}