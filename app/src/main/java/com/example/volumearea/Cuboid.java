package com.example.volumearea;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cuboid extends AppCompatActivity {
    EditText cuboid_length,cuboid_breadth,cuboid_hgt;
    TextView title,result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuboid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cuboid_length=findViewById(R.id.cuboid_length);
        cuboid_breadth=findViewById(R.id.cuboid_breadth);
        cuboid_hgt=findViewById(R.id.cuboid_hgt);
        title=findViewById(R.id.textView2);
        result=findViewById(R.id.cuboid_result);
        btn=findViewById(R.id.btn4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius=cuboid_length.getText().toString();
                int l= Integer.parseInt(radius);
                String breadth=cuboid_breadth.getText().toString();
                int b=Integer.parseInt(breadth);
                String height=cuboid_hgt.getText().toString();
                int h= Integer.parseInt(height);

                //V=l*b*h
                double volume = l*b*h;
                result.setText("V = "+volume+" m^3");
            }
        });
    }
}