package com.example.myrecyclerviewcardview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {

    private Activity mContext;
    private List<Animal> mAnimals;

    public AnimalsAdapter(Activity context, List<Animal> animals) {
        mContext = context;
        if (animals == null) {
            throw new IllegalArgumentException("Animals must not be null");
        }
        mAnimals = animals;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_animal, viewGroup, false);
        return new VH(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Animal animal = mAnimals.get(position);
        holder.rootView.setTag(animal);
        holder.tvName.setText(animal.getaName());
        holder.tvDesc.setText(animal.getaDesc());
        Glide.with(mContext).load(animal.getaDrawable()).apply(RequestOptions.centerCropTransform()).into(holder.ivAnimal);
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        final View rootView;
        final ImageView ivAnimal;
        final TextView tvName;
        final  TextView tvDesc;


        public VH(View itemView, final Context context) {
            super(itemView);
            rootView = itemView;
            ivAnimal = (ImageView) itemView.findViewById(R.id.ivAnimal);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Animal animal = (Animal)v.getTag();
                    if (animal != null) {
                        Intent intent = new Intent(mContext, DetailsActivity.class);
                        intent.putExtra("EXTRA_ANIMAL", animal);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }
}
