package TemaObjectContainer;

public class Adress {
    private String adressName;

    public Adress(String numeAdresa) {
        this.adressName = numeAdresa;
    }

    @Override
    public String toString() {
        return "adressName='" + adressName;
    }

}
