package com.example.project_hw2;

import android.graphics.drawable.Drawable;

public class MusicData {

    private Integer photo; //앨범 이미지
    private String song; //노래 제목
    private String singer; //가수

    public void setPoster(Integer poster) {
        this.photo = poster;
    }  //값지정

    public void setPosterName(String posterName) {
        this.song = posterName;
    }

    public void setSinger(String singer){this.singer=singer;}

    public Integer getPoster() {
        return this.photo;
    } //값 가져오기

    public String getPosterName() {
        return this.song;
    }

    public String getSinger(){return this.singer;}
}
