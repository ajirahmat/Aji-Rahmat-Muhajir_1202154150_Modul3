package com.aji.userpc.ajirahmatmuhajir_1202154150_moudl3;

/**
 * Created by user pc on 2/24/2018.
 */


public class itemData {

    private String title;
    private int imageUrl;
    private String info;
    private String deskripsi;

    public itemData(String title,String info, String deskripsi,int imageUrl){

        this.title = title;
        this.imageUrl = imageUrl;
        this.info = info;
        this.deskripsi =deskripsi;
    }
    //melaklukan get image
    public int getImageUrl() {
        return imageUrl;
    }
    //melakukan get judulmenu
    public String getTitle() {
        return title;
    }
    //melakukan get hargamenu
    public String getDeskripsi() {
        return deskripsi;
    }
    //melakukan get infomenu
    public String getInfo() {
        return info;
    }


}
