# SpannableUtils
a library encapuslating the usage of SpannableString in the form of builder pattern.
## import
in the build gradle of the root project 
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
in the build gradle of the module
```
dependencies {
	compile 'com.github.timshinlee:SpannableUtils:1.0.0'
}
```
## usage
```
SpannableString spannable = SpannableUtils.builder(source)
                    .setUrl(text, "http://www.baidu.com", 0, 3)
                    .setColor(Color.BLUE, "超链接")
                    .setDial(text, "10086", "电话")
                    .setSMS(text, "10000", "短信")
                    .setBackgroundColor(Color.GREEN, "背景色")
                    .setColor(Color.BLUE, "字体颜色")
                    .setFontNormal("正常")
                    .setBold("粗体")
                    .setItalic("斜体")
                    .setBoldItalic("粗斜体")
                    .setUnderline("下划线")
                    .setStrikeThrough("删除线")
                    .setSubscript("下标")
                    .setSuperscript("上标")
                    .setClickable(new ClickableSpan() {
                        @Override
                        public void onClick(View widget) {
                            Toast.makeText(MainActivity.this, "onclick", Toast.LENGTH_SHORT).show();
                        }
                    }, "点击事件")
                    .setMonospace("monospace")
                    .setSerif("serif")
                    .setSansSerif("sans-serif")
                    .setSize(16, true, "设置字体大小")
                    .setRelativeSize(1.5f, "设置字体相对大小")
                    .setScaleX(1.5f, "水平拉伸")
                    .setQuote(Color.MAGENTA, "引用")
                    .build();
```
## screen capture
![](https://github.com/timshinlee/SpannableUtils/blob/master/screenshots/screenshot1.png)
