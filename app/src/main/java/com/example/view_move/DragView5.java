package com.example.view_move;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class DragView5 extends View {
    public DragView5(Context context) {
        super(context);
        ininView(context);
    }

    public DragView5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ininView(context);
    }

    public DragView5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView(context);
    }

    private int lastX;
    private int lastY;
    private Scroller mscroller;

    private void ininView(Context context) {
        setBackgroundColor(Color.BLUE);
        // 初始化Scroller
        mscroller = new Scroller(context);
    }
    @Override
    public void computeScroll() {
        super.computeScroll();
        //判断Scroller是否执行完毕
        if (mscroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(
                    mscroller.getCurrX(),
                    mscroller.getCurrY());
            //通过重绘不断来调用computeScroll
            invalidate();
        }
    }

    //Scroller.startScroll方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getX();
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View) getParent()).scrollTo(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                //手指离开时，执行滑动过程
                View viewgroup = (View) getParent();
                mscroller.startScroll(viewgroup.getScrollX(),
                        viewgroup.getScrollY(),
                        -viewgroup.getScrollX(),
                        -viewgroup.getScrollY());
                invalidate();
                break;
        }
        return true;
    }
}
