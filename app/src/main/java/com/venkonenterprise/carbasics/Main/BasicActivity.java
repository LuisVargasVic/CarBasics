package com.venkonenterprise.carbasics.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.FirebaseDatabase;
import com.venkonenterprise.carbasics.Detail.AreasBasicAdapter;
import com.venkonenterprise.carbasics.Detail.DetailBasic;
import com.venkonenterprise.carbasics.Detail.DetailBrand;
import com.venkonenterprise.carbasics.Detail.DetailModel;
import com.venkonenterprise.carbasics.R;

public class BasicActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private Activity activity;
    private ListView listView;
    private ImageView brandImage;
    private TextView modelText;
    private DetailBrand brand;
    private DetailModel model;
    private AreasBasicAdapter areasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        listView=(ListView) findViewById(R.id.listview_basic);

        brand = (DetailBrand) getIntent().getSerializableExtra("brand");
        model = (DetailModel) getIntent().getSerializableExtra("model");

        brandImage = findViewById(R.id.image_brand_basics);
        Glide.with(this)
                .load(brand.getImageBrand())
                .into(brandImage);
        modelText = findViewById(R.id.model_text_basics);
        modelText.setText(model.getName());

        areasAdapter = new AreasBasicAdapter(BasicActivity.this, model.getBasicsList());
        listView.setAdapter(areasAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg) {
                Intent intent = new Intent(BasicActivity.this, SpecificActivity.class);
                intent.putExtra("basic",(DetailBasic) areasAdapter.getItem(position));
                intent.putExtra("model", model);
                intent.putExtra("brand", brand);
                startActivity(intent);
            }
        });
    }
}
