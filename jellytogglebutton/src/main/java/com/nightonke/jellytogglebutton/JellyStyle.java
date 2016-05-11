package com.nightonke.jellytogglebutton;

/**
 * Created by Weiping on 2016/5/11.
 */
public abstract class JellyStyle {

    public abstract void changeShape(
            PointWithHorizontalPoints p1,
            PointWithVerticalPoints p2,
            PointWithHorizontalPoints p3,
            PointWithVerticalPoints p4,
            float stretchDistance,
            float bezierControlValue,
            float bezierScaleRatioValue,
            float thumbRadius,
            float process);

    public abstract void changeOffset(
            PointWithHorizontalPoints p1,
            PointWithVerticalPoints p2,
            PointWithHorizontalPoints p3,
            PointWithVerticalPoints p4,
            float totalLength,
            float process);

    public abstract float extractLength(
            float stretchDistance,
            float bezierControlValue,
            float bezierScaleRatioValue,
            float thumbRadius);

}
