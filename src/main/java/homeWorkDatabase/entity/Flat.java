package homeWorkDatabase.entity;/*
 * Created by Alexsandr        15.05.2018
 */


public class Flat {
    private int id;
    private String district;
    private String adress;
    private double area;
    private int countRoom;
    private double price;

    public Flat(int id, String district, String adress, double area, int countRoom, double price) {
        this.id = id;
        this.district = district;
        this.adress = adress;
        this.area = area;
        this.countRoom = countRoom;
        this.price = price;
    }

    public Flat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(int countRoom) {
        this.countRoom = countRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", adress='" + adress + '\'' +
                ", area=" + area +
                ", countRoom=" + countRoom +
                ", price=" + price +
                '}';
    }
}
