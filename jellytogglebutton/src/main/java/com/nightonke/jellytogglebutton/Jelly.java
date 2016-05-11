package com.nightonke.jellytogglebutton;

/**
 * Created by Weiping on 2016/5/11.
 */
public enum Jelly {

    PASSIVE_DAMPING_TAIL(PassiveDampingTail.class);

    public Class c;

    Jelly(Class c) {
        this.c = c;
    }

    public void changeShape(
            PointWithHorizontalPoints p1,
            PointWithVerticalPoints p2,
            PointWithHorizontalPoints p3,
            PointWithVerticalPoints p4,
            float stretchDistance,
            float bezierControlValue,
            float bezierScaleRatioValue,
            float thumbRadius,
            float process) {
        try {
            ((JellyStyle) c.getConstructor().newInstance()).changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, process);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Jelly style init error.");
        }
    }

    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float process) {
        try {
            ((JellyStyle) c.getConstructor().newInstance()).changeOffset(p1, p2, p3, p4, totalLength, process);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Jelly style init error.");
        }
    }

    public float extraceLength(float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius) {
        try {
            return ((JellyStyle) c.getConstructor().newInstance()).extractLength(stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Jelly style init error.");
        }
    }
}
