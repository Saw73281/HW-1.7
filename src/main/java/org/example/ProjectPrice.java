package org.example;

public class ProjectPrice {
    private int name;
    private int price;

    public ProjectPrice(int name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }
}
