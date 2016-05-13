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
    public void changeShape(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius, float process, State state) {
        if (state.equals(State.LEFT_TO_RIGHT)) {
            if (T0 <= process && process <= T1) {
                p2.moveX(stretchDistance * (process - T0) / (T1 - T0));
            } else if (T1 < process && process <= T2) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T1, state);
                p1.moveX(stretchDistance / 2 * (process - T1) / (T2 - T1));
                p3.moveX(stretchDistance / 2 * (process - T1) / (T2 - T1));
                p2.scaleY(bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T1) / (T2 - T1));
                p4.scaleY(bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T1) / (T2 - T1));
            } else if (T2 < process && process <= T3) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T2, state);
                p1.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
                p3.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
                p2.scaleY(-bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T2) / (T3 - T2));
                p4.scaleY(-bezierScaleRatioValue * bezierControlValue * thumbRadius * (process - T2) / (T3 - T2));
                p4.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
            } else if (T3 < process && process <= T4) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T3, state);
                p4.moveX(stretchDistance / 2 * (process - T3) / (T4 - T3));
            } else if (T4 < process && process <= T5) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T4, state);
                p4.moveX((float) (Math.sin(2 * Math.PI * (process - T4) / (T5 - T4)) * (2 / 10f * thumbRadius)));
            }
        } else if (state.equals(State.RIGHT_TO_LEFT)) {
            float rProcess = 1 - process;
            if (T0 <= rProcess && rProcess <= T1) {
                p4.moveX(-stretchDistance * (rProcess - T0) / (T1 - T0));
            } else if (T1 < rProcess && rProcess <= T2) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T1, state);
                p1.moveX(-stretchDistance / 2 * (rProcess - T1) / (T2 - T1));
                p3.moveX(-stretchDistance / 2 * (rProcess - T1) / (T2 - T1));
                p2.scaleY(bezierScaleRatioValue * bezierControlValue * thumbRadius * (rProcess - T1) / (T2 - T1));
                p4.scaleY(bezierScaleRatioValue * bezierControlValue * thumbRadius * (rProcess - T1) / (T2 - T1));
            } else if (T2 < rProcess && rProcess <= T3) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T2, state);
                p1.moveX(-stretchDistance / 2 * (rProcess - T2) / (T3 - T2));
                p3.moveX(-stretchDistance / 2 * (rProcess - T2) / (T3 - T2));
                p2.scaleY(-bezierScaleRatioValue * bezierControlValue * thumbRadius * (rProcess - T2) / (T3 - T2));
                p4.scaleY(-bezierScaleRatioValue * bezierControlValue * thumbRadius * (rProcess - T2) / (T3 - T2));
                p2.moveX(-stretchDistance / 2 * (rProcess - T2) / (T3 - T2));
            } else if (T3 < rProcess && rProcess <= T4) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T3, state);
                p2.moveX(-stretchDistance / 2 * (rProcess - T3) / (T4 - T3));
            } else if (T4 < rProcess && rProcess <= T5) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T4, state);
                p2.moveX(-(float) (Math.sin(2 * Math.PI * (rProcess - T4) / (T5 - T4)) * (2 / 10f * thumbRadius)));
            }
        } else if (state.equals(State.LEFT)) {

        } else if (state.equals(State.RIGHT)) {
            p1.moveX(extractLength(stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius));
            p2.moveX(extractLength(stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius));
            p3.moveX(extractLength(stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius));
            p4.moveX(extractLength(stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius));
        }
    }

    @Override
    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float extractLength, float process, State state) {
        if (state.equals(State.LEFT_TO_RIGHT)) {
            float offset = totalLength * (process - T1) / (T5 - T1);
            offset = offset > 0 ? offset : 0;
            p1.moveX(offset);
            p2.moveX(offset);
            p3.moveX(offset);
            p4.moveX(offset);
        } else if (state.equals(State.RIGHT_TO_LEFT)) {
            float rProcess = 1 - process;
            float offset = totalLength * (rProcess - T1) / (T5 - T1);
            offset = offset > 0 ? offset : 0;
            p1.moveX(totalLength + extractLength - offset);
            p2.moveX(totalLength + extractLength - offset);
            p3.moveX(totalLength + extractLength - offset);
            p4.moveX(totalLength + extractLength - offset);
        } else if (state.equals(State.LEFT)) {
            p1.moveX(0);
            p2.moveX(0);
            p3.moveX(0);
            p4.moveX(0);
        } else if (state.equals(State.RIGHT)) {
            p1.moveX(totalLength);
            p2.moveX(totalLength);
            p3.moveX(totalLength);
            p4.moveX(totalLength);
        }
    }

    @Override
    public float extractLength(float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius) {
        return stretchDistance;
    }
}
