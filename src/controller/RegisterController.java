package controller;

import model.RegisterModel;
import view.RegisterView;

public class RegisterController {

    private RegisterView view;


    public RegisterController(RegisterView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getSubmitButton().addActionListener(e -> submitForm());
        view.getResetButton().addActionListener(e -> clearForm());

    }

    private void clearForm() {
        view.clearForm();
    }



    private void submitForm() {

        if (!view.isTermsAccepted()) {
            view.showMessage("Please accept terms");
            return;
        }

        if (view.getUsername().isEmpty()) {
            view.showMessage("Username required");
            return;
        }

        RegisterModel user = new RegisterModel();
        user.setUsername(view.getUsername());
        user.setMobile(view.getMobile());
        user.setGender(view.getGender());
        user.setDob(view.getDOB());
        user.setAddress(view.getAddress());

        String output =
                "Username: " + user.getUsername() + "\n" +
                        "Mobile: " + user.getMobile() + "\n" +
                        "Gender: " + user.getGender() + "\n" +
                        "DOB: " + user.getDob() + "\n" +
                        "Address: " + user.getAddress();

        view.showOutput(output);
    }
}
