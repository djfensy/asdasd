package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText sideAInput, sideBInput;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText sideAEditText = findViewById(R.id.sideAEditText);
        EditText sideBEditText = findViewById(R.id.sideBEditText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateHypotenuse();
            }
        });
    }

    private void calculateHypotenuse() {
        String sideAString = sideAInput.getText().toString();
        String sideBString = sideBInput.getText().toString();

        if (sideAString.isEmpty() || sideBString.isEmpty()) {
            showToast("Введите значения для обеих сторон.");
            return;
        }

        double sideA = Double.parseDouble(sideAString);
        double sideB = Double.parseDouble(sideBString);

        double hypotenuse = Math.sqrt(sideA * sideA + sideB * sideB);
        showToast("Длина гипотенузы равна: " + hypotenuse);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}