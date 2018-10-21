package misterpanchak.com.ostapuchi;

public class City {
    private String Name;
    private int imgUrl;
    private String location;
    private String desctription;
    private boolean sightorcity;
    private String adress;



    public City(String name, int imgUrl, String location, String desctriptionk,boolean sightorcity, String adress) {
        Name = name;
        this.imgUrl = imgUrl;
        this.sightorcity = sightorcity;
        this.adress = adress;

        this.location = location;
        this.desctription = desctription;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getImgUrl() {
        return imgUrl;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesctription() {
        return desctription;
    }

    public void setDesctription(String desctriptionk) {
        this.desctription = desctriptionk;
    }

    public boolean getSightorcity() {
        return sightorcity;
    }

    public void setSightorcity(boolean sightorcity) {
        this.sightorcity = sightorcity;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
