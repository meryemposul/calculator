package com.meryem.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_operator,tv_number,etDisplay,txtDisplay;

    Double number1 = 0d;
    Double number2 = 0d;
    Double factoriyel = 1.0;
    String pendingOp = "";

    boolean clear = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSettings();
    }

     private void viewSettings() {
         Button button_FACT = findViewById(R.id.button_FACT);
         Button button_AC = findViewById(R.id.button_AC);
         Button button_per = findViewById(R.id.button_per);
         Button button_div = findViewById(R.id.button_div);
         Button button_7 = findViewById(R.id.button_7);
         Button button_8 = findViewById(R.id.button_8);
         Button button_9 = findViewById(R.id.button_9);
         Button button_multi = findViewById(R.id.button_multi);
         Button button_4 = findViewById(R.id.button_4);
         Button button_5 = findViewById(R.id.button_5);
         Button button_6 = findViewById(R.id.button_6);
         Button button_minus = findViewById(R.id.button_minus);
         Button button_1 = findViewById(R.id.button_1);
         Button button_2 = findViewById(R.id.button_2);
         Button button_3 = findViewById(R.id.button_3);
         Button button_plus = findViewById(R.id.button_plus);
         Button button_0 = findViewById(R.id.button_0);
         Button button_vr = findViewById(R.id.button_vr);
         Button button_π = findViewById(R.id.button_π);
         Button button_equal = findViewById(R.id.button_equal);


         etDisplay= findViewById(R.id.etDisplay);
         tv_operator = findViewById(R.id.tv_operator);
         tv_number = findViewById(R.id.tv_number);

         View.OnClickListener numberLister = new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Button btn =(Button) view;
                 String text = btn.getText().toString();

                   if(clear){
                       etDisplay.setText("0");
                       clear =false;
                   }

                   if (etDisplay.getText().toString().equals("0") && !text.equals("."))
                       etDisplay.setText(text);
                   else
                       etDisplay.append(text);
             }
         };

         button_0.setOnClickListener(numberLister);
         button_1.setOnClickListener(numberLister);
         button_2.setOnClickListener(numberLister);
         button_3.setOnClickListener(numberLister);
         button_4.setOnClickListener(numberLister);
         button_5.setOnClickListener(numberLister);
         button_6.setOnClickListener(numberLister);
         button_7.setOnClickListener(numberLister);
         button_8.setOnClickListener(numberLister);
         button_9.setOnClickListener(numberLister);
         button_vr.setOnClickListener(numberLister);

         View.OnClickListener operrationListener = new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Button btn =(Button) view;
                 String op =btn.getText().toString();
                 String value = etDisplay.getText().toString();
                 Double dv = Double.valueOf(value);

                 performOp(dv, op);


             }
         };
         button_div.setOnClickListener(operrationListener);
         button_minus.setOnClickListener(operrationListener);
         button_multi.setOnClickListener(operrationListener);
         button_plus.setOnClickListener(operrationListener);
         button_equal.setOnClickListener(operrationListener);



         button_AC.setOnClickListener(new View.OnClickListener () {
             @Override
             public void onClick(View view) {
                 Double result = Double.valueOf(etDisplay.getText().toString());
                 result = result * 0;
                 number1 = 0d;
                 number2 = 0d;
                 factoriyel = 1.0;
                 pendingOp = "";
                 etDisplay.setText("0");
                 tv_operator.setText("0");
                 tv_number.setText("0");


             }
         });

         button_per.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Double result = Double.valueOf(etDisplay.getText().toString());
                 Double percentageValue = result / 100;
                 etDisplay.setText(String.valueOf(percentageValue));

             }
         });

         button_π.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Double dv = 3.1415926535897d;
                 etDisplay.setText(String.valueOf(dv));
             }
         });

         button_FACT.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Button btn =(Button) view;
                 String m =btn.getText().toString();
                 String value = etDisplay.getText().toString();
                 Double dm = Double.valueOf(value);
                 fac(m, dm);

             }
         });


    }
    private void fac(String m, Double dm){
        for (int i = 1; i <= dm; i++) {
            factoriyel = factoriyel * i;
        }

        Double result =factoriyel;
        etDisplay.setText(String.valueOf(result));

    }


    private void performOp(Double dv, String op) {
        Double result = 0d;
        if (number1 == 0  ||  number1 == 0.0 ) {
            number1 = dv;
            etDisplay.setText("0");
        } else {
            number2 = dv;

            if (!pendingOp.equals("=")) {
                result = 0d;
                switch (pendingOp) {

                    case "+":
                        result = number1 + number2;
                        break;

                    case "-":
                        result = number1 - number2;
                        break;

                    case "/":
                        result = number1 / number2;
                        break;

                    case "*":
                        result = number1 * number2;
                        break;


                }

                if (Math.round(result) == result) {
                    etDisplay.setText(String.valueOf(Math.round(result)));
                } else {
                    etDisplay.setText(String.valueOf(result));
                }

                number1 = result;
                number2 = 0d;
                clear = true;

            }
        }
        pendingOp = op;
        tv_number.setText(String.valueOf(number1));
        tv_operator.setText(pendingOp);

    }




    }



