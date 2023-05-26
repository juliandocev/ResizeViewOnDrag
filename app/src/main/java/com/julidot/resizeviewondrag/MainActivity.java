package com.julidot.resizeviewondrag;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.julidot.resizeviewondrag.touchlisteners.BottomLeftAnchorTouchListener;
import com.julidot.resizeviewondrag.touchlisteners.BottomRightAnchorTouchListener;
import com.julidot.resizeviewondrag.touchlisteners.TopLeftAnchorTouchListener;
import com.julidot.resizeviewondrag.touchlisteners.TopRightAnchorTouchListener;

public class MainActivity extends AppCompatActivity {

    RelativeLayout viewToResize;
    private TextView lblStatus;
    private ImageView topLeftAnchor, topRightAnchor, bottomLeftAnchor, bottomRightAnchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewToResize = findViewById(R.id.customView);
        lblStatus = findViewById(R.id.status);
        topLeftAnchor = findViewById(R.id.topLeftAnchor);
        topRightAnchor = findViewById(R.id.topRightAnchor);
        bottomLeftAnchor = findViewById(R.id.bottomLeftAnchor);
        bottomRightAnchor = findViewById(R.id.bottomRightAnchor);

        // Listeners

        topLeftAnchor.setOnTouchListener(new TopLeftAnchorTouchListener(viewToResize,lblStatus));
        topRightAnchor.setOnTouchListener(new TopRightAnchorTouchListener(viewToResize,lblStatus));
        bottomLeftAnchor.setOnTouchListener(new BottomLeftAnchorTouchListener(viewToResize,lblStatus));
        bottomRightAnchor.setOnTouchListener(new BottomRightAnchorTouchListener(viewToResize,lblStatus));


    }


}