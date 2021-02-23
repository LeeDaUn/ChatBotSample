package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;

    TextView Tv_Head,Tv_UserMsg, Tv_MeoludaMsg;
    EditText Edt_Content;
    Button Btn_Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tv_Head = findViewById(R.id.tv_head);
        Tv_UserMsg = findViewById(R.id.tv_userMsg);
        Tv_MeoludaMsg = findViewById(R.id.tv_meoludaMsg);
        Edt_Content = findViewById(R.id.edt_content);
        Btn_Send = findViewById(R.id.btn_send);

        //SpannableString 객체 생성 (특정 문자열 색상,크기,스타일 바꿀때 사용)
        String content = Tv_Head.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        //특정 문자열의 시작 위치와 끝 위치 얻어옴
        String daelim = "대림대학교";
        int start = content.indexOf(daelim);
        int end = start + daelim.length();

        //SpannableString 대림대학교 글자 색상,크기 지정
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0054FF")),
                start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.3f),
                start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        Tv_Head.setText(spannableString);

        //LayoutInflater를 이용하여 meoluda_msgbox.xml 파일을 가져옴
        container = findViewById(R.id.container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.meoluda_msgbox, container, true);

        //버튼 입력값 출력
        Btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),Edt_Content.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}