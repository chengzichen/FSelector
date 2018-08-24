# FSelector

欢迎使用 Flyabbit  🔜 全家桶 

FSelector  quick get Selector  by no xml


- [功能](#功能)
- [效果](#效果)
- [安装](#安装)
- [用途](#用途)
    - [API](#API说明)
- [TODO](#TODO)
- [作者](#作者)
- [更变日志](#变更日志)
- [Flyabbit系列](#Flyabbit系列)

## 功能

* 快速，高效，低耗
* 简易的整合,轻量级
* 基本没有依赖于任何的三方库


----------

## 安装

模块|FSelector
---|---
最新版本|[![](https://www.jitpack.io/v/chengzichen/FSelector.svg)](https://www.jitpack.io/#chengzichen/FSelector)



- 方式一:

**Step 1.  在根目录的gradle文件中配置**


**Add it in your root build.gradle at the end of repositories:**


	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


**step2 添加依赖:**

	dependencies {
        	        implementation 'com.github.chengzichen:FSelector:release1.0.0'
        	}


---------

## 效果



<div >   
		 <img src="http://thyrsi.com/t6/361/1535089756x1822611233.gif" width = "150" height = "240" alt="图片名称" align=cente/>
</div>


## 用途
- **圆角背景**

	- Xml

	```
	 <shape xmlns:android="http://schemas.android.com/apk/res/android" >
	     <corners
	     android:bottomLeftRadius="15dp"
	     android:bottomRightRadius="15dp"
	     android:topLeftRadius="15dp"
	     android:topRightRadius="15dp" />
	     <solid android:color="@color/clr_fb720e" />
	 </shape>
	```

	- **FSelector**:
 
	```
	FSelector.with(tvtext1)
	                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_fb720e))
	                .create()
	                .bind();
	```

- **带边框的圆角背景**

	- xml:

	```
	 <shape xmlns:android="http://schemas.android.com/apk/res/android" >
	     <corners
	     android:bottomLeftRadius="15dp"
	     android:bottomRightRadius="15dp"
	     android:topLeftRadius="15dp"
	     android:topRightRadius="15dp" />
	     <solid android:color="@color/clr_fb720e" />
	     <size
	     android:height="65dp"
	     android:width="180dp" />
	     <stroke
	     android:width="2dp"
	     android:color="@color/clr_f0f0f0" />
	 </shape>
	```


	- **FSelector**:

	```
	FSelector.with(tvtext2)
	                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_fb720e))
	                .strokeClr(Color.BLUE).stokeWidth(dp2px(2))
	                .create()
	                .bind();
	```

- **圆角选择器**
	- xml
 
	```
 	//圆角1
     <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     <corners
     android:bottomLeftRadius="15dp"
     android:bottomRightRadius="15dp"
     android:topLeftRadius="15dp"
     android:topRightRadius="15dp" />
     <solid android:color="@color/clr_fb720e" />
     </shape>

     //圆角2
     <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     <corners
     android:bottomLeftRadius="15dp"
     android:bottomRightRadius="15dp"
     android:topLeftRadius="15dp"
     android:topRightRadius="15dp" />
     <solid android:color="@color/clr_fb720e" />

     </shape>
      <selector xmlns:android="http://schemas.android.com/apk/res/android">
     <item android:state_pressed="true" android:drawable="@drawable/shape1" />
     <item android:state_pressed="false" android:drawable="@drawable/shape2" />
     </selector>
	
	```
	
	- **FSelector**

	```
	  FSelector.with(tvtext3)
	                .addDrawable(STATE_PRESSED).circleAngle(dp2px(15)).bgColor(getColors(R.color
	                .clr_fb720e))
	                .create()
	                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_cdcdcd))
	                .create()
	                .bind();
	```

- **圆角带边框选择器**

	- xml
	
	``` 
	 //圆角带边框选择器
	
	 //圆角带边框1
	 <shape xmlns:android="http://schemas.android.com/apk/res/android" >
	 <corners
	  android:bottomLeftRadius="15dp"
	  android:bottomRightRadius="15dp"
	  android:topLeftRadius="15dp"
	  android:topRightRadius="15dp" />
	  <solid android:color="@color/clr_fb720e" />
	  <size
	  android:height="65dp"
	  android:width="180dp" />
	  <stroke
	  android:width="2dp"
	  android:color="@color/clr_f0f0f0" />
	  </shape>
	
	  //圆角带边框2
	  <shape xmlns:android="http://schemas.android.com/apk/res/android" >
	  <corners
	  android:bottomLeftRadius="15dp"
	  android:bottomRightRadius="15dp"
	  android:topLeftRadius="15dp"
	  android:topRightRadius="15dp" />
	  <solid android:color="@color/clr_fb720e" />
	  <size
	     android:height="65dp"
	     android:width="180dp" />
	  <stroke
	     android:width="2dp"
	     android:color="@color/clr_f0f0f0" />
	     </shape>
	 	//选择器
	   <selector xmlns:android="http://schemas.android.com/apk/res/android">
	     <item android:state_pressed="true" android:drawable="@drawable/shape1" />
	     <item android:state_pressed="false" android:drawable="@drawable/shape2" />
	  </selector>
	  
	``` 
   
	- **FSelector**

	 ``` 
	  FSelector.with(tvtext4)
	                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
	                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
	                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_fffcf7))
	                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_fb720e)).create()
	                .bind();
	 ``` 

- 圆角虚线选择器
 	
 	- xml

	```
	  //bg1
	  <shape xmlns:android="http://schemas.android.com/apk/res/android"
	 android:shape="rectangle">
	 <corners android:radius="20dip"/>
	 <solid android:color="#00ff00"/>
	 <stroke
	 android:width="5dip"
	 android:color="#FF4081"
	 android:dashGap="5dip"
	 android:dashWidth="10dip"/>
	 //bg2
	 </shape>
	  <shape xmlns:android="http://schemas.android.com/apk/res/android"
	 android:shape="rectangle">
	 <corners android:radius="20dip"/>
	 <solid android:color="#00ff00"/>
	 <stroke
	 android:width="5dip"
	 android:color="#FF4081"
	 android:dashGap="5dip"
	 android:dashWidth="10dip"/>
	 </shape>
	//选择器
	   <selector xmlns:android="http://schemas.android.com/apk/res/android">
	     <item android:state_pressed="true" android:drawable="@drawable/shape1" />
	     <item android:state_pressed="false" android:drawable="@drawable/shape2" />
	  </selector>
	```


	- **FSelector**

	``` 
  FSelector.with(tvtext5)
                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_cdcdcd))
                .strokeDashWidth(dp2px(10))
                .strokeDashGap(dp2px(5))
                .create()
                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_fffcf7))
                .stokeWidth(dp2px(1))
                .strokeClr(getColors(R.color.clr_fb720e))
                .strokeDashWidth(dp2px(10))
                .strokeDashGap(dp2px(5))
                .create()
                .bind();
	``` 
 
- **自定义背景选择器(xml 无法实现)**
 
 	- 背景带✔️的背景选择器

	``` 
	
	 RightDrawable selectDrawable = new RightDrawable();
	        selectDrawable.setmPantWidth(dp2px(1));
	        FSelector.with(tvtext6)
	                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
	                .strokeDashWidth(dp2px(10))
	                .strokeDashGap(dp2px(5))
	                .stokeWidth(dp2px(3)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
	                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).stateDraw(selectDrawable)
	                .stokeWidth(dp2px(3)).strokeClr(Color.RED).create()
	                .bind();
	``` 

 	 - 任何图片背景生成圆角

	``` 
	 RoundedBitmapDrawable shapeBitmapDrawable=    new RoundedBitmapDrawable();
	        shapeBitmapDrawable.setBitmap(this.getResources(),R.drawable.ic_drawer_setting);
	        FSelector.with(tvtext7)
	                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
	                .stokeWidth(dp2px(5)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
	                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5))
	                .strokeDashWidth(dp2px(10))
	                .strokeDashGap(dp2px(5))
	                .stateDraw(shapeBitmapDrawable)
	                .stokeWidth(dp2px(5)).strokeClr(Color.RED).create()
	                .bind();
                
	``` 
	
	
- 创建一个选择器 Drawable 

```
Drawable drawable= FSelector.with(tvtext4)
                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_fffcf7))
                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_fb720e)).create()
                .build();
```	

### API说明
```	                
  1. with(context or view)    			//context or view,put view to bind 
  2. addDrawable(int type) //根据状态添加 drawable
  
  		WINDOW_FOCUSED(android.R.attr.state_window_focused),//true，当此activity获得焦点在最前面时显示该图片；false，当没在最前面时显示该图片。
        STATE_ENABLED(android.R.attr.state_enabled),//当该组件能使用时显示该图片；false，当该组件不能使用时显示该图片
        STATE_CHECKABLE(android.R.attr.state_checked),//当CheckBox能使用时显示该图片；false，当CheckBox不能使用时显示该图片
        STATE_CHECKED(android.R.attr.state_checked),//true，当CheckBox选中时显示该图片；false，当CheckBox为未选中时显示该图片
        STATE_SELECTED(android.R.attr.state_selected),//true 选择时显示的图片；false 为选择时的图片（例如用在Tab)
        STATE_PRESSED(android.R.attr.state_pressed),//true，当被点击时显示该图片；false没被按下时显示图片 ==click
        STATE_FOCUSED(android.R.attr.state_focused),//获取焦点
        STATE_ACTIVE(android.R.attr.state_active),
        STATE_DRAG_HOVERED(android.R.attr.state_drag_hovered),//true 能够drop 或者 drag 鼠标指针移动到该位置图片
        STATE_DRAG_CAN_ACCEPT(android.R.attr.state_drag_can_accept),//true 能够dorp 或者 drag 时图片
        STATE_ACTIVATED(android.R.attr.state_activated);
        
  3. addDrawable()  						// 添加一个默认的Drawable, 默认状态				 			
  4. circleAngle( px )    					//四个角的圆角大小
  5. topLeftCA(px)							//左上角弧度
  6. topRigthCA(px)							//右上角弧度
  7. btLeftCA(px)							//左下角度
  8. btRightCA(px) 							//右下角
  9. bgColor(color) 						//单个背景的颜色
  10. stokeWidth(px)						//边框宽度
  11. strokeClr(color)						//边框颜色
  12. strokeDashWidth()						//虚线中实线的长度
  13. strokeDashGap()						//虚线间隔的长度
  14. addState(int)  						//添加 drawabe 的状态,与 addDrawable(int type)覆盖互斥
  15. create()                           	//创建一个Drawable放入 shape or selector
  16. build()  								//返回一个Drawable 作为 shape or selector
  17. bind()  								//将返回的Drawable bind 到 view 中
 
```	

## TODO

添加更多的自定义背景

## 作者


-  github: [@chengzichen](https://github.com/chengzichen)


-  博客 : [邓浩宸的博客](https://chengzichen.github.io/)


## 更新日志

- 1.0.0  : 正式版本1
- 1.0.1  : 添加边框虚线

## Flyabbit系列

- [Flyabbit](https://github.com/chengzichen/Flyabbit)  快速实现MVP组件化
- [FMVP](https://github.com/chengzichen/FMVP)  快速实现 mvp
- [component](https://github.com/chengzichen/component)  快速实现 组件化
- [RxBus](https://github.com/chengzichen/Flyabbit)  rxjava 配合使用的时间总线
