package com.example.appertmentmanagementsystem.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.util.List;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ViewHolder> {

    Context context;
    List<Apartmentmodel> apartmentlist;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClickListener(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public ApartmentAdapter(Context context, List<Apartmentmodel> apartmentlist) {
        this.context = context;
        this.apartmentlist = apartmentlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.apartmentlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //holder.img.setImageResource(apartmentlist.get(position).getImg());
        holder.bed.setText(apartmentlist.get(position).getNum_of_beds());
        holder.toilet.setText(apartmentlist.get(position).getNum_of_toilet());
        holder.size.setText(apartmentlist.get(position).getFlat_size());
        holder.price.setText(apartmentlist.get(position).getPrice());
        //Toast.makeText(context,String.valueOf(apartmentlist.size()),Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return apartmentlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView bed,toilet,size,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bed = itemView.findViewById(R.id.apartmentbedID);
            toilet = itemView.findViewById(R.id.apartmenttoiletID);
            size = itemView.findViewById(R.id.apartmentsizeID);
            price = itemView.findViewById(R.id.apartmentpriceID);
            img = itemView.findViewById(R.id.apartmentimgID);
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener!=null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    onItemClickListener.onItemClickListener(position);
                    //Toast.makeText(context,"not working",Toast.LENGTH_SHORT).show();

                }
            }
            else{
                Toast.makeText(context,"not working",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
