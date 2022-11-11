import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static api.AdminResource.*;
import static java.lang.String.valueOf;
import static service.ReservationService.*;

public class AdminMenu {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
     /*   IRoom room1=new Room("1",1.0,RoomType.SINGLE);
        addRoom(room1);
        IRoom room2=new Room("2",2.0,RoomType.DOUBLE);
        addRoom(room2);
        IRoom room3=new Room("3",3.0,RoomType.DOUBLE);
        addRoom(room3);
        IRoom room4=new Room("4",4.0,RoomType.DOUBLE);
        addRoom(room4);*/
        boolean flag=true;
        while(flag){
            System.out.println("1. See all Customer");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main menu");
            int n=sc.nextInt();
            switch (n){
                case 1:
                    System.out.println(getAllCustomers());
                    break;
                case 2:
                    System.out.println(getAllRooms());
                    break;
                case 3:
                    displayAllReservation();
                    break;
                case 4:
                    double price = 0;
                    while (true) {
                        System.out.println("Enter a room price :");
                        try {
                            price = Double.parseDouble(sc.next());
                            break; // will only get to here if input was a double
                        } catch (NumberFormatException ignore) {
                            System.out.println("Invalid input");
                        }
                    }
                    System.out.println("Enter roomType(SINGLE/DOUBLE)");
                    String r= sc.next();
                    r=r.toUpperCase();
                    while(!r.equals("SINGLE") && !r.equals("DOUBLE")){
                        System.out.println("in loop");
                         r= sc.next();
                        r=r.toUpperCase();
                    }
                    RoomType roomType=RoomType.valueOf(r.toUpperCase());
                    String noOfRoom = valueOf(listOfRoom.size() + 1);
                   IRoom room=new Room(noOfRoom,price,roomType);
                    addRoom(room);
                    break;
                case 5:
                    flag =false;
                    break;

            }
        }
    }
}
