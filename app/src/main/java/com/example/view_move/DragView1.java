package com.example.view_move;


import static android.content.ContentValues.TAG;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DragView1 extends View {

    //构造参数
    public DragView1(Context context) {
        super(context);
        ininView();
    }

    public DragView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ininView();
    }

    public DragView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
    }

    private int lastX;
    private int lastY;

    private final String TAG = "drawview1";
    //涂色
    private void ininView() {
        //给View设置背景颜色，便于观察
        setBackgroundColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        Log.d(TAG, "onTouchEvent: x=" + x);

        int y = (int) event.getY();
        Log.d(TAG, "onTouchEvent:  y=" + y);


        //视图坐标方式
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //当前left、top、bottom的基础上加上偏移量
                //将计算出来的偏移量递给layout()，完成view的移动
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
