package com.solidict.temp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
        paint = new Paint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

    }

    Paint paint = null;



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float radius;

        if (width > height) {
            radius = height / 4;
        } else {
            radius = width / 4;
        }

//        Path path = new Path();
//        path.addCircle(width / 2,
//                height / 2, radius,
//                Path.Direction.CW);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);

        float center_x, center_y;
        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);

        center_x = width / 2;
        center_y = height / 2;
//
//        oval.set(+(center_x - radius),
//                center_y - radius,
//                +(center_x + radius),
//                center_y + radius);

        oval.set(-150,
                100,
                150,
                800);

        canvas.drawArc(oval, 270, 180, false, paint);
    }

}