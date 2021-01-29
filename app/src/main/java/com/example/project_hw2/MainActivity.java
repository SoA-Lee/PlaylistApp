//플레이리스트 추천 프로그램
//2019111343 이소아
//2020.12.02-03
package com.example.project_hw2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_dropdown_item_1line;

public class MainActivity extends AppCompatActivity {

    //앨범사진 리스트
    static Integer[] photoID={R.drawable.m1,R.drawable.m2,R.drawable.m3,R.drawable.m4,R.drawable.m5,R.drawable.m6,R.drawable.m7,
            R.drawable.m8,R.drawable.m9,R.drawable.m10,R.drawable.m11,R.drawable.m12,R.drawable.m13,R.drawable.m14,R.drawable.m15,
            R.drawable.m16,R.drawable.m17,R.drawable.m18,R.drawable.m19,R.drawable.m20,R.drawable.m21,R.drawable.m22,R.drawable.m23,
            R.drawable.m24,R.drawable.m25,R.drawable.m26,R.drawable.m27,R.drawable.m28,R.drawable.m29,R.drawable.m30};

    //노래제목 리스트
   static String[] songTitle =  {"Dynamite", "힘든 건 사랑이 아니다", "Lovesick Girls", "잠이 오질 않네요", "취기를 빌려", "DON'T TOUCH ME",
            "오래된 노래", "Savage Love", "딩가딩가", "내 마음이 움찔했던 순간","When We Disco","I CAN’T STOP ME","눈누난나","흔들리는 꽃들 속에서 네 샴푸향이 느껴진거야",
            "How You Like That","에잇(Prod.&Feat. SUGA of BTS)","마리아 (Maria)","어떻게 이별까지 사랑하겠어, 널 사랑하는 거지","놓아줘 (with 태연)","어떻게 지내",
            "Dolphin","늦은 밤 너의 집 앞 골목길에서","아로하","Blueming","METEOR","홀로","VVS (Feat. JUSTHIS)","거짓말이라도 해서 널 보고싶어","가을밤에 든 생각","Dance Monkey"};

   //가수 리스트
   static String[] singerName =  { "방탄소년단", "임창정", "BLACKPINK", "장범준", "산들", "환불원정대", "스탠딩 에그", "Jawsh 685, Jason Derulo, 방탄소년단",
            "마마무 (Mamamoo)", "규현 (KYUHYUN)", "박진영", "TWICE (트와이스)", "제시 (Jessi)", "장범준", "BLACKPINK", "아이유", "화사 (Hwa Sa)", "AKMU (악동뮤지션)",
            "Crush", "오반", "오마이걸 (OH MY GIRL)", "노을", "조정석", "아이유", "창모 (CHANGMO)", "이하이",
            "미란이, 먼치맨, Khundi Panda, 머쉬베놈 (MUSHVENOM)", "백지영", "잔나비", "Tones And I"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("\uD83C\uDFB5플레이리스트 추천\uD83C\uDFB5"); //타이틀을 지정해주었다.

        Button btnprev=(Button)findViewById(R.id.btnPrev); //이전 페이지
        Button btnnext=(Button)findViewById(R.id.btnNext); //다음 페이지
        Button btnsearch=(Button)findViewById(R.id.searchButton); //노래 검색 버튼
        final ViewFlipper vFlipper=(ViewFlipper)findViewById(R.id.viewFlipper1); //뷰플리퍼

        btnprev.setOnClickListener(new View.OnClickListener() { //이전버튼 클릭시 이전화면을 보여준다.
            @Override
            public void onClick(View view) {
                vFlipper.showPrevious();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() { //다음버튼 클릭시 다음화면을 보여준다.
            @Override
            public void onClick(View view) {
                vFlipper.showNext();
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() { //검색 버튼을 클릭하면 SecondActivity를 시작한다.
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });

        ListView list1=(ListView)findViewById(R.id.listview1);//리스트뷰
        ListView list2=(ListView)findViewById(R.id.listView2);
        ListView list3=(ListView)findViewById(R.id.listView3);

        ListViewAdapter mAdapter=new ListViewAdapter();

        list1.setAdapter(mAdapter);
        list2.setAdapter(mAdapter);
        list3.setAdapter(mAdapter);

        for(int j=0;j<30;j++){ //어댑터뷰에 세 정보를 추가한다.
            mAdapter.additem(photoID[j],songTitle[j],singerName[j]);
        }

        //list1,2,3에 똑같이 노래를 선택시 Toast메시지를 나타내도록 설정한다.
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, (i+1)+"위 "+songTitle[i]+"-"+singerName[i], Toast.LENGTH_SHORT).show();
            }
        });
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, (i+1)+"위 "+songTitle[i]+"-"+singerName[i], Toast.LENGTH_SHORT).show();
            }
        });
        list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, (i+1)+"위 "+songTitle[i]+"-"+singerName[i], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //메뉴옵션을 사용한다.
        MenuInflater mInflater=getMenuInflater(); //자동완성된 코드에 나머지를 코딩한다.
        mInflater.inflate(R.menu.menu_main,menu); //실제 메뉴를 만들어주기 위해 인플레이터를 사용한다.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        EditText songrequest=(EditText)findViewById(R.id.songRequest); //노래 제목 입력
        EditText singerrequest=(EditText)findViewById(R.id.singerRequest); //가수명 입력

        switch (item.getItemId()){
            case R.id.itemAddlist:
                Toast.makeText(this,"노래 추가 요청",Toast.LENGTH_SHORT).show(); //버튼 클릭시 문구가 나타난다.
                View memoView=(View)View.inflate(MainActivity.this,R.layout.memo,null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this); //알람창을 사용
                dlg.setTitle("추후 업데이트 노래 요청");
                dlg.setIcon(R.drawable.music); //title옆에 icon설정
                dlg.setView(memoView);
                dlg.setPositiveButton("요청",new DialogInterface.OnClickListener() { //요청 버튼 클릭시
                    @Override public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        View toastview = (View)View.inflate(MainActivity.this,R.layout.toast1,null);
                        TextView tvToast = (TextView)toastview.findViewById(R.id.tvToast);
                        tvToast.setText("요청 완료");
                        toast.setView(toastview);
                        toast.show();
                    } });
                dlg.setNegativeButton("닫기",null); //닫기 버튼 클릭시
                dlg.show();
                return true;
            case R.id.itemShare1: //공유하기 버튼 1번=>인스타그램
                Toast.makeText(this,"Instagram 공유",Toast.LENGTH_SHORT).show();
                Intent fIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
                startActivity(fIntent);
                return true;
            case R.id.itemShare2: //공유하기 버튼 2번=>페이스북북
               Toast.makeText(this,"Facebook 공유",Toast.LENGTH_SHORT).show();
                Intent iIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(iIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class ListViewAdapter extends BaseAdapter { //어댑터뷰 생성

        private ArrayList<MusicData> listViewItemList = new ArrayList<MusicData>() ;
        public ListViewAdapter(){
        }

        @Override
        public int getCount() {
            return  listViewItemList.size() ;
        }

        @Override
        public Object getItem(int i) {
            return listViewItemList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //앨범이미지와 노래 제목 및 가수 텍스트를 각 이미지뷰와 텍스트뷰에 생성해서 보여주게함
            final int pos=i;
            final Context context = viewGroup.getContext();

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.dialog, viewGroup, false);
            }

            ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView1) ;
            TextView titleTextView = (TextView) view.findViewById(R.id.textView1) ;
            TextView titleTextView2=(TextView)view.findViewById(R.id.textView2);

            MusicData musicdata = listViewItemList.get(pos);

            iconImageView.setImageResource(musicdata.getPoster());
            titleTextView.setText(musicdata.getPosterName());
            titleTextView2.setText(musicdata.getSinger());

            return view;
        }

        public void additem(Integer photo, String song,String singer) { //아이템 추가 메서드드
           MusicData data=new MusicData();

            data.setPoster(photo);
            data.setPosterName(song);
            data.setSinger(singer);

            listViewItemList.add(data);
        }
    }
}