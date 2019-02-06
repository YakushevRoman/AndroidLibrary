package com.example.user301.androidlibrary.AndroidFragment;

public class AndroidBox {
    private int rAndroidImage;
    private String rAndroidTitle;

    public AndroidBox(int rAndroidImage, String rAndroidTitle) {
        this.rAndroidImage = rAndroidImage;
        this.rAndroidTitle = rAndroidTitle;
    }

    public int getrAndroidImage() {
        return rAndroidImage;
    }

    public void setrAndroidImage(int rAndroidImage) {
        this.rAndroidImage = rAndroidImage;
    }

    public String getrAndroidTitle() {
        return rAndroidTitle;
    }

    public void setrAndroidTitle(String rAndroidTitle) {
        this.rAndroidTitle = rAndroidTitle;
    }
}
