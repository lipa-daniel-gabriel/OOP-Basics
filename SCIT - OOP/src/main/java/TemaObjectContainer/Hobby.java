package TemaObjectContainer;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    private String nameOfHobby;
    private int frequency;
    private List<Adress> adressList = new ArrayList<>();


    public Hobby(String nameOfHobby, int frequency, String adresa) {
        this.nameOfHobby = nameOfHobby;
        this.frequency = frequency;
        Adress adress = new Adress(adresa);
        adressList.add(adress);
    }

    public String getNameOfHobby() {

        return nameOfHobby;
    }


    @Override
    public String toString() {
        return "Hobby{" +
                "nameOfHobby='" + nameOfHobby + '\'' +
                ", frequency=" + frequency +
                ", adressList=" + adressList +
                '}';
    }

    public List<Adress> getAdressList() {
        return adressList;
    }
}
