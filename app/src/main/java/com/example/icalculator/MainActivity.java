package com.example.icalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isValid = false;

    private double firstNumber = 0;

    public String screenContent;
    public String dummy;
    private int secondNumberIndex = 0;

    private char currentOp;

    TextView proses;
    TextView calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proses = findViewById(R.id.proses);
        calc = findViewById(R.id.calc);
        proses.setText("");
        calc.setText("0");

        final Button xp = findViewById(R.id.xp);
        final Button sqr = findViewById(R.id.sqr);
        final Button sqry = findViewById(R.id.sqry);

        final Button sin = findViewById(R.id.sin);
        final Button cos = findViewById(R.id.cos);
        final Button tan = findViewById(R.id.tan);

        final Button e = findViewById(R.id.e);
        final Button log = findViewById(R.id.log);
        final Button abs = findViewById(R.id.abs);

        final Button pie = findViewById(R.id.pie);
        final Button ln = findViewById(R.id.ln);
        final Button flr = findViewById(R.id.flr);

        final Button x2 = findViewById(R.id.x2);
        final Button x3 = findViewById(R.id.x3);
        final Button xy = findViewById(R.id.xy);

        final Button percent = findViewById(R.id.percent);
        final Button zero = findViewById(R.id.zero);
        final Button dot = findViewById(R.id.dot);
        final Button equal = findViewById(R.id.equal);

        final Button one = findViewById(R.id.one);
        final Button two = findViewById(R.id.two);
        final Button three = findViewById(R.id.three);

        final Button four = findViewById(R.id.four);
        final Button five = findViewById(R.id.five);
        final Button six = findViewById(R.id.six);
        final Button plus = findViewById(R.id.plus);

        final Button seven = findViewById(R.id.seven);
        final Button eight = findViewById(R.id.eight);
        final Button nine = findViewById(R.id.nine);
        final Button minus = findViewById(R.id.minus);

        final Button clear = findViewById(R.id.clear);
        final Button divide = findViewById(R.id.divide);
        final Button times = findViewById(R.id.times);
        final Button del = findViewById(R.id.del);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {

            public void onClick(View v) {

                final int id = v.getId();
                switch (id) {
                    case R.id.xp:
                        dummy = calc.getText().toString();
                        screenContent = proses.getText().toString();

                        if (screenContent.isEmpty())  {
                            proses.setText("");
                        }
                        else if (screenContent.charAt((screenContent.length()-1)) == '÷' || screenContent.charAt((screenContent.length()-1)) == 'x' || screenContent.charAt((screenContent.length()-1)) == '+' || screenContent.charAt((screenContent.length()-1)) == '-' || screenContent.charAt((screenContent.length()-1)) == '.') {
                            screenContent = screenContent.substring(0, screenContent.length()-1) + "!";
                            proses.setText(screenContent);
                        }
                        else {
                            proses.append("!");
                        }
                        break;
                    case R.id.sqr:
                        proses.append("√");
                        break;
                    case R.id.sqry:
                        proses.append("^(1÷");
                        break;
                    case R.id.sin:
                        proses.append("SIN");
                        break;
                    case R.id.cos:
                        proses.append("COS");
                        break;
                    case R.id.tan:
                        proses.append("TAN");
                        break;
                    case R.id.e:
                        proses.append("e");
                        break;
                    case R.id.log:
                        proses.append("LOG");
                        break;
                    case R.id.abs:
                        dummy = calc.getText().toString();

                        if (dummy.isEmpty())  {
                            calc.setText("");
                        }
                        else {
                            double endresult = Math.abs(Double.parseDouble(dummy));
                            if (endresult % 1 == 0) {

                                calc.setText(String.valueOf((int) endresult));
                            }
                            else {
                                calc.setText(String.valueOf(endresult));
                            }
                        }
                        break;
                    case R.id.pie:
                        proses.append("π");
                        break;
                    case R.id.ln:
                        proses.append("LN");
                        break;
                    case R.id.flr:
                        dummy = calc.getText().toString();

                        if (dummy.isEmpty())  {
                            calc.setText("");
                        }
                        else {

                            double endresult = Math.floor(Double.parseDouble(dummy));
                            if (endresult % 1 == 0) {

                                calc.setText(String.valueOf((int) endresult));
                            }
                            else {
                                calc.setText(String.valueOf(endresult));
                            }
                        }
                        break;
                    case R.id.x2:
                        proses.append("^(2)");
                        break;
                    case R.id.x3:
                        proses.append("^(3)");
                        break;
                    case R.id.xy:
                        proses.append("^");
                        break;
                    case R.id.one:
                        proses.append("1");
                        break;
                    case R.id.two:
                        proses.append("2");
                        break;
                    case R.id.three:
                        proses.append("3");
                        break;
                    case R.id.four:
                        proses.append("4");
                        break;
                    case R.id.five:
                        proses.append("5");
                        break;
                    case R.id.six:
                        proses.append("6");
                        break;
                    case R.id.seven:
                        proses.append("7");
                        break;
                    case R.id.eight:
                        proses.append("8");
                        break;
                    case R.id.nine:
                        proses.append("9");
                        break;
                    case R.id.zero:
                        proses.append("0");
                        break;
                    case R.id.dot:
                        screenContent = proses.getText().toString();
                        if (screenContent.isEmpty())  {
                            proses.append(".");
                        }
                        else if (screenContent.charAt((screenContent.length()-1)) == '.') {
                            screenContent = screenContent.substring(0, screenContent.length()-1) + ".";
                            proses.setText(screenContent);
                        }
                        else {
                            proses.append(".");
                        }
                        break;
                    case R.id.percent:
                        dummy = calc.getText().toString();
                        screenContent = proses.getText().toString();

                        if (screenContent.isEmpty())  {
                            proses.setText("");
                        }
                        else if (screenContent.charAt((screenContent.length()-1)) == '÷' || screenContent.charAt((screenContent.length()-1)) == 'x' || screenContent.charAt((screenContent.length()-1)) == '+' || screenContent.charAt((screenContent.length()-1)) == '-' || screenContent.charAt((screenContent.length()-1)) == '.') {
                            screenContent = screenContent.substring(0, screenContent.length()-1) + "%";
                            proses.setText(screenContent);
                        }
                        else {
                            proses.append("%");
                        }
                        break;
                    case R.id.plus:
                        dummy = calc.getText().toString();
                        screenContent = proses.getText().toString();

                        if (screenContent.isEmpty())  {
                            proses.setText("");
                        }
                        else if (screenContent.charAt((screenContent.length()-1)) == '÷' || screenContent.charAt((screenContent.length()-1)) == 'x' || screenContent.charAt((screenContent.length()-1)) == '+' || screenContent.charAt((screenContent.length()-1)) == '-' || screenContent.charAt((screenContent.length()-1)) == '.') {
                            screenContent = screenContent.substring(0, screenContent.length()-1) + "+";
                            proses.setText(screenContent);
                        }
                        else {
                            proses.append("+");
                        }
                        break;
                    case R.id.minus:
                        dummy = calc.getText().toString();
                        screenContent = proses.getText().toString();

                        if (screenContent.isEmpty())  {
                            proses.setText("");
                        }
                        else if (screenContent.charAt((screenContent.length()-1)) == '÷' || screenContent.charAt((screenContent.length()-1)) == 'x' || screenContent.charAt((screenContent.length()-1)) == '+' || screenContent.charAt((screenContent.length()-1)) == '-' || screenContent.charAt((screenContent.length()-1)) == '.') {
                            screenContent = screenContent.substring(0, screenContent.length()-1) + "-";
                            proses.setText(screenContent);
                        }
                        else {
                            proses.append("-");
                        }
                        break;
                    case R.id.divide:
                        dummy = calc.getText().toString();
                        screenContent = proses.getText().toString();

                        if (screenContent.isEmpty())  {
                            proses.setText("");
                        }
                        else if (screenContent.charAt((screenContent.length()-1)) == '÷' || screenContent.charAt((screenContent.length()-1)) == 'x' || screenContent.charAt((screenContent.length()-1)) == '+' || screenContent.charAt((screenContent.length()-1)) == '-' || screenContent.charAt((screenContent.length()-1)) == '.') {
                            screenContent = screenContent.substring(0, screenContent.length()-1) + "÷";
                            proses.setText(screenContent);
                        }
                        else {
                            proses.append("÷");
                        }
                        break;
                    case R.id.times:
                        dummy = calc.getText().toString();
                        screenContent = proses.getText().toString();

                        if (screenContent.isEmpty())  {
                            proses.setText("");
                        }
                        else if (screenContent.charAt((screenContent.length()-1)) == '÷' || screenContent.charAt((screenContent.length()-1)) == 'x' || screenContent.charAt((screenContent.length()-1)) == '+' || screenContent.charAt((screenContent.length()-1)) == '-' || screenContent.charAt((screenContent.length()-1)) == '.') {
                            screenContent = screenContent.substring(0, screenContent.length()-1) + "x";
                            proses.setText(screenContent);
                        }
                        else {
                            proses.append("x");
                        }
                        break;
                    case R.id.equal:
                        screenContent = proses.getText().toString();
                        if (screenContent.equals(""))  {
                            proses.setText("");
                            calc.setText("0");
                            isValid = false;
                        }
                        else if (screenContent == ".") {
                            proses.setText(".");
                            calc.setText("0");
                            isValid = false;
                        }
                        else {
                            if (!screenContent.contains("÷") && !screenContent.contains("x") && !screenContent.contains("%") && !screenContent.contains("+") && !screenContent.contains("-") && !screenContent.contains("!")
                                    && !screenContent.contains("√") && !screenContent.contains("^(1÷") && !screenContent.contains("SIN") && !screenContent.contains("COS") && !screenContent.contains("TAN")
                                    && !screenContent.contains("LOG") && !screenContent.contains("ABS") && !screenContent.contains("LN") && !screenContent.contains("FLR") && !screenContent.contains("e") && !screenContent.contains("π")) {
                                calc.setText(screenContent);
                            }
                            else if ((!screenContent.contains("÷") && !screenContent.contains("x") && !screenContent.contains("+") && !screenContent.contains("-")
                                    && !screenContent.contains("√") && !screenContent.contains("^(1÷") && !screenContent.contains("SIN") && !screenContent.contains("COS") && !screenContent.contains("TAN")
                                    && !screenContent.contains("LOG") && !screenContent.contains("ABS") && !screenContent.contains("LN") && !screenContent.contains("FLR") && !screenContent.contains("e")) && (screenContent.contains("π") || screenContent.contains("%") || screenContent.contains("!"))) {
                                isValid = true;
                            }
                            else if (screenContent.charAt(screenContent.length()-1) == '÷' || screenContent.charAt(screenContent.length()-1) == 'x' || screenContent.charAt(screenContent.length()-1) == '%' || screenContent.charAt(screenContent.length()-1) == '+' || screenContent.charAt(screenContent.length()-1) == '-') {
                                screenContent = screenContent.substring(0, screenContent.length() - 1);
                                isValid = true;

                            }
                            else if (!screenContent.matches(".*\\d.*")) {

                                if (screenContent.contains("e") || screenContent.contains("π")) {
                                    isValid = true;
                                }
                                else {
                                    calc.setText("Error");
                                    isValid = false;
                                }

                            }
                            else {
                                isValid = true;
                            }

                        }

                        if (isValid = true) {

                            if (screenContent.isEmpty()) {
                                proses.setText("");
                                calc.setText("0");
                                isValid = false;
                            }
                            else if (screenContent.equals(".")) {
                                proses.setText(".");
                                calc.setText("0");
                                isValid = false;
                            }
                            else {
                                expression ep = new expression(screenContent);
                                String res = ep.sort();
                                double endresult = Double.parseDouble(res);
                                if (endresult % 1 == 0) {

                                    calc.setText(String.valueOf((int) endresult));
                                }
                                else {
                                    calc.setText(String.valueOf(endresult));
                                }
                            }

                        }

                        break;

                }
            }
        };

        xp.setOnClickListener(calculatorListener);
        sqr.setOnClickListener(calculatorListener);
        sqry.setOnClickListener(calculatorListener);

        sin.setOnClickListener(calculatorListener);
        cos.setOnClickListener(calculatorListener);
        tan.setOnClickListener(calculatorListener);

        e.setOnClickListener(calculatorListener);
        log.setOnClickListener(calculatorListener);
        pie.setOnClickListener(calculatorListener);

        abs.setOnClickListener(calculatorListener);
        ln.setOnClickListener(calculatorListener);
        flr.setOnClickListener(calculatorListener);

        x2.setOnClickListener(calculatorListener);
        x3.setOnClickListener(calculatorListener);
        xy.setOnClickListener(calculatorListener);

        one.setOnClickListener(calculatorListener);
        two.setOnClickListener(calculatorListener);
        three.setOnClickListener(calculatorListener);
        four.setOnClickListener(calculatorListener);
        five.setOnClickListener(calculatorListener);
        six.setOnClickListener(calculatorListener);
        seven.setOnClickListener(calculatorListener);
        eight.setOnClickListener(calculatorListener);
        nine.setOnClickListener(calculatorListener);
        zero.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
        percent.setOnClickListener(calculatorListener);
        plus.setOnClickListener(calculatorListener);
        minus.setOnClickListener(calculatorListener);
        divide.setOnClickListener(calculatorListener);
        times.setOnClickListener(calculatorListener);
        equal.setOnClickListener(calculatorListener);

        del.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String displayedElements = proses.getText().toString();
                int length = displayedElements.length();
                if (length > 0) {

                    if (displayedElements.charAt(length-1) == 'N' || displayedElements.charAt(length-1) == 'S' || displayedElements.charAt(length-1) == 'G') {

                        while((displayedElements.charAt(displayedElements.length()-1) == 'S' || displayedElements.charAt(displayedElements.length()-1) == 'I' || displayedElements.charAt(displayedElements.length()-1) == 'N' || displayedElements.charAt(displayedElements.length()-1) == 'T' || displayedElements.charAt(displayedElements.length()-1) == 'C' ||
                                displayedElements.charAt(displayedElements.length()-1) == 'A' || displayedElements.charAt(displayedElements.length()-1) == 'O' || displayedElements.charAt(displayedElements.length()-1) == 'L' || displayedElements.charAt(displayedElements.length()-1) == 'G') && (displayedElements.length()-1 != -1) ) {

                            displayedElements = displayedElements.substring(0, displayedElements.length()-1);
                        }
                    }
                    else {
                        displayedElements = displayedElements.substring(0, length-1);
                    }
                    proses.setText(displayedElements);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                proses.setText("");
                calc.setText("0");
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("screen", screenContent);
        outState.putString("calc", dummy);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        screenContent = savedInstanceState.getString("screen");
        dummy = savedInstanceState.getString("calc");
        proses.setText(screenContent);
        calc.setText(dummy);
    }
}
