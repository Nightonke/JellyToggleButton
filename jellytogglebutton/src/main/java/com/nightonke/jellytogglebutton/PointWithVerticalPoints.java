package com.nightonke.jellytogglebutton;

import android.graphics.PointF;

/**
 * Created by Weiping on 2016/5/10.
 */
public class PointWithVerticalPoints {
    public float x;
    public float y;
    public PointF top = new PointF();
    public PointF bottom = new PointF();

    public void setX(float x){
        this.x = x;
        top.x = x;
        bottom.x = x;
    }

    public void scaleY(float offset){
        top.y -= offset;
        bottom.y += offset;
    }

    public void moveX(float offset){
        this.x += offset;
        top.x += offset;
        bottom.x +=offset;
    }
}
