package com.example.retrofitanimals;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    private CustomListAdapter adapter;
    private RecyclerView recyclerView;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button btnGoB = findViewById(R.id.buttonGoBack);
        progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setMessage("Loading... ");
        progressDialog.show();

        ApiService service = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        Call<List<Animal>> call = service.getAnimals();
        call.enqueue(new Callback<List<Animal>>() {

            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {

                progressDialog.dismiss();
                generateAnimalList(response.body());

            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

                Toast.makeText(Main2Activity.this, "Something went wrong...Please try later!", Toast.LENGTH_LONG).show();

            }

        });

        btnGoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void generateAnimalList(List<Animal> animalList) {

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomListAdapter(this,animalList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Main2Activity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
