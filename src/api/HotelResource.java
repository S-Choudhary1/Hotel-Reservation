package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.*;

import static service.CustomerService.addCustomer;
import static service.CustomerService.customerMap;
import static service.ReservationService.*;

public class HotelResource {
    public static Customer getCustomer(String email){
              return customerMap.get(email);
    }
    public void createACustomer(String email,String firstName,String lastName){
          addCustomer(email, firstName, lastName);
    }
    public static IRoom getRoom(String roomNumber){
        return listOfRoom.get(Integer.parseInt(roomNumber));

    }
    public Reservation bookARoom(String customerEmail,IRoom room,Date checkInDate,Date checkOutDate){
        Customer customer=customerMap.get(customerEmail);
        return reserveARoom(customer,room,checkInDate,checkOutDate);
    }
    public Collection<Reservation> getCustomersReservation(String customerEmail){
        Customer customer=customerMap.get(customerEmail);
        return (Collection<Reservation>) customerReservationMap.get(customer);
    }
    public static Collection<IRoom> findARoom(Date checkIn,Date CheckOut){
        return roomList;
    }
}
