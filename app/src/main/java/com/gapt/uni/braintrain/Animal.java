package com.gapt.uni.braintrain;

/**
 * Created by Thomas on 10/05/16.
 */
public class Animal{
    String name;
    int drawable, soundRes;
        Animal (String name, int drawable, int soundRes){
            this.name = name;
            this.drawable = drawable;
            this.soundRes = soundRes;
        }

    public String getName() {
        return name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getSoundRes(){
        return soundRes;
    }

    public void setSoundRes(int soundRes){
        this.soundRes = soundRes;
    }

}
