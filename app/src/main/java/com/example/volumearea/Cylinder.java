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

public class Cylinder extends AppCompatActivity {
    EditText cylinder_radius,cylinder_hgt;
    TextView title,result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cylinder_radius=findViewById(R.id.cylinder_radius);
        cylinder_hgt=findViewById(R.id.cylinder_hgt);
        title=findViewById(R.id.textView2);
        result=findViewById(R.id.cylinder_result);
        btn=findViewById(R.id.btn3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius=cylinder_radius.getText().toString();
                int r= Integer.parseInt(radius);
                String height=cylinder_hgt.getText().toString();
                int h= Integer.parseInt(height);

                //V=pi*r^2*h
                double volume = Math.PI*r*r*h;
                result.setText("V = "+volume+" m^3");
            }
        });
    }
}