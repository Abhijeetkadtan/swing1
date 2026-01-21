import controller.RegisterController;

import view.RegisterView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{

            RegisterView registerView = new RegisterView();
            RegisterController registerController = new RegisterController( registerView);
        });
    }
}
//for new branch