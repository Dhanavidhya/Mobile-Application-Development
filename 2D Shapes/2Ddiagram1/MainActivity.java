package com.example.a2ddiagram1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    DemoView demoview;
    Paint paint=new Paint();
    Path path=new Path();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demoview=new DemoView(this);
        setContentView(demoview);
    }
    private class DemoView extends View{
        public DemoView(Context context){
            super(context);
        }
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
//circle border
            paint.setAntiAlias(false);
            paint.setColor(Color.BLACK);
            canvas.drawCircle(500,700,410,paint);
//circle
            paint.setAntiAlias(false);
            paint.setColor(Color.YELLOW);
            canvas.drawCircle(500,700,400,paint);
//left eye
            paint.setAntiAlias(false);

            paint.setColor(Color.BLACK);
            canvas.drawOval(300,450,400,650,paint);
//right eye
            paint.setAntiAlias(false);
            paint.setColor(Color.BLACK);
            canvas.drawOval(600,450,700,650,paint);
//smile
            paint.setColor(Color.RED);
            canvas.drawArc(300,700,700,900,180,-180,false,paint);
        }
    }
}