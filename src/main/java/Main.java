import controllers.FileController;
import controllers.UserController;
import views.UserView;

public class Main {
    public static void main(String[] args) {
        FileController fileController = new FileController();
        UserView view = new UserView();
        UserController userController = new UserController(view, fileController);

        userController.init();
    }
}
