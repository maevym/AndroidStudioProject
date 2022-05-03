package com.example.projectinsorma_maevymarvella;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ProductAdapter extends ArrayAdapter<Product> {
    private Context pContext;
    private int pResource;

    public ProductAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> objects) {
        super(context, resource, objects);
        this.pContext = context;
        this.pResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(pContext);
        convertView = layoutInflater.inflate(pResource,parent,false);

        TextView prodName, prodPrice, prodDesc, prodRating;
        ImageView prodImage;

        prodName = convertView.findViewById(R.id.product_name);
        prodPrice = convertView.findViewById(R.id.product_price);
        prodDesc = convertView.findViewById(R.id.product_description);
        prodRating = convertView.findViewById(R.id.product_rating);
        prodImage = convertView.findViewById(R.id.productImage);

        prodImage.setImageResource(getItem(position).getProductImage());
        prodDesc.setText(getItem(position).getProductDescription());
        prodRating.setText(getItem(position).getProductRating());
        prodPrice.setText("Rp. " + getItem(position).getProductPrice() + ",00");
        prodName.setText(getItem(position).getProductName());
        return convertView;
    }

    @Nullable
    @Override
    public Product getItem(int position) {
        return super.getItem(position);
    }
}
