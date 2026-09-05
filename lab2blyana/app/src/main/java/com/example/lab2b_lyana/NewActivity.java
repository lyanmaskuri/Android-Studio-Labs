package com.example.lab2b_lyana;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textView = findViewById(R.id.textView_id);
        ImageView imageView = findViewById(R.id.imag_id);
        String title = getIntent().getStringExtra("title");
        String subTitle = getIntent().getStringExtra("subTitle");
        Integer imag = getIntent().getIntExtra("image",1);

        imageView.setImageResource(imag);
        textView.setText("Title: "+title+"\nSubTitle: "+subTitle);
    }
}