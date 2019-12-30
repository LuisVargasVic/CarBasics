package com.venkonenterprise.carbasics.Main;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.venkonenterprise.carbasics.Detail.AreasModelAdapter;
import com.venkonenterprise.carbasics.Detail.DetailBrand;
import com.venkonenterprise.carbasics.Detail.DetailModel;
import com.venkonenterprise.carbasics.R;

public class ModelActivity extends AppCompatActivity {

    private ListView listView;
    private DetailBrand brand;
    private AreasModelAdapter areasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        listView=(ListView) findViewById(R.id.listview_model);

        brand = (DetailBrand) getIntent().getSerializableExtra("brand");
        areasAdapter = new AreasModelAdapter(ModelActivity.this, brand.getModelsList());
        listView.setAdapter(areasAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg) {
                Intent intent = new Intent(ModelActivity.this, BasicActivity.class);
                intent.putExtra("model", (DetailModel) areasAdapter.getItem(position));
                intent.putExtra("brand", brand);
                startActivity(intent);
            }
        });
    }
}
