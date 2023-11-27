package org.example;

public class Bread {
    public String breadType;

    public Bread (String breadType)
    {
        this.breadType=breadType;
    }
    public String getBreadType()
    {
        return breadType;
    }
    public void setBreadType(String breadType)
    {
        this.breadType= breadType;
    }
    public void toast(){
        System.out.println("Toasting the " + breadType + "bread...");
    }
}
