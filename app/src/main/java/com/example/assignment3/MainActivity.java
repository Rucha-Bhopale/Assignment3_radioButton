package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtInput;
    ImageView imgEdit;
    String strResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setOnClickListener();

        Intent intent = getIntent();
        strResult = intent.getStringExtra("strFinalResult");
        edtInput.setText(strResult);

    }

    private void setOnClickListener() {
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEdtInput;
                strEdtInput = edtInput.getText().toString();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("edt_input",strEdtInput);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        edtInput = findViewById(R.id.edtInput);
        imgEdit = findViewById(R.id.imgEdit);
    }
}