package com.example.retrofitanimals;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.CustomViewHolder> {

    private List<Animal> animalList;
    private Context context;

    public CustomListAdapter(Context context, List<Animal> animalList) {

        this.context = context;
        this.animalList = animalList;

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        TextView animalId;
        TextView animalName;
        TextView animalSpecies;
        TextView animalAge;

        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            animalId = view.findViewById(R.id.animalId);
            animalName = view.findViewById(R.id.animalName);
            animalSpecies = view.findViewById(R.id.animalSpecies);
            animalAge = view.findViewById(R.id.animalAge);
        }
    }

    @NonNull
    @Override
    public CustomListAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomListAdapter.CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomListAdapter.CustomViewHolder holder, int position) {

        holder.animalId.setText(animalList.get(position).getId().toString());
        holder.animalName.setText(animalList.get(position).getNev());
        holder.animalSpecies.setText(animalList.get(position).getFaj());
        holder.animalAge.setText(animalList.get(position).getKor().toString());

    }

    @Override
    public int getItemCount() {

        return animalList.size();

    }

}
