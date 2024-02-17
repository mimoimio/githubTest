package com.example.newgencalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Currency;

public class MainActivity extends AppCompatActivity {
    long currentNumber = 0;
    int prevNumber = 0,outputNumber;
    String currentSymbol;
    String cumNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }

    public void onClick(View v) {
        int randomInt = (int) ((Math.random()*100)+(Math.random()*10));
        TextView OutputScreen = findViewById(R.id.OutputScreen);
        if (v instanceof Button) {
            Button clickedButton = (Button) v;
            String buttonText = clickedButton.getText().toString();

            try {
                currentNumber = Long.parseLong(""+currentNumber+buttonText);
                ((TextView)OutputScreen).setText(""+currentNumber);
                if (currentNumber==149292){
                    Intent intent = new Intent(this, PostActivity.class);
                    currentNumber=0;
                    ((TextView)OutputScreen).setText(""+currentNumber);
                    startActivity(intent);
                }
//                int buttonsNumber = Integer.parseInt(buttonText);
                // Now, 'number' contains the integer value
//                cumNumber = cumNumber + number;
//                System.out.println(cumNumber);
//                System.out.println(number);
//                ((TextView)OutputScreen).setText((""+number));
            } catch (NumberFormatException e) {
                currentSymbol = buttonText;
                if (currentSymbol.compareTo("Clear") == 0){
                    currentNumber = (long)0;
                }
                System.out.println(currentSymbol);
                ((TextView)OutputScreen).setText(currentSymbol);
//                switch (currentSymbol){
//                    case "=":
//                        switch (currentSymbol){
//                            case "+":
//                                outputNumber = prevNumber + currentNumber;
//                                break;
//                            case "-":
//                                outputNumber = prevNumber - currentNumber;
//                                break;
//                            case "*":
//                                outputNumber = prevNumber * currentNumber;
//                                break;
//                            case "/":
//                                outputNumber = prevNumber / currentNumber;
//                                break;
//                            case "=":
//                                outputNumber = prevNumber = currentNumber;
//                                break;
//                        }
//                        break;
//                    default:
//                        break;
//                }
            }

        }
//        OutputScreen.setText(outputNumber);
//        TextView OutputScreen = findViewById(R.id.OutputScreen);
//        OutputScreen.setText(""+randomInt);

    }

}