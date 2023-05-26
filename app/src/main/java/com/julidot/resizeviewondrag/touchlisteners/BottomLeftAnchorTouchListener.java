package com.julidot.resizeviewondrag.touchlisteners;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BottomLeftAnchorTouchListener implements View.OnTouchListener {
    private int _xDelta;
    private int _yDelta;
    private int actualWidth;
    private int actualHeight;
    private View viewToResize;
    private TextView lblStatus;

    public BottomLeftAnchorTouchListener(View viewToResize, TextView lblStatus/*, Anchor.ResizeMode resizeMode*/) {
        this.viewToResize = viewToResize;
        this.lblStatus = lblStatus;
    }

    private int initialHeight;
    private int initialWidth;
    private int initialX;
    private int initialY;


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) viewToResize.getLayoutParams();




        Log.d("Anchor", "Updating X & Y");

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                lblStatus.setText("Action down");
                // Capture initial conditions of the view to resize.
                initialHeight = viewToResize.getHeight();
                initialWidth = viewToResize.getWidth();
                // Capture initial touch point.
                initialX = X;
                initialY = Y;


                break;

            case MotionEvent.ACTION_UP:
                lblStatus.setText("Drag finished x: "+actualWidth+" y:"+actualHeight);
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                break;

            case MotionEvent.ACTION_POINTER_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                lblStatus.setText("Moving around");
                // Compute how far we have moved in the X/Y directions.
                _xDelta = X - initialX;
                _yDelta = Y - initialY;
                // Adjust the size of the targeted view. Note that we don't have to position
                // the resize handle since it will be positioned correctly due to the layout.
                actualWidth = lp.width = initialWidth - _xDelta;
                actualHeight = lp.height = initialHeight + _yDelta;
                lblStatus.setText("Moving around x: "+actualWidth+" y: "+actualHeight+"");
                viewToResize.setLayoutParams(lp);

                break;

        }

        return true;
    }
}
