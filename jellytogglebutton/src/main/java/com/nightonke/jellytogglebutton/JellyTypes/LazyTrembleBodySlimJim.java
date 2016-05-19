package com.nightonke.jellytogglebutton.JellyTypes;

import com.nightonke.jellytogglebutton.EaseTypes.EaseType;
import com.nightonke.jellytogglebutton.PointWithHorizontalPoints;
import com.nightonke.jellytogglebutton.PointWithVerticalPoints;
import com.nightonke.jellytogglebutton.State;
import com.nightonke.jellytogglebutton.Utils;

/**
 * Created by Weiping on 2016/5/11.
 */

public class LazyTrembleBodySlimJim extends JellyStyle {

    private static final float TOTAL_LENGTH = (float) (7 * Math.PI / 4);
    private static final float B = 0.4f;
    private static final float C = 2.0f;
    private static final float D = 0.0f;

    private static final float T0 = 0.000f;
    private static final float T1 = 0.135f;
    private static final float T2 = 0.339f;
    private static final float T3 = 0.543f;
    private static final float T4 = 0.612f;
    private static final float T5 = 1.000f;

    private static final float VIBRATION_STRETCH_RATIO = 3f;

    @Override
    public void changeShape(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius, float process, State state) {
        if (state.equals(State.LEFT_TO_RIGHT)) {
            if (T0 <= process && process <= T1) {
                p2.moveX(stretchDistance * (process - T0) / (T1 - T0));
                p1.moveY(-stretchDistance / 4 * (process - T0) / (T1 - T0));
                p3.moveY(stretchDistance / 4 * (process - T0) / (T1 - T0));
            } else if (T1 < process && process <= T2) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T1, state);
                p1.moveX(stretchDistance / 2 * (process - T1) / (T2 - T1));
                p3.moveX(stretchDistance / 2 * (process - T1) / (T2 - T1));
            } else if (T2 < process && process <= T3) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T2, state);
                p1.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
                p3.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
                p4.moveX(stretchDistance / 2 * (process - T2) / (T3 - T2));
            } else if (T3 < process && process <= T4) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T3, state);
                p4.moveX(stretchDistance / 2 * (process - T3) / (T4 - T3));
                p1.moveY(stretchDistance / 4 * (process - T3) / (T4 - T3));
                p3.moveY(-stretchDistance / 4 * (process - T3) / (T4 - T3));
            } else if (T4 < process && process <= T5) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, T4, state);
                float offset = Utils.vibration(
                        (process - T4) / (T5 - T4),
                        TOTAL_LENGTH,
                        stretchDistance / VIBRATION_STRETCH_RATIO,
                        B,
                        C,
                        D);
                p2.moveX(offset);
                p4.moveX(offset);
            }
        } else if (state.equals(State.RIGHT_TO_LEFT)) {
            float rProcess = 1 - process;
            if (T0 <= rProcess && rProcess <= T1) {
                p4.moveX(-stretchDistance * (rProcess - T0) / (T1 - T0));
                p1.moveY(-stretchDistance / 4 * (rProcess - T0) / (T1 - T0));
                p3.moveY(stretchDistance / 4 * (rProcess - T0) / (T1 - T0));
            } else if (T1 < rProcess && rProcess <= T2) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T1, state);
                p1.moveX(-stretchDistance / 2 * (rProcess - T1) / (T2 - T1));
                p3.moveX(-stretchDistance / 2 * (rProcess - T1) / (T2 - T1));
            } else if (T2 < rProcess && rProcess <= T3) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T2, state);
                p1.moveX(-stretchDistance / 2 * (rProcess - T2) / (T3 - T2));
                p3.moveX(-stretchDistance / 2 * (rProcess - T2) / (T3 - T2));
                p2.moveX(-stretchDistance / 2 * (rProcess - T2) / (T3 - T2));
            } else if (T3 < rProcess && rProcess <= T4) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T3, state);
                p2.moveX(-stretchDistance / 2 * (rProcess - T3) / (T4 - T3));
                p1.moveY(stretchDistance / 4 * (rProcess - T3) / (T4 - T3));
                p3.moveY(-stretchDistance / 4 * (rProcess - T3) / (T4 - T3));
            } else if (T4 < rProcess && rProcess <= T5) {
                changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, 1 - T4, state);
                float offset = -Utils.vibration(
                        (rProcess - T4) / (T5 - T4),
                        TOTAL_LENGTH,
                        stretchDistance / VIBRATION_STRETCH_RATIO,
                        B,
                        C,
                        D);
                p4.moveX(offset);
                p2.moveX(offset);
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
    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float extractLength, float process, State state, EaseType easeType) {
        if (state.equals(State.LEFT_TO_RIGHT)) {
            float offset = totalLength * easeType.getOffset((process - T1) / (T4 - T1));
            offset = Utils.limitOffset(offset, totalLength);
            p1.moveX(offset);
            p2.moveX(offset);
            p3.moveX(offset);
            p4.moveX(offset);
        } else if (state.equals(State.RIGHT_TO_LEFT)) {
            float rProcess = 1 - process;
            float offset = totalLength * easeType.getOffset((rProcess - T1) / (T4 - T1));
            offset = Utils.limitOffset(offset, totalLength);
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
