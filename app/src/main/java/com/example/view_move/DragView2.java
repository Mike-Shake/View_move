package com.example.view_move;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

public class DragView2 extends View {
    //构造参数
    public DragView2(Context context) {
        super(context);
        ininView();
    }

    public DragView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ininView();

    }

    public DragView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();

    }


    private int lastx;
    private int lasty;

    //涂色
    public void ininView(){
        setBackgroundColor(Color.BLACK);
    }


    //获取绝对坐标方式
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX=(int) event.getRawX();
        int rawY=(int) event.getRawY();
        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:
                //记录触摸点坐标
                lastx=rawX;
                lasty=rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX=rawX-lastx;
                int offsetY=rawY-lasty;
                //在当前的left、top、right、bottom的基础上加上偏移量
                layout(getLeft()+offsetX,
                        getTop()+offsetY,
                        getRight()+offsetX,
                        getBottom()+offsetY);
                //重新设置初始坐标
                lastx=rawX;
                lasty=rawY;
                break;
        }
        return true;
    }
}
