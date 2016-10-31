package com.example.jhona.boaviagem.domains;

/**
 * Created by jhona on 30/10/2016.
 */

public class DashItensMenu {
    private String mainTitle;
    private String text;
    private int picture;

    public DashItensMenu(){

    }
    public DashItensMenu(String mainTitle, String text, int picture){
        setMainTitle(mainTitle);
        setText(text);
        setPicture(picture);
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
