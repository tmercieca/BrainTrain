//Animal.java

package com.gapt.uni.braintrain;
public class Animal{
    private String name;
    private int drawable, soundRes;
    Animal(){}
    Animal (String name, int drawable, int soundRes){
            this.name = name;
            this.drawable = drawable;
            this.soundRes = soundRes;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
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
