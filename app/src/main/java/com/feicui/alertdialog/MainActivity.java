package com.feicui.alertdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_show;
    private View view_custom;
    private Context mContext;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        btn_show = (Button) findViewById(R.id.btn_show);

        //初始化Builder
        builder = new AlertDialog.Builder(mContext);

        //加载自定义的那个View,同时设置下'
        final LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        view_custom = inflater.inflate(R.layout.view_dialog_custom, null, false);
        builder.setView(view_custom);
        builder.setCancelable(false);
        alert = builder.create();
        //点叉
        view_custom.findViewById(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });
        //访问博客
        view_custom.findViewById(R.id.btn_blog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "访问博客", Toast.LENGTH_SHORT).show();
              Uri url = Uri.parse("http://blog.csdn.net/coder_pig");
            //    Uri url = Uri.parse("http://www.runoob.com/w3cnote/android-tutorial-alertdialog.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
                alert.dismiss();
            }
        });

        //关闭按钮
        view_custom.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "对话框已关闭~", Toast.LENGTH_SHORT).show();
                alert.dismiss();
            }
        });
        //show
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });
    }
}
