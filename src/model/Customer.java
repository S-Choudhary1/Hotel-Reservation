package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
     String email;
    public Customer(String firstName,String lastName,String email) throws IllegalArgumentException {
        this.firstName=firstName;
        this.lastName=lastName;
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("This email is not correct");
        }
        this.email=email;
    }
    @Override
    public String toString(){
        return firstName +" "+ lastName +" " + email;
    }
    @Override
    public int hashCode(){
      int hash =11;
      for(int i=0;i<firstName.length();i++){
          hash+=(int)firstName.charAt(i);
      }
        return hash;
    }
    //@Override
    public boolean equals(Customer a){
     if(this.firstName.equals(a.firstName) && this.lastName.equals(a.lastName) && this.email.equals(a.email)){
         return true;
     }
     return false;
    }

}
