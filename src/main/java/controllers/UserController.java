package controllers;

import models.User;
import views.UserView;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserView view;
    private FileController fileController;

    public UserController(UserView view, FileController fileController) {
        this.view = view;
        this.fileController = fileController;
    }

    public void init() {
        processMenuInput();
    }

    private void processMenuInput() {
        int choice;

        while (true) {
            choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    printUsers();
                    break;
                case 2:
                    processAddUser();
                    break;
                case 3:
                    processUpdateUser();
                    break;
                case 4:
                    processDeleteUser();
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }

    private void processAddUser() {
        User user = view.getAddUser();
        List<User> userList = fileController.getUserList();

        if (userList == null) {
            userList = new ArrayList<>();
        }

        if (user != null) {
            User tempUser = userList.stream()
                    .filter(predicateUser -> user.getName().equals(predicateUser.getName()))
                    .findAny()
                    .orElse(null);

            if (tempUser == null) {
                userList.add(user);
                fileController.updateUsers(userList);
                System.out.println("User added");
            }
            else {
                System.out.println("User already exists");
            }

        }
    }

    private void processUpdateUser() {
        User user = view.getUpdatedUser();
        List<User> userList = fileController.getUserList();
        User tempUser = null;

        if (user != null) {
            tempUser = userList.stream()
                    .filter(predicateUser -> user.getName().equals(predicateUser.getName()))
                    .findAny()
                    .orElse(null);
        }

        if (tempUser != null) {
            tempUser.setAge(user.getAge());
            tempUser.setWeight(user.getWeight());
            fileController.updateUsers(userList);
            System.out.println("User updated");
        } else {
            System.out.println("User does not exist");
        }
    }

    private void processDeleteUser() {
        String name = view.getUserToDelete();
        List<User> userList = fileController.getUserList();

        User tempUser = userList.stream()
                .filter(predicateUser -> name.equals(predicateUser.getName()))
                .findAny()
                .orElse(null);

        if (tempUser != null) {
            userList.remove(tempUser);
            fileController.updateUsers(userList);
            System.out.println("User deleted");
        } else {
            System.out.println("User does not exist");
        }
    }

    private void printUsers() {
        System.out.println("User List: ");
        System.out.println(fileController.getUserList());
    }
}
