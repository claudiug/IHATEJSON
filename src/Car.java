/**
 * Created by claudiu on 11/2/13.
 */
public class Car {

    String name;
    String address;
    float lat;
    float lgn;

    public Car(String name, String address, float lat, float lgn){
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lgn = lgn;



    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", lat=").append(lat);
        sb.append(", lgn=").append(lgn);
        sb.append('}');
        return sb.toString();
    }
}
