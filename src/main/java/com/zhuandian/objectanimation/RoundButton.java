package com.zhuandian.objectanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Dimension;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * desc：
 * author：xiedong
 * date：2017/11/29.
 */
public class RoundButton extends View {
    private int menuSize;

    public RoundButton(Context context) {
        super(context, null);

    }

    public RoundButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundButton);
        menuSize = (int)typedArray.getDimension(R.styleable.RoundButton_menuSize, 60.0f);
//        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) this.getLayoutParams();
//        layoutParams.width =menuSize;
//        layoutParams.height=menuSize;
//        this.setLayoutParams(layoutParams);
        this.setBackgroundResource(R.mipmap.ic_create_menu);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator rotationX = ObjectAnimator.ofFloat(view,"scaleX",1.0f,0.8f,1.0f).setDuration(300);
                ObjectAnimator rotationY = ObjectAnimator.ofFloat(view,"scaleY",1.0f,1.2f,1.0f).setDuration(300);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(rotationX).with(rotationY);
                animatorSet.start();
            }
        });


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = menuSize;
        int width = menuSize;
        setMeasuredDimension(300,300);
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        final int heightSpecSize = MeasureSpec.getMode(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width,height);
        }else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width,heightSpecSize);
        }else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize,height);
        }
    }

//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//        layout(100,100,100,0);
//    }
}
