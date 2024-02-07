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
                    System.out.println("edit user");
                    break;
                case 4:
                    System.out.println("delete user");
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
            userList.add(user);
            fileController.updateUsers(userList);
        }
    }

    private void processUpdateUser() {
        User user = view.getUpdatedUser();
        List<User> userList = fileController.getUserList();


    }

    private void printUsers() {
        System.out.println(fileController.getUserList());
    }
}
