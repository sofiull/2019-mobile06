package id.ac.polinema.idealbodyweight.util;

public class BMIndex{
    private int mass;
    private int height;
    private String classification;

    public BMIndex(int mass,int height){
        this.mass = mass;
        this.height = height;
        this.classification = check();
    }

    public String getClassification(){ return classification; }

    private  String check(){
        float hasil = mass/height*height;
        if(hasil < 18.50){
            return "UnderWeight";
        }else if(hasil >= 18.50 || hasil <= 25){
            return "Normal";
        }else{
            return "OverWeight";
        }
    }

}