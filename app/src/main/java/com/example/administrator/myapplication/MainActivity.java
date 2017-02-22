package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb;
    private MenuInflater menuInflater;
    private ActionBar mActionBar;
    private EditText fin;
    private EditText et_phone_number;
    private Boolean isSearch = false;
    private String phonenumber;
    private PhoneNumberBean phoneNumberBean;
    private String city;
    private String areacode;
    private String company;
    private String error_code;
    private String province;
    private String zip;
    private EditText etPhoneNumber;
    private EditText etZip;
    private EditText etProvince;
    private EditText etCompany;
    private EditText etCity;
    private EditText etAreaCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.Ext.init(getApplication());
        setContentView(com.example.administrator.myapplication.R.layout.activity_main);
        findViews();
        setSupportActionBar(tb);
        mActionBar = getSupportActionBar();
//        if (mActionBar != null) {
//            mActionBar.setHomeAsUpIndicator(R.mipmap.search_hei_24px);
//            mActionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

    private void findViews() {
        tb = (Toolbar) findViewById(com.example.administrator.myapplication.R.id.mtool_bar);
        etAreaCode = (EditText) findViewById(com.example.administrator.myapplication.R.id.et_areacode);
        etCity = (EditText) findViewById(com.example.administrator.myapplication.R.id.et_city);
        etCompany = (EditText) findViewById(com.example.administrator.myapplication.R.id.et_company);
        etProvince = (EditText) findViewById(com.example.administrator.myapplication.R.id.et_province);
        etZip = (EditText) findViewById(com.example.administrator.myapplication.R.id.et_zip);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu, menu);
//        return true;
//    }

    public void onClick(View view) {
        //检测输入框的内容是否符合规范
        isResonable();
        if (isSearch) {
            //执行查询方法
            searchPN();
        }
    }

    private void searchPN() {
        RequestParams params = new RequestParams("http://apis.juhe.cn/mobile/get?phone=" + phonenumber + "&key=fc85daabcb3dc778870f64a0300ee569");
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                phoneNumberBean = gson.fromJson(result, PhoneNumberBean.class);
                Result phoneResult = phoneNumberBean.getResult();
                city = phoneResult.getCity();
                areacode = phoneResult.getAreacode();
                company = phoneResult.getCompany();
                error_code = phoneResult.getError_code();
                province = phoneResult.getProvince();
                zip = phoneResult.getZip();
                setETContent();
            }

            private void setETContent() {
                etProvince.setText(province);
                etCity.setText(city);
                etAreaCode.setText(areacode);
                etZip.setText(zip);
                etCompany.setText(company);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void isResonable() {
        et_phone_number = (EditText) findViewById(com.example.administrator.myapplication.R.id.et_phone_number);
        phonenumber = et_phone_number.getText().toString();
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(phonenumber);
        if ((phonenumber.length() == 11) && (m.matches())) {
            //可以查询方法
            isSearch = true;
        } else {
            ToastView.show(getApplication(), "输入号码不正确");
            et_phone_number.setText("");
        }
    }

}
