package homeWorkDatabase.service;/*
 * Created by Alexsandr        15.05.2018
 */

import homeWorkDatabase.dao.FlatDAO;
import homeWorkDatabase.dao.FlatDAOImpl;
import homeWorkDatabase.entity.Flat;

import java.sql.Connection;
import java.util.List;

public class ServiceImpl implements Service {
    private FlatDAO flatDAO ;

     public ServiceImpl(Connection connection){
        flatDAO = new FlatDAOImpl(connection) ;
    }


    public void init() {
        flatDAO.init();
    }


    public void addFlat(Flat flat) {
        flatDAO.addFlat(flat);
    }

    public List<Flat> getFlatByPriceAndNumberOfRooms(int from, int to, int countRooms) {
        if (from > 0 && to > 0 && countRooms > 0){
            return flatDAO.getFlatByPriceAndNumberOfRooms(from, to, countRooms);
        }
        return null;
    }
}
