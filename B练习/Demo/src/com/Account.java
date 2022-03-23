package com;

public class Account {
    private String name;
    private double rest;
    private String passwd;

    public Account(){

    }

    public Account(String name,double rest,String passwd){
        this.setName(name);
        this.setRest(rest);
        this.setPasswd(passwd);
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4){
            this.name = name;
        } else {
            System.out.println("输入的名字长度应该为2到4位！，默认为空");
        }
    }

    public void setRest(double rest) {
        if (rest > 20){
            this.rest = rest;
        } else {
            System.out.println("余额应该大于20！默认为0");
        }
    }

    public void setPasswd(String passwd) {
        if (passwd.length() == 6){
            this.passwd = passwd;
        } else {
            System.out.println("应设置密码为6位！默认为000000");
        }
    }

    public void showInfo(){
        System.out.println("姓名：" + this.name + " 余额：" + this.rest + " 密码：" + this.passwd);
    }
}

