package com.example.hoanganhken.munichats;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Hoang Anh Ken on 12/2/2017.
 */

public class ListOnlineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtEmail;
    ItemClickListenent itemClickListenent;

    public ListOnlineViewHolder(View itemView) {
        super(itemView);
        txtEmail =(TextView) itemView.findViewById(R.id.txt_email);
    }

    public void setItemClickListenent(ItemClickListenent itemClickListenent) {
        this.itemClickListenent = itemClickListenent;
    }

    @Override
    public void onClick(View v) {

        itemClickListenent.onClick(v, getAdapterPosition());
    }
}



