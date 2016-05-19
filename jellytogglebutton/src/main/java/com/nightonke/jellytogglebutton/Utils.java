package com.nightonke.jellytogglebutton;

import android.graphics.Color;

import com.nightonke.jellytogglebutton.ColorChangeTypes.ColorChangeType;

/**
 * Created by Weiping on 2016/5/11.
 */
public class Utils {

    public static int calculateMidColor(int leftColor, int rightColor, float process, ColorChangeType colorChangeType) {
        if (colorChangeType.equals(ColorChangeType.RGB)) {
            return Color.argb(
                    Color.alpha(leftColor) + (int)((Color.alpha(rightColor) - Color.alpha(leftColor)) * process),
                    Color.red(leftColor) + (int)((Color.red(rightColor) - Color.red(leftColor)) * process),
                    Color.green(leftColor) + (int)((Color.green(rightColor) - Color.green(leftColor)) * process),
                    Color.blue(leftColor) + (int)((Color.blue(rightColor) - Color.blue(leftColor)) * process));
        } else if (colorChangeType.equals(ColorChangeType.HSV)) {
            return getHSVColor(toHsvVector(leftColor), toHsvVector(rightColor), process);
        }
        return 0;
    }

    private static final float ERROR = 0.001f;

    public static float[] toHsvVector(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);

        float[] vector = new float[3];
        double rad = Math.PI * hsv[0] / 180;
        vector[0] = (float) Math.cos(rad) * hsv[1];
        vector[1] = (float) Math.sin(rad) * hsv[1];
        vector[2] = hsv[2];
        return vector;
    }

    public static int getHSVColor(float[] vector0, float[] vector1, float delta) {
        float[] vector = new float[3];
        vector[0] = (vector1[0] - vector0[0]) * delta + vector0[0];
        vector[1] = (vector1[1] - vector0[1]) * delta + vector0[1];
        vector[2] = (vector1[2] - vector0[2]) * delta + vector0[2];

        float[] hsv = new float[3];
        hsv[1] = (float) Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);
        hsv[0] = hsv[1] < ERROR ? 0 :
                (float) (Math.atan2(vector[1] / hsv[1], vector[0] / hsv[1]) * 180 / Math.PI);
        if (hsv[0] < 0)
            hsv[0] += 360f;
        hsv[2] = vector[2];

        return Color.HSVToColor(hsv);
    }

    /**
     * Notice that x is in (0, 1].
     * Should firstly, x = totalLength * x.
     * Then get y = A * e ^ (- B * x) * sin(C * x + D).
     *
     * @param x
     * @param totalLength
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static float vibration(float x, float totalLength, float A, float B, float C, float D) {
        x *= totalLength;
        return (float) (A * Math.exp(-B * x) * Math.sin(C * x + D));
    }

    public static float limitOffset(float offset, float totalLength) {
        offset = offset > 0 ? offset : 0;
        offset = offset > totalLength ? totalLength : offset;
        return offset;
    }

    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }
}
