import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;
import service.CustomerService;

import java.util.*;
import java.text.*;
import java.util.regex.Pattern;

import static service.CustomerService.getCustomer;
import static service.ReservationService.*;

public class MainMenu {
    public static void main(String[] args) throws ParseException {
         Scanner sc=new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date checkInDate=null,checkOutDate=null;
        boolean flag =true;
        while(flag){
            System.out.println("1. find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
        int n=sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Enter your CheckIn Date(dd/MM/yyyy) :");
                String checkIn=sc.next();
                System.out.println("Enter your check out date(dd/MM/yyyy) :");
                String checkOut=sc.next();
                checkInDate=format.parse(checkIn);
                checkOutDate=format.parse(checkOut);
                findRooms(checkInDate,checkOutDate);

                if(roomList.isEmpty()){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar a = Calendar.getInstance();
                    Calendar b = Calendar.getInstance();
                    a.setTime(checkInDate);
                    a.add(Calendar.DATE, 7); // Adding 7 days
                    b.setTime(checkOutDate);
                    b.add(Calendar.DATE, 7); // Adding 7 days
                    System.out.println("Currently there are no room available.here you can see some recommended rooms for next week");
                    findRooms(a.getTime(),b.getTime());
                }
                for(IRoom room:roomList) {
                    System.out.println(room);
                }
                System.out.println("Enter a room number :");
                String roomNumber=sc.next();
                System.out.println("Enter your email :");
                String email=sc.next();
                Customer customer=getCustomer(email);
                if(customer==null) {
                    System.out.println("Please first create your account");
                   /* System.out.println("Enter your email :");
                    email = sc.next();*/
                    String  emailRegex = "^(.+)@(.+).(.+)$";
                   Pattern pattern = Pattern.compile(emailRegex);
                    while(!pattern.matcher(email).matches()){
                        System.out.println("Please enter your correct email :");
                        email=sc.next();
                    }

                    System.out.println("Enter your first name :");
                    String firstName = sc.next();
                    System.out.println("Enter your last name :");
                    String lastName = sc.next();
                    CustomerService.addCustomer(email, firstName, lastName);
                    System.out.println(getCustomer(email));
                }
                customer=getCustomer(email);
                IRoom room=getARoom(roomNumber);
                reserveARoom(customer,room,checkInDate,checkOutDate);
                System.out.println("Thanks");
                roomList.clear();
                break;
            case 2:
                System.out.println("Enter your email :");
                email = sc.next();
                String emailRegex = "^(.+)@(.+).(.+)$";
                Pattern pattern = Pattern.compile(emailRegex);
                while(!pattern.matcher(email).matches()){
                    System.out.println("Please enter your correct email :");
                    email=sc.next();
                }
                Customer checkCustomer=getCustomer(email);
                System.out.println(getCustomerReservation(checkCustomer));
                break;
            case 3:
                System.out.println("Enter your email :");
                 email = sc.next();
                 emailRegex = "^(.+)@(.+).(.+)$";
                 pattern = Pattern.compile(emailRegex);
                while(!pattern.matcher(email).matches()){
                    System.out.println("Please enter your correct email :");
                    email=sc.next();
                }

                System.out.println("Enter your first name :");
                String firstName = sc.next();
                System.out.println("Enter your last name :");
                String lastName = sc.next();
                CustomerService.addCustomer(email, firstName, lastName);
                System.out.println(getCustomer(email));
                break;
            case 4:
                 AdminMenu.main(args);

                break;
            case 5:
                flag=false;
                break;
        }
        }
    }

}
