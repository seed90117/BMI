package com.example.kevin.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //*****宣告變數*****//
    EditText nameET,hightET,weightET;//宣告EditText物件
    Spinner AgeSP;//宣告Spinner物件
    RadioGroup SexRG;//宣告RadioGroup物件
    Button runbtn;//宣告Button物件
    String agedata[] = {"18","19","20","21","22","23"};//宣告Spinner內資料的陣列
    ArrayAdapter <String> ad;//宣告陣列接口
    String name,sex,age,weight,height;//宣告字串變數

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sex="先生";

        //*****物件指定*****//
        findid();

        //*****Spinner下拉式選單宣告*****//
        ad = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,agedata);
        ad.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        AgeSP.setAdapter(ad);

        //*****監聽Spinner選項*****//
        AgeSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                age = agedata[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //*****監聽RadioGroup內點選按鈕*****//
        SexRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ManRadioButton:
                        sex = "先生";
                        break;
                    case R.id.FemaleRadioButton:
                        sex = "小姐";
                        break;
                }
            }
        });

        //*****監聽按鈕點擊*****//
        runbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameET.getText().toString();
                height = hightET.getText().toString();
                weight = weightET.getText().toString();

                if(name != null && height != null && weight != null)
                {
                    Intent intent = new Intent(MainActivity.this,OutputActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name",name);
                    bundle.putString("sex",sex);
                    bundle.putString("age",age);
                    bundle.putString("weight",weight);
                    bundle.putString("height",height);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

    }

    //*****物件指定*****//
    public void findid()
    {
        nameET = (EditText)findViewById(R.id.NameEditText);
        hightET = (EditText)findViewById(R.id.HeightEditText);
        weightET = (EditText)findViewById(R.id.WeightEditText);
        AgeSP = (Spinner)findViewById(R.id.AgeSpinner);
        SexRG = (RadioGroup)findViewById(R.id.SexRadioGroup);
        runbtn = (Button)findViewById(R.id.StartButton);
    }

}
