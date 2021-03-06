package com.pratamatechnocraft.e_arsip.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pratamatechnocraft.e_arsip.LembarDisposisiActivity;
import com.pratamatechnocraft.e_arsip.Model.ListItemDisposisi;
import com.pratamatechnocraft.e_arsip.R;

import java.util.List;

public class AdapterRecycleViewDisposisi extends RecyclerView.Adapter<AdapterRecycleViewDisposisi.ViewHolder> {

    private List<ListItemDisposisi> listItemDisposisis;
    private Context context;

    public AdapterRecycleViewDisposisi(List<ListItemDisposisi> listItemDisposisis, Context context) {
        this.listItemDisposisis = listItemDisposisis;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.list_item_disposisi,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItemDisposisi listItemDisposisi = listItemDisposisis.get(position);

        holder.txtNoSurat.setText(listItemDisposisi.getNoSurat());
        holder.txtIsiDisposisi.setText(listItemDisposisi.getIsiDisposisi());


        holder.cardViewDisposisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, LembarDisposisiActivity.class);
                i.putExtra("idDisposisi", listItemDisposisi.getidDisposisi());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItemDisposisis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtNoSurat, txtIsiDisposisi;
        public CardView cardViewDisposisi;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNoSurat= (TextView) itemView.findViewById(R.id.txtDisposisiNoSurat);
            txtIsiDisposisi= (TextView) itemView.findViewById(R.id.txtisiDisposisi);
            cardViewDisposisi = (CardView) itemView.findViewById(R.id.cardViewDisposisi);

        }
    }

}
