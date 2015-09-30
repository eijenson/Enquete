package com.example.kobayashi_ma.enquete.bean;

/**
 * Created by kobayashi-ma on 2015/09/04.
 */
public class Choice {
    private Long id;
    /** 選択肢名 */
    private String name;
    /** 選択肢順 */
    private int number;
    /** 選択された数 */
    private int value;

    public Choice(){
        id= java.util.Calendar.getInstance().getTimeInMillis();
        name = "123";
        number = 1;
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
