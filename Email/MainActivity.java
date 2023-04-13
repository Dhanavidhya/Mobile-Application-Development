package com.example.email;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to;
    EditText subject;
    EditText msg;
    Button snd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to=findViewById(R.id.tofield);
        subject=findViewById(R.id.subfield);
        msg=findViewById(R.id.msgfield);
        snd=findViewById(R.id.snd);

        snd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tolst=to.getText().toString();
                String[] toarr=tolst.split(",");

                String subj=subject.getText().toString();
                String msgg=msg.getText().toString();

                Intent i=new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,toarr);
                i.putExtra(Intent.EXTRA_SUBJECT,subj);
                i.putExtra(Intent.EXTRA_TEXT,msgg);

                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i,"Choose an E-mail Provider"));
            }
        });

    }
}