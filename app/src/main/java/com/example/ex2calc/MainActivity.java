package com.example.ex2calc;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables to store operands and operator
    private String operand1 = "";
    private String operand2 = "";
    private String operator = "";

    // TextView to display input and result
    private TextView inputTextView;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextViews
        inputTextView = findViewById(R.id.inputTextView);
        resultTextView = findViewById(R.id.resultTextView);
    }

    // Method to handle number button clicks
    public void onNumberClick(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();
        operand2 += number;
        inputTextView.setText(operand2);
    }

    // Method to handle operator button clicks
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = operand2;
        operand2 = "";
    }

    // Method to handle equals button click
    public void onEqualsClick(View view) {
        double result = 0;
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);

        // Perform the operation based on the operator
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultTextView.setText("Error: Division by zero");
                    return;
                }
                break;
        }

        // Display the result
        resultTextView.setText(String.valueOf(result));
    }

    // Method to clear the input and result
    public void onClearClick(View view) {
        operand1 = "";
        operand2 = "";
        operator = "";
        inputTextView.setText("");
        resultTextView.setText("");
    }
}
