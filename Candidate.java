public class Candidate{
    //private fields
    private String candidateName;
    private String candidateBiography;
    //constructors
    public Candidate(String candidateName, String candidateBiography) {
        this.candidateName = candidateName;
        this.candidateBiography = candidateBiography;
    }

    //default constructor
    public Candidate(){}
    //getters and setters
    public String getCandidateName() {
        return candidateName;
    }

    public String getCandidateBiography() {
        return candidateBiography;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public void setCandidateBiography(String candidateBiography) {
        this.candidateBiography = candidateBiography;
    }
}
