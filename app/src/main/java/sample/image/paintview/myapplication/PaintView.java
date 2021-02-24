package sample.image.paintview.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;



public class PaintView extends View {

    Paint paintBrush = new Paint();
    Path path = new Path();

    public PaintView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        paintBrush.setAntiAlias(true);
        paintBrush.setColor(Color.RED);
        paintBrush.setStyle(Paint.Style.STROKE);
        paintBrush.setStrokeJoin(Paint.Join.ROUND);
        paintBrush.setStrokeWidth(8f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                path.moveTo(pointX, pointY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);
               break;
            default:
        }
        postInvalidate();
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paintBrush);
    }
}
