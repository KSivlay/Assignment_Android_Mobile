package com.ksivlay.crudstudentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ksivlay.crudstudentapp.R;
import com.ksivlay.crudstudentapp.adapter.CustomStudentAdapter;

public class MainActivity extends BaseActivity {
    private ListView studentListView;
    private ImageView imageAdd;
    private CustomStudentAdapter customStudentAdapter;
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
        //customStudentAdapter = new CustomStudentAdapter();

        getDataStudent();
        imageAdd = findViewById(R.id.imageAdd);
        imageAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,StudentFormActivity.class);
                startActivity(intent);
            }
        });

    }
    private void getDataStudent(){
        studentListView = findViewById(R.id.lvStudent);
        customStudentAdapter = new CustomStudentAdapter(this,getAllStudents());
        studentListView.setAdapter(customStudentAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataStudent();
    }
}