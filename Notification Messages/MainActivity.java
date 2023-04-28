package com.example.notification;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button notifyBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notifyBtn = (Button) findViewById(R.id.notify_btn);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
                builder.setContentTitle("Dhanavidhya C");
                builder.setContentText("Hello, Notification from Dhanavidhya");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });
    }
}
