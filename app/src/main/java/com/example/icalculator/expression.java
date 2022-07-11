package com.example.icalculator;

import java.nio.DoubleBuffer;

public class expression {

    private String exp;
    private String before, after;

    public expression(String exp) {

        this.exp = exp;

    }

    public String sqr() {
        int post, opin;
        int indexscan;
        String value= "";
        char scan = 0;
        opin = exp.indexOf("√");
        indexscan = opin;

        while (!((scan == '÷' || scan == '+' || scan == '-' || scan == 'x' || scan == '%') || indexscan == exp.length() - 1)) {

            indexscan++;
            scan = exp.charAt(indexscan);
        }

        post = indexscan;
        if (post != (exp.length() - 1)) {
            post--;
        }
        System.out.println(post);
        double dummy;
        if (post == exp.length()-1) {

            dummy = Double.parseDouble(exp.substring(opin+1));
        }
        else {
            dummy = Double.parseDouble(exp.substring(opin+1, post+1));
        }
        System.out.println(dummy);
        before = exp.substring(0, opin);
        System.out.println("before: " + before);
        after = exp.substring(post+1);

        dummy = Math.sqrt(dummy);
        if (!(exp.contains("/") || exp.contains("x") || exp.contains("+") || exp.contains("-")) && exp.charAt(0) == '√'){
            value = before + dummy;
        }
        else {
            value = before + dummy + after;
        }

        return (value);
    }

    public double sqry () {

        String no1, no2;
        no1 = exp.substring(preVal("^"), exp.indexOf("^"));
        System.out.println(no1);
        no2 = exp.substring(exp.indexOf("÷") + 1, postVal("÷") + 1);
        System.out.println(no2);
        before = exp.substring(0, preVal("^"));
        after = exp.substring(postVal("÷") + 1);
        double val1=0, val2=0;
        double answer;

        val1 = Double.parseDouble(no1);
        val2 = Double.parseDouble(no2);

        answer = Math.pow(val1, (1/ val2));

        return (answer);
    }

    public String factorial() {
        int facto, opin;
        int indexscan;
        String value= "";
        char scan = 0;
        opin = exp.indexOf("!");
        indexscan = opin;
        while (!((scan == '÷' || scan == '+' || scan == '-' || scan == 'x' || scan == '%' || scan == '!') || indexscan == 0)) {

            indexscan--;
            scan = exp.charAt(indexscan);
            System.out.println(scan);
        }
        facto = indexscan;

        if (facto != 0) {
            facto++;
        }
        double dummy = Double.parseDouble(exp.substring(facto, opin));
        before = exp.substring(0, facto);
        after = exp.substring(opin+1);
        double factorial = 1;
        for(int i = 1; i <= dummy; ++i)
        {
            factorial *= i;
        }
        dummy = factorial;
        if (!(exp.contains("/") || exp.contains("*") || exp.contains("+") || exp.contains("-")) && exp.charAt(exp.length()-1) == '!'){
            value = before + dummy;
        }
        else if (!((exp.charAt(opin +1) == '÷' || exp.charAt(opin +1) == 'x' || exp.charAt(opin +1) == '+' || exp.charAt(opin +1) == '-')) && opin != exp.length()-1 ) {

            value = before + dummy + "x" + after;
        }
        else {
            value = before + dummy + after;
        }
        return (value);
    }

    private String log() {
        String no1;
        no1 = exp.substring(exp.indexOf("G") + 1, postVal("G") + 1);
        before = exp.substring(0, preVal("L"));
        after = exp.substring(postVal("G") + 1);
        double val1 = 0;
        double answer = 0;
        val1 = Double.parseDouble(no1);
        answer = Math.log(val1);
        String value = "";
        if (!before.isEmpty() && !((exp.charAt(exp.indexOf("L")-1) == '+') && (exp.charAt(exp.indexOf("L")-1) == '-') && (exp.charAt(exp.indexOf("L")-1) == 'X') && (exp.charAt(exp.indexOf("L")-1) == '÷')) ) {
            value = "x" + answer;
        }
        else {
            value = String.valueOf(answer);
        }

        return (value);
    }

    private String ln() {
        String no1;
        no1 = exp.substring(exp.indexOf("N") + 1, postVal("N") + 1);
        before = exp.substring(0, preVal("L"));
        after = exp.substring(postVal("N") + 1);
        double val1 = 0;
        double answer = 0;
        val1 = Double.parseDouble(no1);
        answer = Math.pow(Math.log10(val1), val1);
        String value = "";
        if (!before.isEmpty() && !((exp.charAt(exp.indexOf("L")-1) == '+') && (exp.charAt(exp.indexOf("L")-1) == '-') && (exp.charAt(exp.indexOf("L")-1) == 'X') && (exp.charAt(exp.indexOf("L")-1) == '÷')) ) {
            value = "x" + answer;
        }
        else {
            value = String.valueOf(answer);
        }

        return (value);
    }

    private double sin() {
        String no1;
        no1 = exp.substring(exp.indexOf("N") + 1, postVal("N") + 1);
        before = exp.substring(0, preVal("S"));
        after = exp.substring(postVal("N") + 1);
        double val1 = 0;
        double answer = 0;
        if (no1.isEmpty()) {
            answer = 0;
        }
        else {
            val1 = Double.parseDouble(no1);

            answer = Math.cos(val1);
        }

        return (answer);
    }

    private double cos() {
        String no1;
        no1 = exp.substring(exp.indexOf("S") + 1, postVal("S") + 1);
        before = exp.substring(0, preVal("C"));
        after = exp.substring(postVal("S") + 1);
        double val1 = 0;
        double answer = 0;
        if (no1.isEmpty()) {
            answer = 0;
        }
        else {
            val1 = Double.parseDouble(no1);

            answer = Math.cos(val1);
        }


        return (answer);
    }

    private double tan() {
        String no1;
        no1 = exp.substring(exp.indexOf("N") + 1, postVal("N") + 1);
        before = exp.substring(0, preVal("T"));
        after = exp.substring(postVal("N") + 1);
        double val1 = 0;
        double answer = 0;
        if (no1.isEmpty()) {
            answer = 0;
        }
        else {
            val1 = Double.parseDouble(no1);

            answer = Math.cos(val1);
        }

        return (answer);
    }

    public double xy () {

        String no1, no2;
        no1 = exp.substring(preVal("^"), exp.indexOf("^"));
        System.out.println(no1);
        no2 = exp.substring(exp.indexOf("^") + 1, postVal("^") + 1);
        System.out.println(no2);
        before = exp.substring(0, preVal("^"));
        after = exp.substring(postVal("^") + 1);
        double val1=0, val2=0;
        double answer = 0;
        val1 = Double.parseDouble(no1);
        val2 = Double.parseDouble(no2);
        answer = Math.pow(val1, val2);

        return (answer);
    }

    public double x3() {
        String no1;
        no1 = exp.substring(preVal("^"), exp.indexOf("^"));
        before = exp.substring(0, preVal("^"));
        after = exp.substring(postVal(")") + 1);
        double val1 = 0;
        double answer = 0;
        val1 = Double.parseDouble(no1);

        answer = Math.pow(val1, 3);

        return (answer);
    }

    public double x2() {
        String no1;
        no1 = exp.substring(preVal("^"), exp.indexOf("^"));
        before = exp.substring(0, preVal("^"));
        after = exp.substring(postVal(")") + 1);
        double val1 = 0;
        double answer = 0;
        val1 = Double.parseDouble(no1);

        answer = Math.pow(val1, 2);

        return (answer);
    }

    public String percent() {
        int percent, opin;
        int indexscan;
        String value= "";
        char scan = 0;
        opin = exp.indexOf("%");
        indexscan = opin;
        while (!((scan == '÷' || scan == '+' || scan == '-' || scan == 'x' || scan == '%') || indexscan == 0)) {

            indexscan--;
            scan = exp.charAt(indexscan);
            System.out.println(scan);
        }
        percent = indexscan;

        if (percent != 0) {
            percent++;
        }
        double dummy = Double.parseDouble(exp.substring(percent, opin));
        before = exp.substring(0, percent);
        after = exp.substring(opin+1);
        dummy = dummy/100;
        if (!(exp.contains("/") || exp.contains("*") || exp.contains("+") || exp.contains("-")) && exp.charAt(exp.length()-1) == '%'){
            value = before + dummy;
        }
        else if (!((exp.charAt(opin +1) == '÷' || exp.charAt(opin +1) == 'x' || exp.charAt(opin +1) == '+' || exp.charAt(opin +1) == '-')) && opin != exp.length()-1 ) {

            value = before + dummy + "x" + after;
        }
        else {
            value = before + dummy + after;
        }
        return (value);
    }

    public int preVal(String op) {
        int pre, opin;
        int indexscan;
        char scan = 0;
        opin = exp.indexOf(op);
        indexscan = opin;
        while (!((scan == '÷' || scan == '+' || scan == '-' || scan == 'x' || scan == 'S' || scan == 'A' || scan == '%') || indexscan == 0)) {

            indexscan--;
            scan = exp.charAt(indexscan);

        }
        pre = indexscan;
        if (indexscan != 0) {

            pre = indexscan + 1;
        }

        return (pre);
    }

    public int postVal(String op) {
        int post, opin;
        int indexscan;
        char scan = 0;
        opin = exp.indexOf(op);
        indexscan = opin;

        while (!((scan == '÷' || scan == '+' || scan == '-' || scan == 'S' || scan == 'A' || scan == 'x' || scan == '%') || indexscan == exp.length() - 1)) {

            indexscan++;
            scan = exp.charAt(indexscan);
        }

        post = indexscan;
        if (post != (exp.length() - 1)) {
            post--;
        };

        return (post);
    }

    public double pie () {

        String no1, no2;
        int in1 = preVal("π");
        no1 = exp.substring(preVal("π"), exp.indexOf("π"));
        System.out.println(no1);
        no2 = exp.substring(exp.indexOf("π") + 1, postVal("π") + 1);
        System.out.println(no2);
        before = exp.substring(0, preVal("π"));
        after = exp.substring(postVal("π") + 1);
        double val1=1, val2=1;
        double answer;

        if (!no1.isEmpty()) {
            val1 = Double.parseDouble(no1);
        }
        if (!no2.isEmpty()) {
            val2 = Double.parseDouble(no2);
        }

        answer = (val1 * 3.14159) * val2;

        return (answer);
    }

    public double e () {

        String no1, no2;
        int in1 = preVal("e");
        no1 = exp.substring(preVal("e"), exp.indexOf("e"));
        System.out.println(no1);
        no2 = exp.substring(exp.indexOf("e") + 1, postVal("e") + 1);
        System.out.println(no2);
        before = exp.substring(0, preVal("e"));
        after = exp.substring(postVal("e") + 1);
        double val1=1, val2=1;
        double answer;

        if (!no1.isEmpty()) {
            val1 = Double.parseDouble(no1);
        }
        if (!no2.isEmpty()) {
            val2 = Double.parseDouble(no2);
        }

        answer = (val1 * 2.718281828) * val2;

        return (answer);
    }

    public double maincalc(String op) {

        String no1, no2;
        int in1 = preVal(op);
        no1 = exp.substring(preVal(op), exp.indexOf(op));
        System.out.println(no1);
        no2 = exp.substring(exp.indexOf(op) + 1, postVal(op) + 1);
        System.out.println(no2);
        before = exp.substring(0, preVal(op));
        after = exp.substring(postVal(op) + 1);
        double val1, val2;
        double answer = 0;

        val1 = Double.parseDouble(no1);
        val2 = Double.parseDouble(no2);
        switch (op) {
            case "+":
                answer = val1 + val2;
                break;
            case "-":
                answer = val1 - val2;
                break;
            case "x":
                answer = val1 * val2;
                break;
            case "÷":
                answer = val1 / val2;
                break;
        }
        return (answer);
    }

    public String sort() {


        while (exp.contains("LOG")) {
            String middle = log();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("LN")) {
            String middle = ln();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("e")) {
            double middle = e();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("^(1÷")) {
            double middle = sqry();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("SIN")) {
            double middle = sin();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("COS")) {
            double middle = cos();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("TAN")) {
            double middle = tan();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("^(3)")) {
            double middle = x3();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("^(2)")) {
            double middle = x2();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("^")) {
            double middle = xy();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("π")) {
            double middle = pie();
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("√")) {
            exp = sqr();
        }

        while (exp.contains("!")) {
            exp = factorial();
        }

        while (exp.contains("%")) {
            exp = percent();
        }

        while (exp.contains("÷")) {

            double middle = maincalc("÷");
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("x")) {

            double middle = maincalc("x");
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while (exp.contains("+") && exp.contains("-")) {

            if (exp.indexOf("+") < exp.indexOf("-")) {

                double middle = maincalc("+");
                exp = this.before + middle + this.after;
                System.out.println(exp);
            } else {
                double middle = maincalc("-");
                exp = this.before + middle + this.after;
                System.out.println(exp);
            }
        }

        while (exp.contains("+")) {

            double middle = maincalc("+");
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }

        while ((!exp.startsWith("-")) && exp.contains("-") ) {

            double middle = maincalc("-");
            exp = this.before + middle + this.after;
            System.out.println(exp);
        }


        return (exp);
    }
}
