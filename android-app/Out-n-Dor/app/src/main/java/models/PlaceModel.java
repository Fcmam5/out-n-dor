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

    public PlaceModel(String name, String address, String urban_adr, double latt, double lng, String nature, String description, String fb, String instagram, String website, String tel) {
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
        this.likes = 0;
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

}
