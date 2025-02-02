package com.example.foodgrid.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodgrid.Activity.ShowDetailActivity;
import com.example.foodgrid.Domain.FoodDomain;
import com.example.foodgrid.R;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<FoodDomain> popularFood;

    public PopularAdaptor(ArrayList<FoodDomain> popularFood) {

        this.popularFood = popularFood;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(popularFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));



        int drawableResourseId = holder.itemView.getContext().getResources()
                .getIdentifier(popularFood.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());



        if (popularFood.get(position).getTitle().equals("Pepperoni pizza"))
        {
            holder.pic.setImageResource(R.drawable.pop_1);
        }
        if (popularFood.get(position).getTitle().equals("Cheese Burger"))
        {
            holder.pic.setImageResource(R.drawable.pop_2);
        }
        if (popularFood.get(position).getTitle().equals("Vegetable pizza"))
        {
            holder.pic.setImageResource(R.drawable.pop_3);
        }

        //Glide.with(holder.itemView.getContext())
            //    .load(drawableResourseId)
             //   .into(holder.pic);


        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
