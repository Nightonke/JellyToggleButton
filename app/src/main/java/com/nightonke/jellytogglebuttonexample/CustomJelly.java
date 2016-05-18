package com.nightonke.jellytogglebuttonexample;

import com.nightonke.jellytogglebutton.EaseTypes.EaseType;
import com.nightonke.jellytogglebutton.JellyTypes.JellyStyle;
import com.nightonke.jellytogglebutton.PointWithHorizontalPoints;
import com.nightonke.jellytogglebutton.PointWithVerticalPoints;
import com.nightonke.jellytogglebutton.State;

/**
 * Created by Weiping on 2016/5/19.
 */

public class CustomJelly extends JellyStyle {
    @Override
    public void changeShape(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius, float process, State state) {
        // be itself
    }

    @Override
    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float extractLength, float process, State state, EaseType easeType) {
        if (state.equals(State.LEFT_TO_RIGHT)) {
            float offset = totalLength * easeType.getOffset(process);
            offset = offset > 0 ? offset : 0;
            p1.moveX(offset);
            p2.moveX(offset);
            p3.moveX(offset);
            p4.moveX(offset);
        } else if (state.equals(State.RIGHT_TO_LEFT)) {
            float rProcess = 1 - process;
            float offset = totalLength * easeType.getOffset(rProcess);
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
        return 0;
    }
}
