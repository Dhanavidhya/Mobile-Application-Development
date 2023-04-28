package com.example.multithreading;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends Activity {
    private TextView tvOutput;
    private static final int t1 = 1;
    private static final int t2 = 2;
    private static final int t3 = 3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutput = (TextView) findViewById(R.id.textView1);
    }
    public void fetchData(View v) {
        tvOutput.setText("Main thread");
        thread1.start();
        thread2.start();
        thread3.start();
    }
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(t1);
            }
        }
    });
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(t2);
            }
        }
    });
    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(t3);
            }
        }
    });
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.what == t1) {
                tvOutput.append("\nIn thread 1");
            }
            if(msg.what == t2) {
                tvOutput.append("\nIn thread 2");
            }
            if(msg.what == t3) {
                tvOutput.append("\nIn thread 3");
            }
        }
    };
}
