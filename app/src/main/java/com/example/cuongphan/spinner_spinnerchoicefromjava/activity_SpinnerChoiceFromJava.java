package com.example.cuongphan.spinner_spinnerchoicefromjava;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_SpinnerChoiceFromJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__spinner_choice_from_java);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] entries = {"Red", "Green", "Blue", "Yellow"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entries);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new SpinnerInfo());
    }

    private void changeColor(int color){
        TextView textView = (TextView)findViewById(R.id.tv);
        textView.setBackgroundColor(color);
    }

    private class SpinnerInfo implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> spinner, View view, int position, long id) {
            String selection = spinner.getItemAtPosition(position).toString();
            switch (selection){
                case "Red":
                    changeColor(Color.RED);
                    break;
                case "Green":
                    changeColor(Color.GREEN);
                    break;
                case "Blue":
                    changeColor(Color.BLUE);
                    break;
                default:
                    changeColor(Color.YELLOW);
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
