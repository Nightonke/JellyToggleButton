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
JellyToggleButton(JTB)是一款拥有18种果冻动态效果和30种缓动类型的开关按钮。你也可以自己[定制](https://github.com/Nightonke/JellyToggleButton#define-your-jelly)属于自己的JTB。也许上面的gif不太清晰，点击下面的视频可以看到JTB的动态效果。  
[![JellyToggleButton](https://github.com/Nightonke/JellyToggleButton/blob/master/img/youtobe_image.png?raw=true)](https://youtu.be/j9tpsuc5YFE)

# Guide

1. [English Readme](https://github.com/Nightonke/JellyToggleButton)
2. [Note](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#note)
2. [Gradle](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#gradle)
3. [Demo](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#demo)
4. [Use Guide](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#use-guide)
    1. [18 Jellys](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#18-jellys)
    2. [Define Your Jelly](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#define-your-jelly)
    2. [Ease Types](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#ease-types)
    3. [SetCheck Methods](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#setcheck-methods)
    4. [Colors](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#colors)
    4. [ColorChangeType](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#colorchangetype)
    5. [Fonts](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#fonts)
    6. [Duration](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#duration)
    7. [Text, Text Size and Margins](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#text-text-size-and-margins)
    8. [Draggable](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#draggable)
    9. [Listener](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#listener)
    10. [Other Methods](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#other-methods)
5. [Versions](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#versions)
6. [Todo](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#todo)
7. [License](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#license)

# Note
1. 部分代码启发自 [SwitchButton](https:/a/github.com/kyleduo/SwitchButton)

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
Demo里可以看到目前JTB支持的所有效果，可以从这下载Demo：    
1. [Github](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.2.apk?raw=true)  
2. [http://fir.im/jellytogglebutton](http://fir.im/jellytogglebutton)  
3.   
[![Qrcode](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.2.png?raw=true)](http://fir.im/jellytogglebutton)

# Use Guide
1. [18 Jellys](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#18-jellys)
2. [Define Your Jelly](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#define-your-jelly)
2. [Ease Types](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#ease-types)
3. [SetCheck Methods](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#setcheck-methods)
4. [Colors](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#colors)
4. [ColorChangeType](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#colorchangetype)
5. [Fonts](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#fonts)
6. [Duration](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#duration)
7. [Text, Text Size and Margins](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#text-text-size-and-margins)
8. [Draggable](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#draggable)
9. [Listener](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#listener)
10. [Other Methods](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#other-methods)

## 18 Jellys
JTB提供18种果冻动态效果，可以在xml中轻松使用或者在代码中通过```setJelly()```方法来设置。  
xml中：  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbJelly="itself"
    />
```
JAVA代码中：  
```
jtb.setJelly(Jelly.ITSELF);
```
|app:jtbJelly=""|setJelly()|效果|
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
|random|RANDOM|以上所有|

注意最后一种随机类型会随机在其他17种类型之间随机切换。

## Define Your Jelly
JTB提供自定义果冻效果的方法。但是理解具体的实现原理需要花点时间来阅读[Jelly enum源码](https://github.com/Nightonke/JellyToggleButton/tree/master/jellytogglebutton/src/main/java/com/nightonke/jellytogglebutton/JellyTypes)。所有的果冻效果都是来自于超类[JellyStyle.class](https://github.com/Nightonke/JellyToggleButton/blob/master/jellytogglebutton/src/main/java/com/nightonke/jellytogglebutton/JellyTypes/JellyStyle.java)。继承这个超类的时候，你需要实现三个方法：  
```
public class MyJelly extends JellyStyle {

    @Override
    public void changeShape(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius, float process, State state) {
        // 改变手柄的形状
        // 注意我们用了12个点来控制4条贝塞尔曲线来绘制手柄
        // 我们可以通过控制这12个点来控制手柄形状
    }

    @Override
    public void changeOffset(PointWithHorizontalPoints p1, PointWithVerticalPoints p2, PointWithHorizontalPoints p3, PointWithVerticalPoints p4, float totalLength, float extractLength, float process, State state, EaseType easeType) {
        // 改变手柄的位移
    }

    @Override
    public float extractLength(float stretchDistance, float bezierControlValue, float bezierScaleRatioValue, float thumbRadius) {
        // 返回在形变中额外增加的距离
    }
}
```
继承了上述超类、实现了这三个方法之后，使用```setCustomJelly()```来激活你的自定义果冻动效。注意，如果你不再想使用你的自定义效果，要使用```removeCustomJelly()```方法来重置。

## Ease Types
缓动类型可以用来产生手柄的不同位移效果。     
![Ease](https://github.com/Nightonke/WoWoViewPager/blob/master/Pictures/ease.png)  
当然还有线性效果。你可以在[这里](https://github.com/Nightonke/WoWoViewPager/blob/master/wowoviewpager/src/main/java/com/nightonke/wowoviewpager/Eases/EaseType.java)找到所有的缓动效果。  
可以非常轻松地在xml中使用缓动类型：  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbEaseType="ease_in_out_circ"
    />
```
或者通过JAVA代码：  
```
jtb.setEaseType(EaseType.EaseInOutCirc);
```
下表列出了所有的缓动效果：  

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
JTB提供全面的方法来方便使用者改变JTB的状态（当手柄在右边，我们说此时开关按钮处于打开，也就是checked状态）： 

1. ```isChecked()``` 返回当前JTB是否处于打开状态。
2. ```setChecked(boolean checked)``` 设置JTB当前的状态，并伴以动画。如果[监听器](https://github.com/Nightonke/JellyToggleButton/blob/master/README-ZH.md#listener)被设置，那么它将会被调用。
3. ```setChecked(boolean checked, boolean callListener)``` 同上，但是可以选择是否调用监听器（如果它不为空）。
4. ```setCheckedImmediately(boolean checked)``` 设置JTB的状态，不伴随动画，会调用监听器。
5. ```setCheckedImmediately(boolean checked, boolean callListener)``` 同上，但是可以选择是否调用监听器。
6. ```toggle()``` 切换状态，有动画，会调用监听器。
7. ```toggle(boolean callListener)``` 同上，可选择是否调用监听器。
8. ```toggleImmediately()``` 切换状态，无动画，会调用监听器。
9. ```toggleImmediately(boolean callListener)``` 同上，可选择是否调用监听器。

## Colors
来填涂自己的JTB。  

![Color](https://github.com/Nightonke/JellyToggleButton/blob/master/img/Color.gif?raw=true)

### Left Background Color  
改变当手柄滑到最左的背景颜色：    
1. ```setLeftBackgroundColor(int color)```  
2. ```setLeftBackgroundColor(String color)```  
3. ```setLeftBackgroundColorRes(int res)``  

### Right Background Color 
改变当手柄滑到最右的背景颜色：  
1. ```setRightBackgroundColor(int color)```  
2. ```setRightBackgroundColor(String color)```  
3. ```setRightBackgroundColorRes(int res)```  

### Both Left and Right Background Color
改变背景颜色：  
1. ```setBackgroundColor(int color)```  
2. ```setBackgroundColor(String color)```  
3. ```setBackgroundColorRes(int res)```  

### Left Thumb Color  
改变当手柄滑到最左的颜色：    
1. ```setLeftThumbColor(int color)```  
2. ```setLeftThumbColor(String color)```  
3. ```setLeftThumbColorRes(int res)```  

### Right Thumb Color 
改变当手柄滑到最右的颜色：  
1. ```setRightThumbColor(int color)```  
2. ```setRightThumbColor(String color)```  
3. ```setRightThumbColorRes(int res)```  

### Both Left and Right Thumb Color  
改变当手柄的颜色：  
1. ```setThumbColor(int color)```  
2. ```setThumbColor(String color)```  
3. ```setThumbColorRes(int res)```  

### Left Text Color  
改变左边字体颜色：   
1. ```setLeftTextColor(int color)```  
2. ```setLeftTextColor(String color)```  
3. ```setLeftTextColorRes(int res)```  

### Right Text Color 
改变右边字体颜色：  
1. ```setRightTextColor(int color)```  
2. ```setRightTextColor(String color)```  
3. ```setRightTextColorRes(int res)```  

### Both Left and Right Text Color  
改变字体颜色：  
1. ```setTextColor(int color)```  
2. ```setTextColor(String color)```  
3. ```setTextColorRes(int res)``` 

或者在xml中：  
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

使用```setColorChangeType(ColorChangeType colorChangeType)```来在两种颜色变化方式（ColorChangeType.RGB or ColorChangeType.HSV）切换，又或者通过xml：  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbColorChangeType="hsv"
    />
```
更多有关颜色变化方式信息可在[这里](https://github.com/Nightonke/WoWoViewPager#rgb-or-hsv)找到。

# Fonts

用```setLeftTextTypeface(Typeface typeface)```和```setLeftTextTypeface(String typefaceString)```来设置左文字字体，注意```typefaceString```是字体文件在assets文件夹下的路径。类似地，用 ```setRightTextTypeface(Typeface typeface)```和```setRightTextTypeface(String typefaceString)```来设置右文字字体。    
在xml中：  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbLeftTextTypeface="fonts/Lato-Hairline.ttf"
    app:jtbRightTextTypeface="fonts/Lato-Hairline.ttf"
    />
```

# Duration

用```setDuration(int duration)```来设置动画延时（毫秒），默认值是1000毫秒。    
在xml中：
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbDuration="1000"
    />
```

# Text, Text Size and Margins

1. 用```setLeftText(String text)```，```setLeftTextRes(int res)```，```setRightText(String text)```，```setRightTextRes(int res)```， ```setText(String leftText, String rightText)```和```setTextRes(int leftRes, int rightRes)```来设置文字。
2. 用```setTextSize(int textSize)```和```setTextSizeRes(int res)```来设置字体大小。
3. 用```setTextMarginLeft(float margin)```和```setTextMarginLeftRes(int res)```来设置左文字距离背景最左的距离。
4. 用```setTextMarginRight(float margin)```和```setTextMarginRightRes(int res)```来设置右文字距离背景最右的距离。
5. 用```setTextMarginTop(float margin)```和```setTextMarginTopRes(int res)```来设置文字距离背景顶部的距离。
6. 用```setTextMarginBottom(float margin)```和```setTextMarginBottomRes(int res)```来设置文字距离背景底部的距离。
7. 用```setTextMarginCenter(float margin)```和```setTextMarginCenterRes(int res)```来设置左文字和右文字之间的距离。

在xml中：  
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

如果想禁止用户对JTB的拖动操作，使用```setDraggable(boolean draggable)```来置为false。  
在xml中：  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbDraggable="false"
    />
```

# Listener

JTB使用```OnStateChangeListener```来监听其自身的事件。  
```
jtb.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
    @Override
    public void onStateChange(float process, State state, JellyToggleButton jtb) {
        // process - 当前动画进度，在[0, 1]之间
        // state   - JTB的当前状态，其值为State.LEFT，State.LEFT_TO_RIGHT，State.RIGHT和State.RIGHT_TO_LEFT其中之一
        // jtb     - JTB自身
    }
});
```

举个例子，如果需要监听JTB的开关状态（开是指手柄达到最右）：    
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

当手柄移动到相同的状态，比如，当用户只是稍微移动了一下手柄，然后就松开手，那么这个时候手柄会自己移动回它上次的终点状态（最左或最右），如果希望在移动到相同的终点状态时回调监听器，可以通过```setMoveToSameStateCallListener(boolean callListener)```来设置。  
或者在xml中：  
```
<com.nightonke.jellytogglebutton.JellyToggleButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:jtbMoveToSameStateCallListener="true"
    />
```

# Other Methods

以下函数用处很小，如果想微调JTB可以使用：

1. ```setTouchMoveRatioValue(float ratio)``` 设置拖动和手柄实际移动距离的比值。
2. ```setBezierControlValue(float value)```，```setBezierControlValueRes(int res)``` 设置贝塞尔控制参数。
3. ```setStretchDistanceRatioValue(float value)``` 设置手柄半径和拉伸距离的比值。
4. ```setBezierScaleRatioValue(float value)```，```setBezierScaleRatioValueRes(int res)``` 设置贝塞尔控制拉伸参数。

# Versions
### [Jelly 1.0.1](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.1.apk?raw=true)
Test Version.
### [Jelly 1.0.2](https://github.com/Nightonke/JellyToggleButton/blob/master/apk/Jelly%201.0.2.apk?raw=true)
First Version.

# Todo
Todo正在被todo……

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
