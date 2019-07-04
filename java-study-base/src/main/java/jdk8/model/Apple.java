package jdk8.model;

public class Apple {
    private String id;
    private String color;
    private Integer weight;

    public Apple(String id, String color, Integer weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    public Apple() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }
}