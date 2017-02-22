package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2017/2/19 0019.
 */

public class Result {
    /*省份*/
    String province;
    /*城市*/
    String city;
    /*区号编码*/
    String areacode;
    /*邮政编码*/
    String zip;
    /*运营商*/
    String company;
    /*错误码*/
    String error_code;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", areacode='" + areacode + '\'' +
                ", zip='" + zip + '\'' +
                ", company='" + company + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
