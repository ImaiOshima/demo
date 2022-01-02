package com.wyh.demo.test;

public enum OneWeek {
    Mon(1,"星期一"),TUE(2,"星期二"),WEN(3,"星期三"),THU(4,"星期四"),FRI(5,"星期五"),SAT(6,"星期六"),SUN(7,"星期天");
    private int id;
    private String name;
    private OneWeek(int id,String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
