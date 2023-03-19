package com.example.view_move;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DragView4 extends View {
    public DragView4(Context context) {
        super(context);
        ininView();
    }

    public DragView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ininView();
    }

    public DragView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
    }

    private int lastX;
    private int lastY;

    public void ininView(){
        setBackgroundColor(Color.RED);
    }

    //scrollTo方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int) event.getX();
        int y=(int) event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=(int )event.getX();
                lastY=(int)event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX=x-lastX;
                int offsetY=y-lastY;
                ((View)getParent()).scrollTo(-offsetX,-offsetY);
                break;
        }
        return true;
    }
}
