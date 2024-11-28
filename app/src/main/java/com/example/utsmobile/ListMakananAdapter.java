package com.example.utsmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMakananAdapter extends RecyclerView.Adapter<ListMakananAdapter.ListViewHolder> {
   private ArrayList<Makanan> listMakanan;

   public ListMakananAdapter(ArrayList<Makanan> list){
       this.listMakanan = list;
   }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_row_makanan, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
    Makanan makanan = listMakanan.get(position);
    holder.imgPhoto.setImageResource(makanan.getPhoto());
    holder.tvName.setText(makanan.getName());
    holder.tvDescription.setText(makanan.getDescription());
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
       ImageView imgPhoto;
       TextView tvName, tvDescription;
        public ListViewHolder( View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
