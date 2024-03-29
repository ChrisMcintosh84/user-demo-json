package models;

public class User {
    private String name;
    private int age;
    private double weight;

    public User() {
    }

    public User(java.lang.String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
