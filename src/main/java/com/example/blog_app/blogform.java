package com.example.blog_app;
import java.sql.Date;
public class blogform {//送る要素のクラス
    private String name;
    private String title;
    private String text;

    public blogform(String name,Date birth_day,String title,String text){
        this.name=name;
        this.title=title;
        this.text=text;
    }public String getName() {
        return name;
    }
    public String getText() {
        return text;
    }
    public String getTitle() {
        return title;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
