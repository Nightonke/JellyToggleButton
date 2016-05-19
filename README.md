# JellyToggleButton

[![WoWoViewPager](https://github.com/Nightonke/WoWoViewPager/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/WoWoViewPager)
[![BoomMenu](https://github.com/Nightonke/BoomMenu/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/BoomMenu)
[![CoCoin](https://github.com/Nightonke/CoCoin/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/CoCoin)
[![BlurLockView](https://github.com/Nightonke/BlurLockView/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/BlurLockView)
[![LeeCo](https://github.com/Nightonke/LeeCo/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/LeeCo)
[![GithubWidget](https://github.com/Nightonke/GithubWidget/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/GithubWidget)
[![JellyToggleButton](https://github.com/Nightonke/JellyToggleButton/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png?raw=true)](https://github.com/Nightonke/JellyToggleButton)

![JellyToggleButton]()  
JellyToggleButton(JTB) is a cute toggle button with 18 jelly types and 30 ease types.  
You can also [define]() your own style and have your JTB custom-made.  
Maybe the gif above can not show how cute JTB is. You can click to see the video of JTB below.  
[![JellyToggleButton](http://img.youtube.com/vi/KCSeStDJfMI/0.jpg)](https://youtu.be/KCSeStDJfMI)

# Guide

1. [中文文档]()
2. [Gradle]()
3. [Demo]()
4. [Use Guide]()
    1. [18 Jellys]()
    2. [Define Your Jelly]()
    2. [Ease Types]()
    3. [SetCheck Methods]()
    4. [Colors]()
    4. [ColorChangeType]()
    5. [Fonts]()
    6. [Duration]()
    7. [Text Size and Margins]()
    8. [Draggable]()
    9. [Listener]()
    10. [Other Methods]()
5. [Versions]()
6. [Todo]()
7. [License]()

### Gradle

```
dependencies {
    ...
    compile 'com.nightonke:jellytogglebutton:1.0.1'
    ...
}
```

### Demo

![Demo]()  
Try the demo above to see how cute JTB is. Download the apk from:  
1. [Github]()
2. [http://fir.im/jellytogglebutton](http://fir.im/jellytogglebutton)  
3. [![Qrcode]()](http://fir.im/jellytogglebutton)

### User Guide

#### 18 Jellys
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
|---|---|---|
|itself|ITSELF||
|lazy_tremble_head_fatty|LAZY_TREMBLE_HEAD_FATTY||
|lazy_tremble_head_slim_jim|LAZY_TREMBLE_HEAD_SLIM_JIM||
|lazy_tremble_tail_fatty|LAZY_TREMBLE_TAIL_FATTY||
|lazy_tremble_tail_slim_jim|LAZY_TREMBLE_TAIL_SLIM_JIM||
|lazy_tremble_body_fatty|LAZY_TREMBLE_BODY_FATTY||
|lazy_tremble_body_slim_jim|LAZY_TREMBLE_BODY_SLIM_JIM||
|lazy_stiff_fatty|LAZY_STIFF_FATTY||
|lazy_stiff_slim_jim|LAZY_STIFF_SLIM_JIM||
|active_tremble_head_fatty|ACTIVE_TREMBLE_HEAD_FATTY||
|active_tremble_head_slim_jim|ACTIVE_TREMBLE_HEAD_SLIM_JIM||
|active_tremble_tail_fatty|ACTIVE_TREMBLE_TAIL_FATTY||
|active_tremble_tail_slim_jim|ACTIVE_TREMBLE_TAIL_SLIM_JIM||
|active_tremble_body_fatty|ACTIVE_TREMBLE_BODY_FATTY||
|active_tremble_body_slim_jim|ACTIVE_TREMBLE_BODY_SLIM_JIM||
|active_stiff_fatty|ACTIVE_STIFF_FATTY||
|active_stiff_slim_jim|ACTIVE_STIFF_SLIM_JIM||
|random|RANDOM||

Notice that random type will change the jelly among the other 17 types randomly.

#### Define Your Jelly
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

#### Ease Types
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
|---|---|
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

#### SetCheck Methods
You can control the 










