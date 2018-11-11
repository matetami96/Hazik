package com.example.myrecyclerviewcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_ANIMAL = "EXTRA_ANIMAL";
    private Animal animal;
    private ImageView ivAnimal;
    private TextView tvName;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivAnimal = (ImageView)findViewById(R.id.ivAnimal);
        tvName = (TextView)findViewById(R.id.tvName);
        tvDesc =(TextView)findViewById(R.id.tvDescription);

        animal = (Animal)getIntent().getExtras().getSerializable(EXTRA_ANIMAL);

        Glide.with(DetailsActivity.this).load(animal.getaDrawable()).apply(RequestOptions.centerCropTransform()).into(ivAnimal);
        tvName.setText(animal.getaName());
        tvDesc.setText(animal.getaDesc());

    }
}
