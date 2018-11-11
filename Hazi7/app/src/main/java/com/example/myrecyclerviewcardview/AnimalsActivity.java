package com.example.myrecyclerviewcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;

import java.util.List;

public class AnimalsActivity extends AppCompatActivity {

    private RecyclerView rvAnimals;
    private AnimalsAdapter anAdapter;
    private List<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        rvAnimals = (RecyclerView) findViewById(R.id.rvAnimals);

        rvAnimals.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(AnimalsActivity.this, 1);

        rvAnimals.setLayoutManager(layoutManager);

        animals = Animal.getAnimals();

        anAdapter = new AnimalsAdapter(AnimalsActivity.this, animals);

        rvAnimals.setAdapter(anAdapter);
    }
}
