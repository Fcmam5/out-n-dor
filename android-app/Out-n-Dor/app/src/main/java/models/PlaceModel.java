package models;

/**
 * Created by fcmam5 on 28/03/17.
 */

public class PlaceModel {
    private String name;
    private String address;
    private String urban_adr;
    private double latt;
    private double lng;
    private String nature;
    private String description;
    private String fb;
    private String instagram;
    private String website;
    private String tel;
    private long likes;
    private String type;
    private String city;
    private String img;

    public PlaceModel(String type, String name, String address, String urban_adr, double latt,
                      double lng, String nature, String description, String fb, String instagram,
                      String website, String tel, String city, String img) {
        this.type = type;
        this.name = name;
        this.address = address;
        this.urban_adr = urban_adr;
        this.latt = latt;
        this.lng = lng;
        this.nature = nature;
        this.description = description;
        this.fb = fb;
        this.instagram = instagram;
        this.website = website;
        this.tel = tel;
        this.city = city;
        this.likes = 0;
        switch (img){
            case "sport": this.img = "https://image.flaticon.com/icons/svg/372/372520.svg";
                break;
            case "tourism": this.img = "https://image.flaticon.com/icons/svg/206/206974.svg";
                break;
            case "park": this.img = "https://image.flaticon.com/icons/svg/140/140677.svg";
                break;
            case "library": this.img = "https://image.flaticon.com/icons/svg/164/164949.svg";
                break;
            default:
                this.img = "x";
                break;

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrban_adr() {
        return urban_adr;
    }

    public void setUrban_adr(String urban_adr) {
        this.urban_adr = urban_adr;
    }

    public double getLatt() {
        return latt;
    }

    public void setLatt(double latt) {
        this.latt = latt;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void incrementLikes(long likes) {
        this.likes++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
