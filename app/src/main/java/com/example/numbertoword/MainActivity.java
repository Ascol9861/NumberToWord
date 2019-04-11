package com.example.numbertoword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNum;
    private TextView tvOutput;
    private Button btnConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConvert = findViewById(R.id.btnConvert);
        txtNum= findViewById(R.id.txtNum);
        tvOutput = findViewById(R.id.tvOutput);
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConvert) {
            if (validation()) {
                String numberz =txtNum.getText().toString();
                final long number = Long.parseLong(numberz);
                String returnz = Converter.convert(number);
                tvOutput.setText(returnz);
            }
        }
    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(txtNum.getText().toString())){
            txtNum.setError("Please enter Height");
            txtNum.requestFocus();
            flag = false;
        }
        return flag;
    }
}
