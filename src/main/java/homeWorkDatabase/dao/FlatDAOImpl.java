package homeWorkDatabase.dao;/*
 * Created by Alexsandr        15.05.2018
 */


import homeWorkDatabase.entity.Flat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlatDAOImpl implements FlatDAO {
    private final Connection conn;

    public FlatDAOImpl(Connection connection){
        this.conn = connection;
    }

@Override
    public void init() {
        try {
            Statement st = conn.createStatement();
            try {
              //  st.execute("DROP TABLE IF EXISTS Flat");
                st.execute(" CREATE TABLE IF NOT EXISTS Flat" +
                        "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, district VARCHAR(20), adress varchar(40), area double," +
                        "countRoom int, price double)");
            } finally {
                st.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void addFlat(Flat flat) {
        try (PreparedStatement preparedStatement = conn.prepareStatement
                ("INSERT into flat(district, adress, area, countRoom, price) VALUES (?,?,?,?,?)")){
            preparedStatement.setString(1, flat.getDistrict());
            preparedStatement.setString(2, flat.getAdress());
            preparedStatement.setDouble(3, flat.getArea());
            preparedStatement.setInt(4, flat.getCountRoom());
            preparedStatement.setDouble(5, flat.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flat> getFlatByPriceAndNumberOfRooms(int from, int to, int countRooms) {
        List<Flat> flatsList = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            try (ResultSet rs = st.executeQuery
                    ("SELECT * FROM Flat WHERE price >" + from + " AND price < "+to+" AND  countRoom = "+countRooms)) {
                while (rs.next()) {
                    Flat flat = new Flat();
                    flat.setId(rs.getInt(1));
                    flat.setDistrict(rs.getString(2));
                    flat.setAdress(rs.getString(3));
                    flat.setArea(rs.getDouble(4));
                    flat.setCountRoom(rs.getInt(5));
                    flat.setPrice(rs.getDouble(6));

                    flatsList.add(flat);
                }
                return flatsList;
            }
        }catch (SQLException e){
            throw new  RuntimeException(e);
        }
    }
}
