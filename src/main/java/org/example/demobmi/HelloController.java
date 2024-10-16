package org.example.demobmi;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class HelloController {


    @FXML
    private TextField heightField1;
    @FXML
    private TextField weightField1;
    @FXML
    private Button calculateButton;
    @FXML
    private Label resultLabel;
    @FXML
    private Label bmiStatusLabel;
    @FXML
    private TextField heightField2;
    @FXML
    private TextField weightField2;
    @FXML
    private Button calculateButton1;
    @FXML
    private Label resultLabel1;
    @FXML
    private Label bmiStatusLabel1;

    DecimalFormat df = new DecimalFormat("#.##");

    @FXML
    private void calculateMetricBMI() {
        try {
            double height = Double.parseDouble(heightField1.getText());
            double weight = Double.parseDouble(weightField1.getText());
            double bmi = weight / ((height / 100.0) * (height / 100.0));
            resultLabel.setText(String.format("BMI: %s", df.format(bmi)));
            bmiStatusLabel.setText(getBMIStatus(bmi));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
            bmiStatusLabel.setText("");
        }
    }

    @FXML
    private void calculateEnglishBMI() {
        try {
            double height = Double.parseDouble(heightField2.getText());
            double weight = Double.parseDouble(weightField2.getText());
            double bmi = weight * 703.0 / (height * height);
            resultLabel1.setText(String.format("BMI: %s", df.format(bmi)));
            bmiStatusLabel1.setText(getBMIStatus(bmi));
        } catch (NumberFormatException e) {
            resultLabel1.setText("Invalid input");
            bmiStatusLabel1.setText("");
        }
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
