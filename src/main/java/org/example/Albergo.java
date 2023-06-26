package org.example;
//test
public class Albergo {

    protected String desc;
    protected int id;
    protected String name;
    protected double price;
    protected boolean suite;


    public Albergo(String desc, int id, String name, double price, boolean suite) {
        this.desc = desc;
        this.id = id;
        this.name = name;
        this.price = price;
        this.suite = suite;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }
}
