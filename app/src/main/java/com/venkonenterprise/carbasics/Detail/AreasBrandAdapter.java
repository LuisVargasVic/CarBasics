package com.venkonenterprise.carbasics.Detail;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.venkonenterprise.carbasics.R;

import java.util.ArrayList;

/**
 * Created by administrator on 4/10/18.
 */

public class AreasBrandAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<DetailBrand> mDataset;
    private static LayoutInflater inflater = null;

    public AreasBrandAdapter(Activity activity, ArrayList<DetailBrand> mDataset) {
        this.activity = activity;
        this.mDataset = mDataset;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if (view == null)
            vi = inflater.inflate(R.layout.row_brand, null);


        TextView title = (TextView) vi.findViewById(R.id.brand_text); // title
        ImageView thumb_image = (ImageView) vi.findViewById(R.id.image_brand); // thumb image

        DetailBrand brand = mDataset.get(i);

        // Setting all values in listview
        title.setText(brand.getName());
        Glide.with(activity)
                .load(brand.getImageBrand())
                .into(thumb_image);


        return vi;
    }

}
