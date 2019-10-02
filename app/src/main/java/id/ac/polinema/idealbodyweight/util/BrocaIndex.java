package id.ac.polinema.idealbodyweight.util;

public class BrocaIndex {
    public static final int Male = 0;
    public static final int  Female= 1;

    private int gender;
    private  int height;
    private  float index;

    public BrocaIndex(int gender, int height){
        this.gender=gender;
        this.height=height;
        this.calculate();
    }

    public float getIndex(){
        return index;
    }

    private float calculate() {
        switch (gender){
            case Male: return (height-100) - ((height-100)*0.1f);
            case Female: return  (height-100) + ((height-100)*0.15f);
            default: return 0f;
        }

    }
}
