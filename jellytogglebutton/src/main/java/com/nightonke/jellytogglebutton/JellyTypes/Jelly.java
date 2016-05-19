package com.nightonke.jellytogglebutton.JellyTypes;

import com.nightonke.jellytogglebutton.EaseTypes.EaseType;
import com.nightonke.jellytogglebutton.PointWithHorizontalPoints;
import com.nightonke.jellytogglebutton.PointWithVerticalPoints;
import com.nightonke.jellytogglebutton.State;

/**
 * Created by Weiping on 2016/5/11.
 */

public enum Jelly {

    ITSELF(Itself.class),
    LAZY_TREMBLE_HEAD_FATTY(LazyTrembleHeadFatty.class),
    LAZY_TREMBLE_HEAD_SLIM_JIM(LazyTrembleHeadSlimJim.class),
    LAZY_TREMBLE_TAIL_FATTY(LazyTrembleTailFatty.class),
    LAZY_TREMBLE_TAIL_SLIM_JIM(LazyTrembleTailSlimJim.class),
    LAZY_TREMBLE_BODY_FATTY(LazyTrembleBodyFatty.class),
    LAZY_TREMBLE_BODY_SLIM_JIM(LazyTrembleBodySlimJim.class),
    LAZY_STIFF_FATTY(LazyStiffFatty.class),
    LAZY_STIFF_SLIM_JIM(LazyStiffSlimJim.class),
    ACTIVE_TREMBLE_HEAD_FATTY(ActiveTrembleHeadFatty.class),
    ACTIVE_TREMBLE_HEAD_SLIM_JIM(ActiveTrembleHeadSlimJim.class),
    ACTIVE_TREMBLE_TAIL_FATTY(ActiveTrembleTailFatty.class),
    ACTIVE_TREMBLE_TAIL_SLIM_JIM(ActiveTrembleTailSlimJim.class),
    ACTIVE_TREMBLE_BODY_FATTY(ActiveTrembleBodyFatty.class),
    ACTIVE_TREMBLE_BODY_SLIM_JIM(ActiveTrembleBodySlimJim.class),
    ACTIVE_STIFF_FATTY(ActiveStiffFatty.class),
    ACTIVE_STIFF_SLIM_JIM(ActiveStiffSlimJim.class),
    RANDOM(Random.class);

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
            float process,
            State state) {
        try {
            ((JellyStyle) c.getConstructor().newInstance()).changeShape(p1, p2, p3, p4, stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius, process, state);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Jelly style init error.");
        }
    }

    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float extractLength, float process, State state, EaseType easeType) {
        try {
            ((JellyStyle) c.getConstructor().newInstance()).changeOffset(p1, p2, p3, p4, totalLength, extractLength, process, state, easeType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Jelly style init error.");
        }
    }

    public float extractLength(float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius) {
        try {
            return ((JellyStyle) c.getConstructor().newInstance()).extractLength(stretchDistance, bezierControlValue, bezierScaleRatioValue, thumbRadius);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Jelly style init error.");
        }
    }
}
