package com.venkonenterprise.carbasics.Main;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.venkonenterprise.carbasics.Detail.AreasBrandAdapter;
import com.venkonenterprise.carbasics.Detail.DetailBrand;
import com.venkonenterprise.carbasics.R;

import java.util.ArrayList;

public class BrandActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("brand");
    private ListView listView;
    private AreasBrandAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        listView=(ListView) findViewById(R.id.listview_brand);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final ArrayList<DetailBrand> areas = new ArrayList<DetailBrand>();
                for (DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                    DetailBrand value1 = areaSnapshot.getValue(DetailBrand.class);
                    areas.add(value1);
                }
                adapter = new AreasBrandAdapter(BrandActivity.this, areas);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Error", "Something happened");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg) {
                Intent intent = new Intent(BrandActivity.this, ModelActivity.class);
                intent.putExtra("brand", (DetailBrand) adapter.getItem(position));
                startActivity(intent);
            }
        });
    }
}
