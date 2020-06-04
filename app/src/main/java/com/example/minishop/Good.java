package com.example.minishop;

public class Good {

    int _id;
    String _name;
    Boolean _check;

    public Good() {

    }

    public Good(int id, String _name, boolean _check) {
        this._id = id;
        this._name = _name;
        this._check = _check;
    }

    // getting ID
    public int getId(){
        return this._id;
    }

    // setting id
    public void setId(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public Boolean isCheck(){
        return this._check;
    }

    public void setCheck(Boolean check){
        this._check = check;
    }

}