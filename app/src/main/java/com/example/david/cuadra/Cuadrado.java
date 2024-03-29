package com.example.david.cuadra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class Cuadrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vista vista=new Vista(this);
        setContentView(vista);

    }
    class Vista extends View{
        float x=50;
        float y=50;
        String accion="accion";
        Path path=new Path();

        public Vista (Context context){
            super(context);
        }
        public void onDraw(Canvas canvas){
            Paint paint=new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setColor(Color.MAGENTA);

            int ancho=canvas.getWidth();
            //canvas.drawRect(10,70,ancho-10,20,paint);
            if(accion=="down")
                path.moveTo(x,y);
            if(accion=="move")
                path.lineTo(x, y);
            canvas.drawPath(path, paint);

        }
        public boolean onTouchEvent(MotionEvent e){
            x=e.getX();
            y=e.getY();

            if(e.getAction()==MotionEvent.ACTION_DOWN)
                accion="down";
            if(e.getAction()==MotionEvent.ACTION_MOVE)
                accion="move";
            invalidate();
            return true;

        }

    }

}
