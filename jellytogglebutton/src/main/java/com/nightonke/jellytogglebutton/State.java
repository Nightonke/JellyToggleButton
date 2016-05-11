package com.nightonke.jellytogglebutton;

/**
 * Created by Weiping on 2016/5/10.
 */
public enum State {

    OFF(0),
    OFF_TO_ON(1),
    ON(2),
    ON_TO_OFF(3);

    int v;

    State(int v) {
        this.v = v;
    }
}
