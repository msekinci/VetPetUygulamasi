package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Models.PetModel;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class SanalKarnePetAdapter extends RecyclerView.Adapter<SanalKarnePetAdapter.ViewHolder> {

    List<PetModel> list;
    Context context;

    public SanalKarnePetAdapter(List<PetModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sanalkarnepetlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sanalKarnePetText.setText(list.get(position).getPetisim().toString());
        holder.sanalKarneBilgiText.setText(list.get(position).getPetisim().toString()+" isimli "+
                list.get(position).getPettur()+" türüne "+list.get(position).getPetcins()+" cinsine ait petinizin geçmiş" +
                " aşıları görmek için tıklayınız... ");

        Picasso.get().load(list.get(position).getPetresim()).into(holder.sanalKarnePetImage);

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView sanalKarnePetText,sanalKarneBilgiText;
        CircleImageView sanalKarnePetImage;
        // itemView ile Listview ın her elemanı için Layout ile oluşturduğumuz view tanımlanması işlemi gerçekleiecek
        public ViewHolder(View itemView) {

            super(itemView);
            sanalKarneBilgiText = (TextView) itemView.findViewById(R.id.sanalKarneBilgiText);
            sanalKarnePetText = (TextView) itemView.findViewById(R.id.sanalKarnePetText);
            sanalKarnePetImage = (CircleImageView) itemView.findViewById(R.id.sanalKarnePetImage);
        }
    }
}
