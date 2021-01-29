package com.example.project_hw2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.R.layout.simple_dropdown_item_1line;
import static com.example.project_hw2.MainActivity.songTitle;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1); //자동완성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_dropdown_item_1line, songTitle);
        auto.setAdapter(adapter);

        Button btnsearch2=(Button)findViewById(R.id.searchButton2); //검색버튼
        Button btnreturn = (Button) findViewById(R.id.backButton); //돌아가기 버튼

        Intent intent = getIntent(); //인텐트 가져오기

        ImageView iv=findViewById(R.id.searchImage1);
        TextView tv=findViewById(R.id.searchText1);

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //클릭시 이전화면으로 돌아감
            }
        });

        auto.addTextChangedListener(new TextWatcher() { //자동완성텍스트뷰의 실시간 문자확인
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                tv.setText(s.toString());
            }
        });

        btnsearch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j=0;j<30;j++) { //자동완성해서 나온게 몇번째 노래인지 확인
                    if (tv.getText().toString().equals(songTitle[j])){
                        iv.setImageResource(MainActivity.photoID[j]); //j번째 이미지
                        tv.setText(auto.getText() + "-" + MainActivity.singerName[j]);//j번째 정보
                          }
                }
            }
        });
    }
}



