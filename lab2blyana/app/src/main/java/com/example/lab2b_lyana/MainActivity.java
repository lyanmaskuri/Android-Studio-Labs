package com.example.lab2b_lyana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] title = {"Github App", "Gmail App",
            "PlayStore App", "Yahoo", "Drive"};
    String[] subTitle = {"Download Github App", "Download Gmail App", "Download PlayStore App",
            "Download Yahoo", "Download GoogleDrive"};
    Integer[] imageID = {R.drawable.github,R.drawable.gmail,R.drawable.play,
            R.drawable.yahoo,R.drawable.drive};

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

        listView = findViewById(R.id.listView_id);
        MyListAdapter adapter = new MyListAdapter(MainActivity.this, title, subTitle, imageID);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("title", title[position]);
                intent.putExtra("subTitle"
                        , subTitle[position]);
                intent.putExtra("image", imageID[position]);
                startActivity(intent);
            }
        });
    }
}