package com.example.projectinsorma_maevymarvella;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter<Transactions> {
    private Context tContext;
    private int tResource;

    public TransactionAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Transactions> objects) {
        super(context, resource, objects);
        this.tContext = context;
        this.tResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(tContext);
        convertView = layoutInflater.inflate(tResource,parent,false);

        TextView transId, prodName, prodQty, total, transDate;

        transId = convertView.findViewById(R.id.transaction_id);
        prodName = convertView.findViewById(R.id.transaction_name);
        prodQty = convertView.findViewById(R.id.transaction_qty);
        total = convertView.findViewById(R.id.transaction_price);
        transDate = convertView.findViewById(R.id.transaction_date);

        transId.setText(String.valueOf(getItem(position).getTransactionID()));
        prodName.setText(HomePage.findProductName(getItem(position).getProductID()));
        prodQty.setText(getItem(position).getQuantity());

        Integer x = Integer.valueOf(getItem(position).getQuantity());
        Integer y = HomePage.findProductPrice(getItem(position).getProductID());
        Integer tot = x*y;
        String tot_string = tot.toString();
        total.setText("Rp. " + tot_string + ",00");
        transDate.setText(getItem(position).getTransactionDate());
        return convertView;
    }

    @Nullable
    @Override
    public Transactions getItem(int position) {
        return super.getItem(position);
    }
}