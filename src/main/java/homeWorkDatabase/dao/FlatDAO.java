package homeWorkDatabase.dao;/*
 * Created by Alexsandr        15.05.2018
 */

import homeWorkDatabase.entity.Flat;

import java.util.List;

public interface FlatDAO {
    void init();
    void addFlat(Flat flat);
    List<Flat> getFlatByPriceAndNumberOfRooms(int from, int to, int countRooms);
}
