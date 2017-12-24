package com.example.kevin.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OutputActivity extends AppCompatActivity {

    TextView nameTV,ageTV,weightTV,heightTV,bmiTV;
    double bmi,h,w;
    String type="",sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        //*****物件指定*****//
        findid();

        Bundle bundle = getIntent().getExtras();
        sex = (bundle.getString("sex"));
        h = Integer.parseInt(bundle.getString("height"));
        w = Integer.parseInt(bundle.getString("weight"));
        bmi = w/(Math.pow(h/100,2));// BMI = 體重(公斤) / 身高平方(公尺)
        if(bmi <18.5)
        {
            type = "過輕";
        }
        else if(bmi >=18.5 && bmi <24)
        {
            type = "標準";
        }
        else if(bmi >=24 && bmi <27)
        {
            type = "過重";
        }
        else if(bmi >=27 && bmi <30)
        {
            type = "輕度肥胖";
        }
        else if(bmi >=30 && bmi <35)
        {
            type = "中度肥胖";
        }
        else
        {
            type = "重度肥胖";
        }


        nameTV.setText(bundle.getString("name")+" "+sex);
        ageTV.setText("今年"+bundle.getString("age")+"歲");
        heightTV.setText("身高："+String.valueOf(h));
        weightTV.setText("體重："+String.valueOf(w));
        bmiTV.setText("BMI："+String.valueOf(bmi)+"  "+type);

    }

    //*****物件指定*****//
    public void findid()
    {
        nameTV = (TextView)findViewById(R.id.OutPutNameTextView);
        ageTV = (TextView)findViewById(R.id.OutPutAgeTextView);
        heightTV = (TextView)findViewById(R.id.OutPutHeightTextView);
        weightTV = (TextView)findViewById(R.id.OutPutWeightTextView);
        bmiTV = (TextView)findViewById(R.id.OutPutBMITextView);
    }
}
