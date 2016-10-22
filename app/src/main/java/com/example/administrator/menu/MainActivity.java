package com.example.administrator.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mcount;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView);
        registerForContextMenu(tv1);    //  可实现长按。
    }

    //  创建选项菜单，该方法只在菜单项第一次显示时调用
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.mymenu,menu);

        /*  add(int groupId, int itemId, int order, CharSequence);
            groupId: 表示菜单项属于哪一组
            itemId：菜单项的标识符
            order：用于指定菜单项在选项菜单中的排列顺序
            CharSequence：表示才参详的标题
        */
        menu.add(0,1,0,R.string.m1);
        menu.add(0,1,0,R.string.m2);
        return super.onCreateOptionsMenu(menu);
    }

    // 用于在菜单显示前的相关事件处理， 每次菜单显示前都对调用该方法
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        mcount++;
        menu.add(0,2,0,"菜单"+mcount);
        return super.onPrepareOptionsPanel(view, menu);
    }

    // 选项菜单被选中之后的操作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    // 创建上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,R.string.m1);
        menu.add(0,2,0,R.string.m2);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // 上下文菜单被选中之后的操作
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_LONG).show();
        return super.onContextItemSelected(item);
    }
}
