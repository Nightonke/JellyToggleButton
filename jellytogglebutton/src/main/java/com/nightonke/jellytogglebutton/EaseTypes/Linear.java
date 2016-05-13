package com.nightonke.jellytogglebutton.EaseTypes;

/**
 * Created by Weiping on 2016/3/3.
 */

public class Linear extends CubicBezier {

    public Linear() {
        init(0, 0, 1, 1);
    }

    @Override
    public float getOffset(float offset) {
        return offset;
    }
}
