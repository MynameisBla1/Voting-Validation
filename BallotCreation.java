import java.util.Scanner;

public class BallotCreation extends VotePersonalIdentification{
    //private fields
    private String ballotName;
    private Candidate[] candidates = new Candidate[0];
    //default constructor
    public BallotCreation(){

    }
    //constructors
    public BallotCreation(VotePersonalIdentification voters, String ballotName, Candidate[] candidates){
        super.setVoterLastName(voters.getVoterLastName());
        super.setVoterFirstName(voters.getVoterFirstName());
        super.setVoterSIN(voters.getVoterSIN());
        super.setVoterPostalCode(voters.getVoterPostalCode());
        this.ballotName = ballotName;
        this.candidates = candidates;
    }
    public BallotCreation(String ballotName, Candidate[] candidates) {
        this.ballotName = ballotName;
        this.candidates = candidates;
    }
    //getters and setters
    public String getBallotName() {
        return ballotName;
    }

    public Candidate[] getCandidates() {
        return candidates;
    }

    public void setBallotName(String ballotName) {
        this.ballotName = ballotName;
    }

    public void setCandidates(Candidate[] candidates) {
        this.candidates = candidates;
    }
    //submitBallot() method, displays whom the voter voted for
    //make do while loop until user enter a valid vote, then i=1
    public String submitBallot(){
        Scanner userInput = new Scanner(System.in);
        //prompt the user input
        System.out.println("Voting for your candidate by entering the number corresponding to them");
        int i = 0;
        do{
            System.out.print("Who would you like to vote for? ");
            int voteNum = userInput.nextInt(); //get user input
            switch(voteNum){
                //if the user votes for the first candidate, meaning they enter 0
                //then display the string with the first candidate's name, and so on
                case 0:
                    System.out.println("You have voted for "+candidates[0].getCandidateName());
                    i=1;
                    break;
                case 1:
                    System.out.println("You have voted for "+candidates[1].getCandidateName());
                    i=1;
                    break;
                case 2:
                    System.out.println("You have voted for "+candidates[2].getCandidateName());
                    i=1;
                    break;
                    //if the user enters a number rather than 0-2 then ask user to enter again
                default:
                    System.out.println("Invalid number. Try again.");
            }
        }while(i==0);
        return "Your vote has saved into the system.";
    }
    //displayBallot() method, used to display candidates name and biography
    public void displayBallot(String ballotName,Candidate candidates[]){
        System.out.println(ballotName);
        for (int i=0; i<candidates.length;i++){
            System.out.println("["+i+"]\n"+"Candidate Name: "+candidates[i].getCandidateName()+
                    "\nBiography: "+candidates[i].getCandidateBiography());
        }
    }
}
