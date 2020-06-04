package com.example.minishop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lin_layout;
    private LayoutInflater layoutInflater;
    private ListView listView;
    private View view_header, view_footer;
    private Button btnShow;
    private TextView tv_count;
    private ArrayList<Good> arr_goods = new ArrayList<Good>();
    private final int SIZE_OF_ARR = 25;
    private GoodsAdapter goodsAdapter;
    private ArrayList<Good> arr_checked_goods = new ArrayList<Good>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createMyListView();
    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        lin_layout = (LinearLayout) findViewById(R.id.lin_layout);
        layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.shop_layout, lin_layout, true);
        listView = (ListView) findViewById(R.id.listView);
    }

    private void createMyListView() {
        fillData();
        goodsAdapter = new GoodsAdapter(this, arr_goods);
        view_header = layoutInflater.inflate(R.layout.header_mygoods, null);
        view_footer = layoutInflater.inflate(R.layout.footer_mygoods, null);
        btnShow = (Button) view_footer.findViewById(R.id.btnShow);
        btnShow.setOnClickListener((View.OnClickListener) this);
        tv_count = (TextView) view_footer.findViewById(R.id.tv_count);
        listView.addHeaderView(view_header);
        listView.addFooterView(view_footer);
        listView.setAdapter(goodsAdapter);
    }

    private void fillData(){
        int i=0;
        while (i < SIZE_OF_ARR) {
            i++;
            arr_goods.add(new Good(i," " + "My good №" + i, false));
        }
    }

    public void onClick(View view) {
        arr_checked_goods = goodsAdapter.getCheckedGoods();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putParcelableArrayListExtra("MyList", (ArrayList<? extends Parcelable>) arr_checked_goods);
        startActivity(intent);
    }
}
