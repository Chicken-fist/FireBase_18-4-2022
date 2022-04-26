package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Face extends AppCompatActivity {

    private ImageView imgDo, imgXanh, imgVang;
    private ImageView btnFinish;
    private int mau = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);

        imgDo = findViewById(R.id.imgDo);
        imgVang = findViewById(R.id.imgVang);
        imgXanh = findViewById(R.id.imgXanh);
        btnFinish = findViewById(R.id.btnFinish);

        imgDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mau = 1;
            }
        });
        imgVang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mau = 2;
            }
        });
        imgXanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mau = 3;
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mau == 1){
                    Toast.makeText(Face.this, "Rất tiết vì trải nghiệm tệ của bạn",
                            Toast.LENGTH_SHORT).show();
                }
                if(mau == 2){
                    Toast.makeText(Face.this, "Mong rằng lần sau chúng tôi sẽ làm bạn hài lòng",
                            Toast.LENGTH_SHORT).show();
                }
                if(mau == 3){
                    Toast.makeText(Face.this, "Sự hài lòng của bạn là vinh hạnh của chúng tôi",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}