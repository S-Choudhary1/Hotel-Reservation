package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.*;

public class CustomerService {
    public static Map<String,Customer> customerMap =new HashMap<>();

    public static void addCustomer(String email,String firstName,String lastName){
        customerMap.put(email,new Customer(firstName,lastName,email));
    }
    public static Customer getCustomer(String customerEmail){
         return customerMap.get(customerEmail);
    }
    public static Collection<Customer> getAllCustomer(){
        Collection<Customer> values = customerMap.values();
        return values;
    }
}
