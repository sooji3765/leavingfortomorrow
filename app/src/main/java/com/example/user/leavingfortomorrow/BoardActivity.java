package com.example.user.leavingfortomorrow;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BoardActivity extends AppCompatActivity {

    private TextView mTextMessage;

    ArrayAdapter<CharSequence> adspin;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_list:
                    mTextMessage.setText(R.string.title_list);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_write);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_search);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView)findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setPrompt("말머리를 선택하세요.");

        adspin = ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adspin);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] methods= getResources().getStringArray(R.array.category);
                Toast.makeText(BoardActivity.this,methods[position] + "을 선택." ,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_menu_people),"Box1","context");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_menu_people),"Box2","context");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_menu_people),"Box3","context");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);
                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Drawable iconDrawable = item.getIcon() ;


            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
