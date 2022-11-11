package api;

import model.Customer;
import model.IRoom;

import java.util.*;

import static service.CustomerService.customerMap;
import static service.CustomerService.getAllCustomer;
import static service.ReservationService.listOfRoom;
import static service.ReservationService.printAllReservation;

public class AdminResource {
    public static Customer getCustomer(String email){
        return customerMap.get(email);
    }
    public static void addRoom(List<IRoom> rooms){
        listOfRoom.addAll(rooms);
    }
    public static Collection<IRoom> getAllRooms(){
         return listOfRoom;
    }
    public static Collection<Customer> getAllCustomers(){
         return getAllCustomer();
    }
    public static void displayAllReservation(){
        printAllReservation();
    }
}
