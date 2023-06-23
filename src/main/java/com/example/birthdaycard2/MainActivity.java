package com.example.birthdaycard2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView numberOfCoffee;
    private TextView bill;
    private Button minus;
    private Button plus;
    private CheckBox chapati;
    private CheckBox mandazi;
    private CheckBox bread;
    public String num;
    public int toNum;
    public int price = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfCoffee = findViewById(R.id.numberOfCoffee);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        bill = findViewById(R.id.bill);
        chapati = findViewById(R.id.chapati);
        mandazi = findViewById(R.id.mandazi);
        bread = findViewById(R.id.bread);
    }

    public void btnMinus(View view) {
        num = String.valueOf(numberOfCoffee.getText());
        toNum = Integer.parseInt(num);
        if (toNum > 0) {
            toNum = toNum - 1;
            String toText = String.valueOf(toNum);
            numberOfCoffee.setText(toText);
            bill.setText("Your Order is :\n" + numberOfCoffee.getText() + "cups of coffee \nTotal cost = " + (toNum * price));
            Toast.makeText(getApplicationContext(), numberOfCoffee.getText() + " Cups" + "\ntotal price=" + (toNum * price), Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(getApplicationContext(), "Can not order less than zero coffees ", Toast.LENGTH_LONG).show();

    }

    public void btnPlus(View view) {
        if (toNum < 20) {

            num = String.valueOf(numberOfCoffee.getText());
            toNum = Integer.parseInt(num);
            toNum = toNum + 1;
            String toText = String.valueOf(toNum);
            numberOfCoffee.setText(toText);
            bill.setText("Your Order is :\n" + numberOfCoffee.getText() + "cups of coffee \nTotal cost = " + (toNum * price));
            Toast.makeText(getApplicationContext(), numberOfCoffee.getText() + " Cups" + "\ntotal price=" + (toNum * price), Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(getApplicationContext(), "Can not order more than twenty cups ", Toast.LENGTH_LONG).show();
    }

    public void btnOrder(View view) {
        List<String> selectedToppings = new ArrayList<>();
        int chapatiprice = 20;
        int mandaziPrice = 10;
        int breadPrice = 60;
        int toppinsTotalAmmount = 0;
        int coffeeAmmount = toNum * price;
        selectedToppings.clear();
        if (chapati.isChecked()) {
            selectedToppings.add("Chapati     20");
            toppinsTotalAmmount = toppinsTotalAmmount + chapatiprice;
        }
        if (mandazi.isChecked()) {
            selectedToppings.add("Mandazi     10");
            toppinsTotalAmmount = toppinsTotalAmmount + mandaziPrice;
        }
        if (bread.isChecked()) {
            selectedToppings.add("Bread       60");
            toppinsTotalAmmount = toppinsTotalAmmount + breadPrice;
        }
        StringBuilder message = new StringBuilder();
        for (String x : selectedToppings) {

            message.append(x).append("\n");
        }
        bill.setText("Your Order is :\nItems      Price\n" + numberOfCoffee.getText() + "cups     " + coffeeAmmount + "\n" + message.toString() + "\nTotal Price " + (coffeeAmmount + toppinsTotalAmmount));
    }
}
