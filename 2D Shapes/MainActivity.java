package com.example.a2ddiagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DemoView demoview;
    Paint paint=new Paint();
    Path path = new Path();
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

            paint.setAntiAlias(false);
            paint.setColor(Color.RED);
            canvas.drawRect(300, 100, 1000, 500, paint);

            paint.setAntiAlias(false);
            paint.setColor(Color.BLUE);
            drawTriangle(canvas, paint, 300, 300, 400);

            paint.setAntiAlias(false);
            paint.setColor(Color.GREEN);
            canvas.drawRect(100, 500, 500, 1000, paint);

            paint.setAntiAlias(false);
            paint.setColor(Color.YELLOW);
            canvas.drawRect(500, 500, 1000, 1000, paint);

        }
        public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
            int halfWidth = width / 2;

            path.moveTo(x, y - halfWidth); // Top
            path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
            path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
            path.lineTo(x, y - halfWidth); // Back to Top
            path.close();

            canvas.drawPath(path, paint);
        }
    }
}