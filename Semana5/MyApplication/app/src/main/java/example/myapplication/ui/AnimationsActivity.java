package example.myapplication.ui;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

import example.myapplication.R;

/**
 * Created by david on 11/2/16.
 */

public class AnimationsActivity extends BaseActivity implements View.OnTouchListener {


    private int mImageOffset;

    private ImageView mImageView;

    private RelativeLayout mWrapper;

    private View mCorner1;
    private View mCorner2;
    private View mCorner3;
    private View mCorner4;

    private static final String IMAGE_TAG = "image_tag";

    public static Intent makeIntent(Context context) {
        return new Intent(context, AnimationsActivity.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mImageView = (ImageView) findViewById(R.id.android_image);
        mImageView.setTag(IMAGE_TAG);
        mImageView.setOnLongClickListener(new ImageLongClickListener());
        mImageView.setOnClickListener(new ImageClickListener());
        mImageOffset = getResources().getDimensionPixelSize(R.dimen.image_size) / 2;

        mWrapper = (RelativeLayout) findViewById(R.id.wrapper);
        mWrapper.setOnDragListener(new ViewOnDragListener());


        mCorner1 = findViewById(R.id.corner_1);
        mCorner2 = findViewById(R.id.corner_2);
        mCorner3 = findViewById(R.id.corner_3);
        mCorner4 = findViewById(R.id.corner_4);


        mCorner1.setOnTouchListener(this);
        mCorner2.setOnTouchListener(this);
        mCorner3.setOnTouchListener(this);
        mCorner4.setOnTouchListener(this);


    }


    private class ImageLongClickListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View view) {

            ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

            String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
            ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return false;
        }
    }

    private class ImageClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int currentPosition = 0;

            if (mImageView.getX() == mCorner1.getX() && mImageView.getY() == mCorner1.getY()) {
                currentPosition = 1;
            } else if (mImageView.getX() == mCorner2.getX() && mImageView.getY() == mCorner2.getY()) {
                currentPosition = 2;
            } else if (mImageView.getX() == mCorner3.getX() && mImageView.getY() == mCorner3.getY()) {
                currentPosition = 3;
            } else if (mImageView.getX() == mCorner4.getX() && mImageView.getY() == mCorner4.getY()) {
                currentPosition = 4;
            }

            int newPosition;

            do {
                newPosition = new Random().nextInt(4) + 1;
            } while (newPosition == currentPosition);

            switch (newPosition) {
                case 1:
                    mImageView.animate().x(mCorner1.getX()).y(mCorner1.getY());
                    break;
                case 2:
                    mImageView.animate().x(mCorner2.getX()).y(mCorner2.getY());
                    break;
                case 3:
                    mImageView.animate().x(mCorner3.getX()).y(mCorner3.getY());
                    break;
                case 4:
                    mImageView.animate().x(mCorner4.getX()).y(mCorner4.getY());
                    break;
            }
        }
    }

    private class ViewOnDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            if (event.getAction() == DragEvent.ACTION_DROP) {
                View view = (View) event.getLocalState();

                int xLimit = (mWrapper.getWidth() / 2) - mImageOffset;
                int yLimit = (mWrapper.getHeight() / 2) - mImageOffset;

                float dropX = event.getX() - mImageOffset;
                float dropY = event.getY() - mImageOffset;

                view.setTranslationX(dropX);
                view.setTranslationY(dropY);
                view.setVisibility(View.VISIBLE);

                if (dropX < xLimit && dropY < yLimit) {
                    // Top left corner
                    view.animate().x(mCorner1.getX()).y(mCorner1.getY());
                } else if (dropX > xLimit && dropY < yLimit) {
                    // Top right corner
                    view.animate().x(mCorner2.getX()).y(mCorner2.getY());
                } else if (dropX < xLimit && dropY > yLimit) {
                    // Bottom left corner
                    view.animate().x(mCorner3.getX()).y(mCorner3.getY());
                } else if (dropX > xLimit && dropY > yLimit) {
                    // Bottom right corner
                    view.animate().x(mCorner4.getX()).y(mCorner4.getY());
                }
            }
            return true;
        }
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.animations_activity;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mImageView.animate()
                        .translationX(v.getX())
                        .translationY(v.getY());
                break;
        }
        return false;
    }
}
