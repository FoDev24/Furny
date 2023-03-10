package com.example.furniture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.furniture.adapters.HotProductAdapter;
import com.example.furniture.adapters.SearchProductAdapter;
import com.example.furniture.models.Products;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference Ref;
    private int numberOfColumns = 2;
    private LinearLayout chairCatLayout,bedLayout,sofaLayout,closetLayout,officeLayout;
    private String category;
    private SearchProductAdapter searchProductAdapter;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        chairCatLayout = findViewById(R.id.chairCatSelection);
        category = getIntent().getStringExtra("category");
        bedLayout = findViewById(R.id.BedCatSelection);
        sofaLayout = findViewById(R.id.SofaCatSelection);
        closetLayout = findViewById(R.id.closetCatSelection);
        officeLayout = findViewById(R.id.OfficeCatSelection);
        textView = findViewById(R.id.products_type);

        textView.setText(category);


        bedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Beds";
                getData();
            }
        });

        sofaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Sofas";
                getData();
            }
        });

        closetLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Closets";
                getData();
            }
        });

        officeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Office Desks";
                getData();
            }
        });


        chairCatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Chairs";
                getData();
            }
        });

        if (category != null)
        {
            getData();
        }

        }
        private void getData()
        {
            textView.setText(category);
            Ref= FirebaseDatabase.getInstance().getReference().child("Products");
            recyclerView = findViewById(R.id.category_items_recyclerview);
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),numberOfColumns));

            // query in the database to fetch appropriate data
            FirebaseRecyclerOptions<Products> options = new FirebaseRecyclerOptions.Builder<Products>()
                    .setQuery(Ref.orderByChild("category").startAt(category).endAt(category),Products.class)
                    .build();


            // Connecting object of required Adapter class to
            searchProductAdapter= new SearchProductAdapter(options);
            recyclerView.setAdapter(searchProductAdapter);
            searchProductAdapter.startListening();

        }

    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

