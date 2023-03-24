package com.example.billing;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submit;
    CheckBox chips, candies, cookies, cakes;
    TextView result;
    EditText numChips, numCookies, numCandies, numCakes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        submit = (Button) findViewById(R.id.submit);
        chips = (CheckBox) findViewById(R.id.chips);
        candies = (CheckBox) findViewById(R.id.candy);
        cookies = (CheckBox) findViewById(R.id.cookie);
        cakes = (CheckBox) findViewById(R.id.cakes);
        numCakes = (EditText) findViewById(R.id.numCakes);
        numCandies = (EditText) findViewById(R.id.numCandies);
        numChips = (EditText) findViewById(R.id.numChips);
        numCookies = (EditText) findViewById(R.id.numCookies);
        submit.setOnClickListener(new View.OnClickListener() {
            int total = 0;
            StringBuilder res = new StringBuilder();
            @Override
            public void onClick(View view) {
                if(chips.isChecked() && numChips.getText().toString() != null){
                    total += 10 * Integer.parseInt(numChips.getText().toString());
                }
                if(candies.isChecked() && numCandies.getText().toString() != null){
                    total += 5 * Integer.parseInt(numCandies.getText().toString());
                }
                if(cakes.isChecked() && numCakes.getText().toString() != null){
                    total += 50 * Integer.parseInt(numCakes.getText().toString());
                }
                if(cookies.isChecked() && numCookies.getText().toString() != null){
                    total += 10 * Integer.parseInt(numCookies.getText().toString());
                }
                res.append("Total: "+total+"Rs");
                result.setText(res.toString());
            }
        });
    }
}