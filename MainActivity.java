package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textView;
    EditText editTextNumber;
    ImageButton imageButton_kilograms;
    ImageButton imageButton_celsius;
    ImageButton imageButton_snail_distance;


    
    // Unit Variables
    float fahrenheit;
    float kelvin;
    float centimetre;
    float foot;
    float inch;
    float gram;
    float ounce;
    float pound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner_units);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        textView = (TextView) findViewById(R.id.textView);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);

        // Image Button Variables
        imageButton_celsius = findViewById(R.id.imageButton_celsius);
        imageButton_kilograms = findViewById(R.id.imageButton_kilograms);
        imageButton_snail_distance = findViewById(R.id.imageButton_snail_distance);

        // Distance
        imageButton_snail_distance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Spinner spinner = (Spinner) findViewById(R.id.spinner_units);
                String text = spinner.getSelectedItem().toString();
                if (text.contentEquals("Metre")) {
                    String value = editTextNumber.getText().toString();
                    float d = Float.parseFloat(value);
                    // Centimetre
                    float c;
                    c = d * 100;
                    // Foot
                    float f;
                    f = (float) (d * 3.28);
                    // Inch
                    float i;
                    i = (float) (d * 39.37);
                    // Text View message of calculated results
                    textView.setText(toString().format("%.2f", c) + " Centimetre" + "\n" +  toString().format("%.2f", f) + " Foot" + "\n" + toString().format("%.2f", i) + "Inch");
                }
                else
                {
                    // Toast message to present the error
                    Toast.makeText(MainActivity.this, "Press the correct unit conversion type", Toast.LENGTH_LONG).show();
                }
            }
        });

        imageButton_celsius.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Spinner spinner = (Spinner) findViewById(R.id.spinner_units);
                String text = spinner.getSelectedItem().toString();
                if (text.contentEquals("Celsius")) {
                    String value = editTextNumber.getText().toString();
                    float c = Float.parseFloat(value);
                    // Kelvin
                    float k;
                    k = (float) (c + 273.15);
                    // Fahrenheit
                    float f;
                    f = (c*9/5) +32;
                    // Text View message of calculated results
                    textView.setText(toString().format("%.2f", k) + " Kelvin" + "\n" +  toString().format("%.2f", f) + " Fahrenheit");
                }
                else
                {
                    // Toast message to present the error
                    Toast.makeText(MainActivity.this, "Press the correct unit conversion type", Toast.LENGTH_LONG).show();
                }
            }
        });

        imageButton_kilograms.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               Spinner spinner = (Spinner) findViewById(R.id.spinner_units);
               String text = spinner.getSelectedItem().toString();
               if (text.contentEquals("Kilograms")) {
                   String value = editTextNumber.getText().toString();
                   float k = Float.parseFloat(value);
                   // Grams
                   float g;
                   g = (float) (k * 1000);
                   // Ounces
                   float o;
                   o = (float) (k * 35.274);
                   // Pounds
                   float p;
                   p = (float) (k * 2.20462);
                   // Text View message of calculated results
                   textView.setText(toString().format("%.2f", g) + " Grams" + "\n" +  toString().format("%.2f", o) + " Ounce (oz)" + "\n" + toString().format("%.2f", p) + " Pounds (lb)");
               }
               else
               {
                   // Toast message to present the error
                   Toast.makeText(MainActivity.this, "Press the correct unit conversion type", Toast.LENGTH_LONG).show();
               }
           }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}





