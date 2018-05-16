package homeWorkDatabase;/*
 * Created by Alexsandr        15.05.2018
 */

import homeWorkDatabase.conector.ConnectionFactory;
import homeWorkDatabase.entity.Flat;
import homeWorkDatabase.service.Service;
import homeWorkDatabase.service.ServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        ConnectionFactory factory = new ConnectionFactory(DB_CONNECTION, DB_USER, DB_PASSWORD);
        Connection connection = factory.getconnection();

        Service service = new ServiceImpl(connection);
        service.init();
        service.addFlat(new Flat(0, "centr", "Lenina", 93.5, 3, 2000.30));
        System.out.println();

        List<Flat> list = service.getFlatByPriceAndNumberOfRooms(1000, 30000, 4);
       for (Object o:list){
           Flat flat = (Flat) o;
           System.out.println(flat);
       }


    }
}