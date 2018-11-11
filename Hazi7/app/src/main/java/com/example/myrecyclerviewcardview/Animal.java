package com.example.myrecyclerviewcardview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable {

    private int aDrawable;
    private String aName;
    private String aDesc;

    public Animal(int PaDrawable, String PaName, String PaDesc) {
        aDrawable = PaDrawable;
        aName = PaName;
        aDesc = PaDesc;
    }

    public int getaDrawable() { return aDrawable;}
    public String getaName() { return aName; }
    public String getaDesc() { return aDesc; }

    public static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.cat, "Cica", "Cirmos Cica"));
        animals.add(new Animal(R.drawable.disznyo, "Malac", "Nagyra hizott malac"));
        animals.add(new Animal(R.drawable.dog, "Kutyus", "Igaz barat"));
        animals.add(new Animal(R.drawable.giraffe, "Zsiraf", "Igazi magas letra"));
        animals.add(new Animal(R.drawable.horse, "Lo", "Villamgyors"));
        animals.add(new Animal(R.drawable.lion, "Oroszlan", "Nagyobb cicus"));
        animals.add(new Animal(R.drawable.rabbit, "Nyuszi", "Hatha husvetkor benez"));
        animals.add(new Animal(R.drawable.sheep, "Barany", "Szep az a gyapju"));
        animals.add(new Animal(R.drawable.octopus, "Polip", "Can't say no to hentai right :)"));
        return animals;
    }
}
