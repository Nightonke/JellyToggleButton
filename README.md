# JellyToggleButton

[![WoWoViewPager](https://github.com/Nightonke/WoWoViewPager/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/WoWoViewPager)
[![BoomMenu](https://github.com/Nightonke/BoomMenu/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/BoomMenu)
[![CoCoin](https://github.com/Nightonke/CoCoin/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/CoCoin)
[![BlurLockView](https://github.com/Nightonke/BlurLockView/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/BlurLockView)
[![LeeCo](https://github.com/Nightonke/LeeCo/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/LeeCo)
[![GithubWidget](https://github.com/Nightonke/GithubWidget/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/GithubWidget)
[![JellyToggleButton](https://github.com/Nightonke/JellyToggleButton/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/JellyToggleButton)
[![FaceOffToggleButton](https://github.com/Nightonke/FaceOffToggleButton/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/FaceOffToggleButton)

![JellyToggleButton](https://github.com/Nightonke/JellyToggleButton/blob/master/img/JellyToggleButton4.gif?raw=true)  
JellyToggleButton(JTB) is a cute toggle button with 18 jelly types and 30 ease types.  
You can also [define](https://github.com/Nightonke/JellyToggleButton#define-your-jelly) your own style and have your JTB custom-made.  
Maybe the gif above can not show how cute JTB is. You can click to see the video of JTB below.  
[![JellyToggleButton](https://github.com/Nightonke/JellyToggleButton/blob/master/img/youtobe_image.png?raw=true)](https://youtu.be/j9tpsuc5YFE)

# Guide

1. [中文文档](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md)
2. [Note](https://github.com/Nightonke/JellyToggleButton#note)
2. [Gradle](https://github.com/Nightonke/JellyToggleButton#gradle)
3. [Demo](https://github.com/Nightonke/JellyToggleButton#demo)
4. [Use Guide](https://github.com/Nightonke/JellyToggleButton#use-guide)
    1. [18 Jellys](https://github.com/Nightonke/JellyToggleButton#18-jellys)
    2. [Define Your Jelly](https://github.com/Nightonke/JellyToggleButton#define-your-jelly)
    2. [Ease Types](https://github.com/Nightonke/JellyToggleButton#ease-types)
    3. [SetCheck Methods](https://github.com/Nightonke/JellyToggleButton#setcheck-methods)
    4. [Colors](https://github.com/Nightonke/JellyToggleButton#colors)
    4. [ColorChangeType](https://github.com/Nightonke/JellyToggleButton#colorchangetype)
    5. [Fonts](https://github.com/Nightonke/JellyToggleButton#fonts)
    6. [Duration](https://github.com/Nightonke/JellyToggleButton#duration)
    7. [Text, Text Size and Margins](https://github.com/Nightonke/JellyToggleButton#text-text-size-and-margins)
    8. [Draggable](https://github.com/Nightonke/JellyToggleButton#draggable)
    9. [Listener](https://github.com/Nightonke/JellyToggleButton#listener)
    10. [Other Methods](https://github.com/Nightonke/JellyToggleButton#other-methods)
5. [Versions](https://github.com/Nightonke/JellyToggleButton#versions)
6. [Todo](https://github.com/Nightonke/JellyToggleButton#todo)
7. [License](https://github.com/Nightonke/JellyToggleButton#license)

# Note
1. Code inspired from [SwitchButton](https:/a/github.com/kyleduo/SwitchButton)

# Gradle

```
dependencies {
    ...
    compile 'com.nightonke:jellytogglebutton:1.0.2'
    ...
}
```

# Demo

![Demo](https://github.com/Nightonke/JellyToggleButton/blob/master/img/demo_picture.png?raw=true)  
Try the demo above to see how cute JTB is. Download the apk from:  
1. [Github](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.2.apk?raw=true)  
2. [http://fir.im/jellytogglebutton](http://fir.im/jellytogglebutton)  
3.   
[![Qrcode](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.2.png?raw=true)](http://fir.im/jellytogglebutton)

# Use Guide
1. [18 Jellys](https://github.com/Nightonke/JellyToggleButton#18-jellys)
2. [Define Your Jelly](https://github.com/Nightonke/JellyToggleButton#define-your-jelly)
2. [Ease Types](https://github.com/Nightonke/JellyToggleButton#ease-types)
3. [SetCheck Methods](https://github.com/Nightonke/JellyToggleButton#setcheck-methods)
4. [Colors](https://github.com/Nightonke/JellyToggleButton#colors)
4. [ColorChangeType](https://github.com/Nightonke/JellyToggleButton#colorchangetype)
5. [Fonts](https://github.com/Nightonke/JellyToggleButton#fonts)
6. [Duration](https://github.com/Nightonke/JellyToggleButton#duration)
7. [Text, Text Size and Margins](https://github.com/Nightonke/JellyToggleButton#text-text-size-and-margins)
8. [Draggable](https://github.com/Nightonke/JellyToggleButton#draggable)
9. [Listener](https://github.com/Nightonke/JellyToggleButton#listener)
10. [Other Methods](https://github.com/Nightonke/JellyToggleButton#other-methods)

## 18 Jellys
JTB provides 18 kinds of jelly types to show different effects of thumb. You can use different jelly types in xml or by ```setJelly()``` method.  
Use in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbJelly="itself"
    />
```
Use in setter:  
```
jtb.setJelly(Jelly.ITSELF);
```
|app:jtbJelly=""|setJelly()|Effect|
|:---|:---|:---|
|itself|ITSELF|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/Itself.gif?raw=true)|
|lazy_tremble_head_fatty|LAZY_TREMBLE_HEAD_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyTrembleHeadFatty.gif?raw=true)|
|lazy_tremble_head_slim_jim|LAZY_TREMBLE_HEAD_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyTrembleHeadSlimJim.gif?raw=true)|
|lazy_tremble_tail_fatty|LAZY_TREMBLE_TAIL_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyTrembleTailFatty.gif?raw=true)|
|lazy_tremble_tail_slim_jim|LAZY_TREMBLE_TAIL_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyTrembleTailSlimJim.gif?raw=true)|
|lazy_tremble_body_fatty|LAZY_TREMBLE_BODY_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyTrembleBodyFatty.gif?raw=true)|
|lazy_tremble_body_slim_jim|LAZY_TREMBLE_BODY_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyTrembleBodySlimJim.gif?raw=true)|
|lazy_stiff_fatty|LAZY_STIFF_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyStiffFatty.gif?raw=true)|
|lazy_stiff_slim_jim|LAZY_STIFF_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/LazyStiffSlimJim.gif?raw=true)|
|active_tremble_head_fatty|ACTIVE_TREMBLE_HEAD_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveTrembleHeadFatty.gif?raw=true)|
|active_tremble_head_slim_jim|ACTIVE_TREMBLE_HEAD_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveTrembleHeadSlimJim.gif?raw=true)|
|active_tremble_tail_fatty|ACTIVE_TREMBLE_TAIL_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveTrembleTailFatty.gif?raw=true)|
|active_tremble_tail_slim_jim|ACTIVE_TREMBLE_TAIL_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveTrembleTailSlimJim.gif?raw=true)|
|active_tremble_body_fatty|ACTIVE_TREMBLE_BODY_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveTrembleBodyFatty.gif?raw=true)|
|active_tremble_body_slim_jim|ACTIVE_TREMBLE_BODY_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveTrembleBodySlimJim.gif?raw=true)|
|active_stiff_fatty|ACTIVE_STIFF_FATTY|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveStiffFatty.gif?raw=true)|
|active_stiff_slim_jim|ACTIVE_STIFF_SLIM_JIM|![](https://github.com/Nightonke/JellyToggleButton/blob/master/img/ActiveStiffSlimJim.gif?raw=true)|
|random|RANDOM|All Above|

Notice that random type will change the jelly among the other 17 types randomly.

## Define Your Jelly
You can define you own jelly easily. But you need sometime to understand what happens in the source code of [Jelly enum](https://github.com/Nightonke/JellyToggleButton/tree/master/jellytogglebutton/src/main/java/com/nightonke/jellytogglebutton/JellyTypes). All the jelly type are the sub types of [JellyStyle.class](https://github.com/Nightonke/JellyToggleButton/blob/master/jellytogglebutton/src/main/java/com/nightonke/jellytogglebutton/JellyTypes/JellyStyle.java).  
To extend the abstract class, you have to override 3 methods:
```
public class MyJelly extends JellyStyle {

    @Override
    public void changeShape(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius, float process, State state) {
        // Change the shape of the thumb.
        // Notice that we use 12 points to form 4 bezier lines to draw the thumb.
        // We can control the shape of the thumb by controling the 12 points.
    }

    @Override
    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float extractLength, float process, State state, EaseType easeType) {
        // Change the offset of the thumb.
    }

    @Override
    public float extractLength(float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius) {
        // Return the extract length.
    }
}
```
After this, use ```setCustomJelly()``` to set your custom jelly. Notice that if you don't want to use the custom any more, you have to use ```removeCustomJelly()``` to reset.

## Ease Types
Ease types are used to set the effect of movement of the thumb.    
![Ease](https://github.com/Nightonke/WoWoViewPager/blob/master/Pictures/ease.png)  
Of course you can use linear function. 
You can find all the ease enums [here](https://github.com/Nightonke/WoWoViewPager/blob/master/wowoviewpager/src/main/java/com/nightonke/wowoviewpager/Eases/EaseType.java).  
It's very convenient to use ease types in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbEaseType="ease_in_out_circ"
    />
```
Or use setter:  
```
jtb.setEaseType(EaseType.EaseInOutCirc);
```
Check all the ease types below.  

|app:jtbEaseType=""|setEaseType()|
|:---|:---|
|ease_in_sine|EaseType.EaseInSine|
|ease_out_sine|EaseType.EaseOutSine|
|ease_in_out_sine|EaseType.EaseInOutSine|
|ease_in_quad|EaseType.EaseInQuad|
|ease_out_quad|EaseType.EaseOutQuad|
|ease_in_out_quad|EaseType.EaseInOutQuad|
|ease_in_cubic|EaseType.EaseInCubic|
|ease_out_cubic|EaseType.EaseOutCubic|
|ease_in_out_cubic|EaseType.EaseInOutCubic|
|ease_in_quart|EaseType.EaseInQuart|
|ease_out_quart|EaseType.EaseOutQuart|
|ease_in_out_quart|EaseType.EaseInOutQuart|
|ease_in_quint|EaseType.EaseInQuint|
|ease_out_quint|EaseType.EaseOutQuint|
|ease_in_out_quint|EaseType.EaseInOutQuint|
|ease_in_expo|EaseType.EaseInExpo|
|ease_out_expo|EaseType.EaseOutExpo|
|ease_in_out_expo|EaseType.EaseInOutExpo|
|ease_in_circ|EaseType.EaseInCirc|
|ease_out_circ|EaseType.EaseOutCirc|
|ease_in_out_circ|EaseType.EaseInOutCirc|
|ease_in_back|EaseType.EaseInBack|
|ease_out_back|EaseType.EaseOutBack|
|ease_in_out_back|EaseType.EaseInOutBack|
|ease_in_elastic|EaseType.EaseInElastic|
|ease_out_elastic|EaseType.EaseOutElastic|
|ease_in_out_elastic|EaseType.EaseInOutElastic|
|ease_in_bounce|EaseType.EaseInBounce|
|ease_out_bounce|EaseType.EaseOutBounce|
|ease_in_out_bounce|EaseType.EaseInOutBounce|
|linear|EaseType.Linear|

## SetCheck Methods
You can control the state of the JTB of the following methods:  
(When the thumb is to the end of right, we say the JTB is checked)

1. ```isChecked()``` Whether the JTB is checked.
2. ```setChecked(boolean checked)``` Set the JTB to checked or not with animation. If the [listener](https://github.com/Nightonke/JellyToggleButton#listener) has been set, it will be called.
3. ```setChecked(boolean checked, boolean callListener)``` Same as above, but you can choose whether call the listener(if not null).
4. ```setCheckedImmediately(boolean checked)``` Set the JTB to checked or not immediately without animation. This method will call the listener if it's not null.
5. ```setCheckedImmediately(boolean checked, boolean callListener)``` Same as above, and you can choose whether call the listener.
6. ```toggle()``` Change the JTB to another state and call the listener.
7. ```toggle(boolean callListener)``` Same as above and you can choose whether call the listener.
8. ```toggleImmediately()``` Toggle, without animation and call the listener.
9. ```toggleImmediately(boolean callListener)``` Toggle, without animation and you can choose not to call the listener.

## Colors
Let's make the JTB colorful.  

![Color](https://github.com/Nightonke/JellyToggleButton/blob/master/img/Color.gif?raw=true)

### Left Background Color  
Change the background color when the thumb is to the end of left with:    
1. ```setLeftBackgroundColor(int color)```  
2. ```setLeftBackgroundColor(String color)```  
3. ```setLeftBackgroundColorRes(int res)``  

### Right Background Color 
Change the background color when the thumb is to the end of right with:  
1. ```setRightBackgroundColor(int color)```  
2. ```setRightBackgroundColor(String color)```  
3. ```setRightBackgroundColorRes(int res)```  

### Both Left and Right Background Color
Change left and right background color with:  
1. ```setBackgroundColor(int color)```  
2. ```setBackgroundColor(String color)```  
3. ```setBackgroundColorRes(int res)```  

### Left Thumb Color  
Change the thumb color when the thumb is to the end of left with:    
1. ```setLeftThumbColor(int color)```  
2. ```setLeftThumbColor(String color)```  
3. ```setLeftThumbColorRes(int res)```  

### Right Thumb Color 
Change the thumb color when the thumb is to the end of right with:  
1. ```setRightThumbColor(int color)```  
2. ```setRightThumbColor(String color)```  
3. ```setRightThumbColorRes(int res)```  

### Both Left and Right Thumb Color  
Change left and right thumb color with:  
1. ```setThumbColor(int color)```  
2. ```setThumbColor(String color)```  
3. ```setThumbColorRes(int res)```  

### Left Text Color  
Change the left text color with:    
1. ```setLeftTextColor(int color)```  
2. ```setLeftTextColor(String color)```  
3. ```setLeftTextColorRes(int res)```  

### Right Text Color 
Change the right text color with:  
1. ```setRightTextColor(int color)```  
2. ```setRightTextColor(String color)```  
3. ```setRightTextColorRes(int res)```  

### Both Left and Right Text Color  
Change left and right text color with:  
1. ```setTextColor(int color)```  
2. ```setTextColor(String color)```  
3. ```setTextColorRes(int res)``` 

Or set colors in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbLeftBackgroundColor="@android:color/black"
    app:jtbRightBackgroundColor="@android:color/white"
    app:jtbLeftThumbColor="@android:color/white"
    app:jtbRightThumbColor="@android:color/black"
    app:jtbLeftTextColor="@android:color/black"
    app:jtbRightTextColor="@android:color/white"
    />
```

# ColorChangeType

There are 2 types to perform the color changing. Use ```setColorChangeType(ColorChangeType colorChangeType)``` to select ColorChangeType.RGB or ColorChangeType.HSV or set it in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbColorChangeType="hsv"
    />
```
For more information, check [here](https://github.com/Nightonke/WoWoViewPager#rgb-or-hsv).

# Fonts

Use ```setLeftTextTypeface(Typeface typeface)``` and ```setLeftTextTypeface(String typefaceString)``` to set the typeface of the left text. Notice that the ```typefaceString``` is in the assets directory.  Similarly, use ```setRightTextTypeface(Typeface typeface)``` and ```setRightTextTypeface(String typefaceString)``` to set the typeface of the right text.  
Or in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbLeftTextTypeface="fonts/Lato-Hairline.ttf"
    app:jtbRightTextTypeface="fonts/Lato-Hairline.ttf"
    />
```

# Duration

Use ```setDuration(int duration)``` to set the duration when the thumb is animating(in ms). The default value is 1000(ms).  
Or in xml:
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbDuration="1000"
    />
```

# Text, Text Size and Margins

1. Use ```setLeftText(String text)``` , ```setLeftTextRes(int res)``` , ```setRightText(String text)``` , ```setRightTextRes(int res)``` , ```setText(String leftText, String rightText)``` and ```setTextRes(int leftRes, int rightRes)``` to set the text.
2. Use ```setTextSize(int textSize)``` and ```setTextSizeRes(int res)``` to set the text size.
3. Use ```setTextMarginLeft(float margin)``` and ```setTextMarginLeftRes(int res)``` to set the margin between the left text and the left-end of background.
4. Use ```setTextMarginRight(float margin)``` and ```setTextMarginRightRes(int res)``` to set the margin between the right text and the right-end of background.
5. Use ```setTextMarginTop(float margin)``` and ```setTextMarginTopRes(int res)``` to set the margin between the text and the top of background.
6. Use ```setTextMarginBottom(float margin)``` and ```setTextMarginBottomRes(int res)``` to set the margin between the text and the bottom of background.
7. Use ```setTextMarginCenter(float margin)``` and ```setTextMarginCenterRes(int res)``` to set the margin between the left text and the right text.

Or in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbLeftText="Male"
    app:jtbRightText="Female"
    app:jtbLeftTextSize="12sp"
    app:jtbRightTextSize="12sp"
    app:jtbTextMarginLeft="2dp"
    app:jtbTextMarginRight="2dp"
    app:jtbTextMarginBottom="2dp"
    app:jtbTextMarginTop="2dp"
    app:jtbTextMarginCenter="4dp"
    />
```

# Draggable

If you want to forbid user to drag the JTB, just call ```setDraggable(boolean draggable)``` to false.  
Or in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbDraggable="false"
    />
```

# Listener

JTB use ```OnStateChangeListener``` to detech all the events of itself.  
```
jtb.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
    @Override
    public void onStateChange(float process, State state, JellyToggleButton jtb) {
        // process - current process of JTB, between [0, 1]
        // state   - current state of JTB, it is one of State.LEFT, State.LEFT_TO_RIGHT, State.RIGHT and State.RIGHT_TO_LEFT
        // jtb     - the JTB
    }
});
```

For example, if you want to detech when JTB is open or close(open means the thumb moves to the end of right):  
```
@Override
public void onStateChange(float process, State state, JellyToggleButton jbt) {
    if (state.equals(State.LEFT)) {
        if (lastToast != null) lastToast.cancel();
        lastToast = Toast.makeText(this, "Left!", Toast.LENGTH_SHORT);
        lastToast.show();
    }
    if (state.equals(State.RIGHT)) {
        if (lastToast != null) lastToast.cancel();
        lastToast = Toast.makeText(this, "Right!", Toast.LENGTH_SHORT);
        lastToast.show();
    }
}
```

When the thumb is move to same state, for instance, you drag the thumb just a little bit and then let it go and the thumb will smoothly move to it's last state(left or right). You can use ```setMoveToSameStateCallListener(boolean callListener)``` to select whether call listener when the above situation happens.  
Or in xml:  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbMoveToSameStateCallListener="true"
    />
```

# Other Methods

There are some methods to modify some useless values. You can use them to fine-tone the JTB.

1. ```setTouchMoveRatioValue(float ratio)``` Set the ratio of distance of dragging to distance of the thumb-movement.
2. ```setBezierControlValue(float value)``` and ```setBezierControlValueRes(int res)``` Set the Bezier control value.
3. ```setStretchDistanceRatioValue(float value)``` Set the ratio of thumb-radius to the stretch distance.
4. ```setBezierScaleRatioValue(float value)``` and ```setBezierScaleRatioValueRes(int res)``` Set the Bezier scale control value.

# Versions
### [Jelly 1.0.1](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.1.apk?raw=true)
Test Version.
### [Jelly 1.0.2](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.2.apk?raw=true)
First Version.

# Todo
Todo list is in my todo list.

# License

    Copyright 2016 Nightonke

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
