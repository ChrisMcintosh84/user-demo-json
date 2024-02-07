package views;

import models.User;

import java.util.Scanner;

public class UserView {
    private Scanner input = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("---User Management---");
        System.out.println("1) List users");
        System.out.println("2) Add user");
        System.out.println("3) Edit user");
        System.out.println("4) Remove user");
        System.out.println("5) Exit");

        return input.nextInt();
    }

    public User getAddUser() {
        System.out.println("Enter name: ");
        String name = input.next();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        System.out.println("Enter weight in kgs: ");
        double weight = input.nextDouble();

        System.out.println("Is this correct?");
        System.out.println("User: " + name + ", Age: " + age + ", Weight(kgs): " + weight + " (Y/N)");
        String choice = input.next().toLowerCase();

        if (choice.equals("y")) {
            return new User(name, age, weight);
        }
        return null;
    }

    public User getUpdatedUser() {
        System.out.println("Enter name of user to update: ");
        String name = input.next();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        System.out.println("Enter weight in kgs: ");
        double weight = input.nextDouble();

        System.out.println("Is this correct?");
        System.out.println("User: " + name + ", Age: " + ", Weight(kgs): " + weight + " (Y/N)");
        String choice = input.next().toLowerCase();

        if (choice.equals("y")) {
            return new User(name, age, weight);
        }
        return null;
    }
}
