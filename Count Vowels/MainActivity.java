package com.example.count_vowels;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
public class MainActivity extends Activity implements OnClickListener
{
    EditText content;
    Button count;
    String file_name;

    String strContents;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content=(EditText)findViewById(R.id.editText1);
        count=(Button)findViewById(R.id.button1);
        count.setOnClickListener(this);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.button1)
        {
            FileOutputStream fos;
            try {
                strContents = content.getText().toString();

            } catch (Exception e) {}
        }
        if(v.getId()==R.id.button1) {
            int count = 0;
            for (int i = 0; i < strContents.length(); i++) {

                switch (strContents.charAt(i)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        count++;
                        break;
                }
            }
            Toast.makeText(getApplicationContext(), "Total Vovels Are : " + count, Toast.LENGTH_LONG).show();
        }
    }}