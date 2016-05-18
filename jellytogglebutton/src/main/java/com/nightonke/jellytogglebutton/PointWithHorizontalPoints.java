package com.nightonke.jellytogglebutton;

import android.graphics.PointF;

/**
 * Created by Weiping on 2016/5/10.
 */
public class PointWithHorizontalPoints {
    public float x;
    public float y;
    public PointF left = new PointF();
    public PointF right = new PointF();

    public void setY(float y){
        this.y = y;
        left.y = y;
        right.y = y;
    }

    public void scaleX(float offset){
        left.x -= offset;
        right.x += offset;
    }

    public void moveX(float offset){
        this.x += offset;
        left.x += offset;
        right.x += offset;
    }

    public void moveY(float offset) {
        this.y += offset;
        left.y += offset;
        right.y += offset;
    }
}
