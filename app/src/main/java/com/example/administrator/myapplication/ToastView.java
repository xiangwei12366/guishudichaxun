package com.example.administrator.myapplication;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class ToastView {
    public static void show(Context context,String string){
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }
}
