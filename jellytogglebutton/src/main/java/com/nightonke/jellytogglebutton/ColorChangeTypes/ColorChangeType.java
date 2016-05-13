package com.nightonke.jellytogglebutton.ColorChangeTypes;

/**
 * Created by Weiping on 2016/5/11.
 */
public enum ColorChangeType {

    RGB(0),
    HSV(1);

    int v;

    ColorChangeType(int v) {
        this.v = v;
    }
}
