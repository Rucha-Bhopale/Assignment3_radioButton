package com.example.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    EditText edtInput;
    RadioGroup rdGroup;
    String strText;

    RadioButton rdBtnUpper, rdBtnLower, rdBtnInnerCapital, rdBtnReverse;
    Button btnGotoMain;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        Intent intent = getIntent();
        strText = intent.getStringExtra("edt_input");
        edtInput.setText(strText);
        setOnClickListener();

    }

    private void setOnClickListener() {

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                applyTextTransformation();
            }
        });

        btnGotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEdtResult;
                strEdtResult = edtInput.getText().toString();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.putExtra("strFinalResult",strEdtResult);
                startActivity(intent);
                finish();

            }
        });

    }

    private void initView() {
        edtInput = findViewById(R.id.edtInput);
        rdGroup = findViewById(R.id.rdGroup);
        rdBtnUpper = findViewById(R.id.rdBtnUpper);
        rdBtnLower = findViewById(R.id.rdBtnLower);
        rdBtnInnerCapital = findViewById(R.id.rdBtnInnerCapital);
        rdBtnReverse = findViewById(R.id.rdBtnReverse);
        btnGotoMain = findViewById(R.id.btnGotoMain);
    }

    private void applyTextTransformation() {
        String originalText = edtInput.getText().toString();
        if (rdBtnUpper.isChecked()) {
            edtInput.setText(originalText.toUpperCase());
        } else if (rdBtnLower.isChecked()) {
            edtInput.setText(originalText.toLowerCase());
        } else if (rdBtnInnerCapital.isChecked()) {
            edtInput.setText(capitalizeFirstLetter(originalText));
        } else if (rdBtnReverse.isChecked()) {
            edtInput.setText(reverseString(originalText));
        } else {

        }
    }

    private String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text; // Return unchanged if text is null or empty
        }
        // Capitalize the first letter and append the rest of the string
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
    private String reverseString(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
