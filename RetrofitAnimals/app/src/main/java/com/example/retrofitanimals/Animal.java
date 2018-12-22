package com.example.retrofitanimals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animal {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nev")
    @Expose
    private String nev;
    @SerializedName("faj")
    @Expose
    private String faj;
    @SerializedName("kor")
    @Expose
    private Integer kor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getFaj() {
        return faj;
    }

    public void setFaj(String faj) {
        this.faj = faj;
    }

    public Integer getKor() {
        return kor;
    }

    public void setKor(Integer kor) {
        this.kor = kor;
    }

}
