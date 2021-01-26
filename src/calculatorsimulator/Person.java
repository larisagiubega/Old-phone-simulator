/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorsimulator;

/**
 *
 * @author laris
 */
public class Person {
    
    public String firstName, lastName;
    public String address;
    public String number;
    
    public Person(String fName, String lName, String add, String no){
        firstName=fName;
        lastName=lName;
        address=add;
        number=no;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getNumber(){
        return number;
    }
    
}
