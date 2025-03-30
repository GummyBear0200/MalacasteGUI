
package config;


public class Session {
   
    public static Session instance;
    private int uid;
    private String Fname;
    private String Lname;
    private String Contactnum;
    private String RegPass;   
    private String SecurityQuestion;
    private String answer;
    private String PIN;
    private String email;
    private String username;
    private String type;
    private String status;
    
        
    private Session(){
    
}
    
    public static synchronized Session getInstance(){
       if(instance == null){ 
        instance = new Session();
    }
       return instance;
}
    public static boolean isInstanceEmpty(){
        return instance == null;
    }
     public int getuid(){
    return uid;
    }
    
    public void setuid(int uid){
    this.uid = uid;
            }
    public String getFname(){
    return Fname;
    }
    
    public void setFname(String Fname){
    this.Fname = Fname;
            }
     public String getLname(){
    return Lname;
    }
     public void setContact(String contact) {
        this.Contactnum = contact;
    }

    public String getContact() {
        return Contactnum;
    }
    public void setLname(String Lname){
    this.Lname = Lname;
            } 
     public String getemail(){
    return email;
    }
    
    public void setemail(String email){
    this.email = email;
            } 
     public String getusername(){
    return username;
    }
     public void setPassword(String Contactnum) {
        this.RegPass = Contactnum;
    }

    public String getPassword() {
        return RegPass;
    }
    public void setusername(String username){
    this.username = username;
            } 
     public String gettype(){
    return type;
    }
    
    public void settype(String type){
    this.type = type;
            }
     public String getStatus(){
    return status;
    }
    
    public void setStatus(String status){
    this.status = status;
            }
    
    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String SecurityQuestion) {
        this.SecurityQuestion = SecurityQuestion;
    }
    
     public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
     public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}
