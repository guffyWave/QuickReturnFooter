package com.gufran.quickreturnfloaterapp;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Description ...
 *
 * @author Gufran Khurshid
 * @version 1.0
 * @since 5/15/17
 */

public class QuickReturnFloaterBehavior extends CoordinatorLayout.Behavior<View> {



    private int distance;

    public QuickReturnFloaterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (dy > 0 && distance < 0 || dy < 0 && distance > 0) {
            // child.animate().cancel();
            distance = 0;
        }
        distance += dy;
        final int height = child.getHeight() > 0 ? (child.getHeight()) : 60/*update this accordingly*/;
        if (distance > height && child.isShown()) {
            hide(child);
        } else if (distance < 0 && !child.isShown()) {
            show(child);
        }
    }

    private void hide(final View view) {
        //view.setVisibility(View.GONE);// use animate.translateY(height); instead
        if (view != null)
            view.animate()
                    .translationY(1 * view.getHeight())
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .setDuration(200)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            view.setVisibility(View.GONE);
                        }
                    }).start();
    }

    private void show(final View view) {
        //  view.setVisibility(View.VISIBLE);// use animate.translateY(-height); instead
        if (view != null)
            view.animate()
                    .translationY(0)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .setDuration(200)
                    .withStartAction(new Runnable() {
                        @Override
                        public void run() {
                            view.setVisibility(View.VISIBLE);
                        }
                    }).start();

    }


}
