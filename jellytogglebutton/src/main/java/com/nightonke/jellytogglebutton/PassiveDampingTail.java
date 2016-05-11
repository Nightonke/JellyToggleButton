package com.nightonke.jellytogglebutton;

/**
 * Created by Weiping on 2016/5/11.
 */
public class PassiveDampingTail extends JellyStyle {

    private static final float T0 = 0.0f;
    private static final float T1 = 0.2f;
    private static final float T2 = 0.5f;
    private static final float T3 = 0.8f;
    private static final float T4 = 0.9f;
    private static final float T5 = 1.0f;


    @Override
    public void changeShape(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius, float process) {
        if (T0 <= process && process <= T1) {
            p2.setX(2 * thumbRadius + stretchDistance * (process - T0) / (T1 - T0));
        } else if (T1 < process && process <= T2) {
            changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T1);
            p1.moveX(stretchDistance / 2 * (process - T1) / (T2 - T1));
            p3.moveX(stretchDistance / 2 * (process - T1) / (T2 - T1));
            p2.scaleY(bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T1) / (T2 - T1));
            p4.scaleY(bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T1) / (T2 - T1));
        } else if (T2 < process && process <= T3) {
            changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T2);
            p1.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
            p3.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
            p2.scaleY(-bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T2) / (T3 - T2));
            p4.scaleY(-bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T2) / (T3 - T2));
            p4.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
        } else if (T3 < process && process <= T4) {
            changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T3);
            p4.moveX(stretchDistance / 2 * (process - T3) / (T4 - T3));
        } else if (T4 < process && process <= T5) {
            changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T4);
            p4.moveX((float) (Math.sin(Math.PI * (process - T4) / (T5 - T4)) * (2 / 10f * thumbRadius)));
        }
    }

    @Override
    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float process) {
        float offset = totalLength * (process - T1) / (T5 - T1);
        offset = offset > 0 ? offset : 0;
        p1.moveX(offset);
        p2.moveX(offset);
        p3.moveX(offset);
        p4.moveX(offset);
    }

    @Override
    public float extractLength(float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius) {
        return stretchDistance;
    }
}
