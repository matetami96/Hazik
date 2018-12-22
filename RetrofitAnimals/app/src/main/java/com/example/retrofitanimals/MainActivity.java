package com.example.retrofitanimals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextID = findViewById(R.id.editTextId);
        final Button btnGet = findViewById(R.id.buttonGet);
        final Button btnDelete = findViewById(R.id.buttonDelete);
        final TextView id = findViewById(R.id.id);
        final TextView nev = findViewById(R.id.nev);
        final TextView faj = findViewById(R.id.faj);
        final TextView kor = findViewById(R.id.kor);
        final TextView editName = findViewById(R.id.editName);
        final TextView editFaj = findViewById(R.id.editFaj);
        final TextView editKor = findViewById(R.id.editKor);
        final Button btnSave = findViewById(R.id.buttonSave);
        final Button btnUpdate = findViewById(R.id.buttonUpdate);
        final Button btnGetAll = findViewById(R.id.buttonGetAll);
        final ApiService service = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<Animal> call = service.getAnimalWithId(Integer.valueOf(editTextID.getText().toString()));

                call.enqueue(new Callback<Animal>() {

                    @Override
                    public void onResponse(Call<Animal> call, Response<Animal> response) {

                        Animal animal = response.body();
                        id.setText(animal.getId().toString());
                        nev.setText(animal.getNev());
                        faj.setText(animal.getFaj());
                        kor.setText(animal.getKor().toString());

                    }

                    @Override
                    public void onFailure(Call<Animal> call, Throwable t) {

                        t.printStackTrace();

                    }
                });

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<Animal> call = service.deleteAnimalWithId(Integer.valueOf(editTextID.getText().toString()));

                call.enqueue(new Callback<Animal>() {

                    @Override
                    public void onResponse(Call<Animal> call, Response<Animal> response) {

                        Animal animal = response.body();
                        id.setText(animal.getId().toString());
                        nev.setText(animal.getNev());
                        faj.setText(animal.getFaj());
                        kor.setText(animal.getKor().toString());

                    }

                    @Override
                    public void onFailure(Call<Animal> call, Throwable t) {

                        t.printStackTrace();

                    }
                });

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<Animal> call = service.createAnimal(editName.getText().toString(), editFaj.getText().toString(),
                        Integer.valueOf(editKor.getText().toString()));

                call.enqueue(new Callback<Animal>() {

                    @Override
                    public void onResponse(Call<Animal> call, Response<Animal> response) {

                        Animal animal = response.body();
                        id.setText(animal.getId().toString());
                        nev.setText(animal.getNev());
                        faj.setText(animal.getFaj());
                        kor.setText(animal.getKor().toString());

                    }

                    @Override
                    public void onFailure(Call<Animal> call, Throwable t) {

                        t.printStackTrace();

                    }
                });

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<Animal> call = service.updateAnimal(Integer.valueOf(editTextID.getText().toString()), editName.getText().toString(),
                        editFaj.getText().toString(), Integer.valueOf(editKor.getText().toString()));

                call.enqueue(new Callback<Animal>() {

                    @Override
                    public void onResponse(Call<Animal> call, Response<Animal> response) {

                        Animal animal = response.body();
                        id.setText(animal.getId().toString());
                        nev.setText(animal.getNev());
                        faj.setText(animal.getFaj());
                        kor.setText(animal.getKor().toString());

                    }

                    @Override
                    public void onFailure(Call<Animal> call, Throwable t) {

                        t.printStackTrace();

                    }
                });

            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });
    }
}
