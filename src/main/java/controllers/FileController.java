package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private final String JSON_PATH = "src/main/resources/users.json";
    private List<User> userList = new ArrayList<>();

    public FileController() {
        populateUserList();
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public void updateUsers(List<User> userList) {
        try {
            writeUsersToJson(userList);
            this.userList = userList;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateUserList() {
        try {
            userList = readJson();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<User> readJson() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_PATH));
        Gson gson = new Gson();

        return gson.fromJson(bufferedReader, new TypeToken<List<User>>(){}.getType());
    }

    private void writeUsersToJson(List<User> userList) throws IOException {
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter(JSON_PATH);
        fileWriter.write(gson.toJson(userList));
        fileWriter.close();
    }
}
