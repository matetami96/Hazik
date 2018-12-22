package com.example.retrofitanimals;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @GET("animals")
    public Call<List<Animal>> getAnimals();

    @GET("animals/{id}")
    public Call<Animal> getAnimalWithId(@Path("id") int id);

    @DELETE("animals/{id}")
    public Call<Animal> deleteAnimalWithId(@Path("id") int id);

    @FormUrlEncoded
    @POST("animals")
    public Call<Animal> createAnimal(

            @Field("nev") String nev,
            @Field("faj") String faj,
            @Field("kor") Integer kor

    );

    @FormUrlEncoded
    @PUT("animals/{id}")
    public Call<Animal> updateAnimal(

            @Path("id") int id,
            @Field("nev") String nev,
            @Field("faj") String faj,
            @Field("kor") Integer kor

    );
}
