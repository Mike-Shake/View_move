package com.example.view_move;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class DragView3 extends View {
    //构造参数
    public DragView3(Context context) {
        super(context);
        ininView();
    }

    public DragView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ininView();
    }

    public DragView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
    }

    private int lastX;
    private int lastY;

    //涂色
    private void ininView() {
        setBackgroundColor(Color.BLUE);
    }

    //LayoutParams方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触点坐标
                lastX = (int) event.getX();
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                break;
        }
        return true;
    }
}
