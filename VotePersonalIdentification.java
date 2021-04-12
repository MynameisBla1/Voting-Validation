public class VotePersonalIdentification {
    //private fields
    private String voterLastName;
    private String voterFirstName;
    private Integer voterSIN;
    private String voterAddress;
    private String voterProvince;
    private String voterCity;
    private String voterPostalCode;
    //constructor
    public VotePersonalIdentification(String voterLastName, String voterFirstName, Integer voterSIN,
                                      String voterAddress, String voterProvince, String voterCity,
                                      String voterPostalCode){
        this.voterLastName = voterLastName;
        this.voterFirstName = voterFirstName;
        this.voterSIN = voterSIN;
        this.voterAddress = voterAddress;
        this.voterProvince = voterProvince;
        this.voterCity = voterCity;
        this.voterPostalCode = voterPostalCode;
    }
    //default constructor
    public VotePersonalIdentification(){

    }
    //toString() method, used to display the voter personal identification
    public String toString(){
            return "Voter Personal Identification:"+"\nName: "+voterFirstName + " " + voterLastName +
                    "\nSIN number: "+voterSIN+ "\nPostal Code: " + voterPostalCode;
    }
    /*
    [a-zA-Z]* - input begins with characters;
    [\\s]{1} - contains only one space;
    [a-zA-Z].* - ends with at least one character.
    */
    //allows a-z in upper and lower case for the voter's last name
    public Boolean validateFirstName(String voterFirstName){
        return voterFirstName.matches("[a-zA-Z]*");
    }
    //allows a-z in upper and lower case for the voter's first name
    public Boolean validateLastName(String voterLastName){
        return voterLastName.matches("[a-zA-Z]*");
    }
    //allows numbers for SIN number and it needs to be a 9 digit number
    public Boolean validateSIN(String voterSIN){
        return voterSIN.matches("^[\\d+]{9}+$");
    }
    //allows a-z in letters and numbers for postal code
    /*
    A valid canadian postcode is –
    in the format A1A 1A1, where A is a letter and 1 is a digit.
    a space separates the third and fourth characters.
    do not include the letters D, F, I, O, Q or U.
    the first position does not make use of the letters W or Z.
     */
    public Boolean validatePostalCode(String voterPostalCode){
        return voterPostalCode.matches("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$");
    }
    //public method that return a string to let user know that they have registered successfully
    public String successfullyRegistered(){
        return "Successfully Registered";
    }
    //public method that return voterID number
    //each voter has different voting number, first voter starting with 100000.
    //And the next would have the number of 100001. However, this program we interact
    //with one voter only, so the voterID will always be 100000 in this case.
    public String voterID(){
        int count = 100000;
        Integer ID = new Integer(count);
        String voterID = ID.toString(count++);
        return voterID;
    }
    //getters and setters
    public String getVoterLastName() {
        return voterLastName;
    }

    public String getVoterFirstName() {
        return voterFirstName;
    }

    public Integer getVoterSIN() {
        return voterSIN;
    }

    public String getVoterAddress() {
        return voterAddress;
    }

    public String getVoterProvince() {
        return voterProvince;
    }

    public String getVoterCity() {
        return voterCity;
    }

    public String getVoterPostalCode() {
        return voterPostalCode;
    }

    public void setVoterLastName(String voterLastName) {
        this.voterLastName = voterLastName;
    }

    public void setVoterFirstName(String voterFirstName) {
        this.voterFirstName = voterFirstName;
    }

    public void setVoterSIN(Integer voterSIN) {
        this.voterSIN = voterSIN;
    }

    public void setVoterAddress(String voterAddress) {
        this.voterAddress = voterAddress;
    }

    public void setVoterProvince(String voterProvince) {
        this.voterProvince = voterProvince;
    }

    public void setVoterCity(String voterCity) {
        this.voterCity = voterCity;
    }

    public void setVoterPostalCode(String voterPostalCode) {
        this.voterPostalCode = voterPostalCode;
    }
}
