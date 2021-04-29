package com.example.appertmentmanagementsystem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.models.Paybillmodel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    List<Paybillmodel> paybillmodels;
    Context context;

    public interface onCategoryClickListener{
        void onCategoryClick(View view,int position);
    }
    public CategoryAdapter(List<Paybillmodel> paybillmodels, Context context) {
        this.paybillmodels = paybillmodels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(paybillmodels.get(position).getName());
        holder.imageView.setImageResource(paybillmodels.get(position).getImg());
        holder.setOnCategoryClickListener(new onCategoryClickListener() {
            @Override
            public void onCategoryClick(View view, int position) {
                String str = paybillmodels.get(position).getName().toLowerCase();


            }
        });


    }

    @Override
    public int getItemCount() {
        return paybillmodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textView;
        onCategoryClickListener onCategoryClickListener;

        public void setOnCategoryClickListener(onCategoryClickListener listener){
            this.onCategoryClickListener = listener;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iconID);
            textView = itemView.findViewById(R.id.iconnameID);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCategoryClickListener.onCategoryClick(v,getAdapterPosition());

        }
    }
}
