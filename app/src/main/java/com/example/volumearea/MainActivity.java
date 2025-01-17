package com.example.volumearea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //1-AdapterView:GridView
    GridView gridView;
    //2-Data Source: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;
    //3-Adapter:MyCustomAdapter
    MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView = findViewById(R.id.gridView);

        shapeArrayList= new ArrayList<>();
        Shape s1 = new Shape(R.drawable.cube,"Cube");
        Shape s2 = new Shape(R.drawable.sphere,"Sphere");
        Shape s3 = new Shape(R.drawable.cylindrical,"Cylinder");
        Shape s4 = new Shape(R.drawable.cunoid,"Cuboid");
        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);
        adapter=new MyCustomAdapter(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String check_shape=adapter.getItem(position).getShapeName();
                if(check_shape=="Sphere") {
                    Intent i = new Intent(getApplicationContext(),Sphere.class);
                    startActivity(i);
                } else if (check_shape=="Cube") {
                    Intent i = new Intent(getApplicationContext(),Cube.class);
                    startActivity(i);
                    
                }
                else if (check_shape=="Cylinder") {
                    Intent i = new Intent(getApplicationContext(),Cylinder.class);
                    startActivity(i);

                }
                else if (check_shape=="Cuboid") {
                    Intent i = new Intent(getApplicationContext(),Cuboid.class);
                    startActivity(i);

                }
            }

        });
    }
}