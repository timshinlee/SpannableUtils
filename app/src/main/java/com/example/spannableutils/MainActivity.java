package com.example.spannableutils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.timshinlee.spannableutils.SpannableUtils;

public class MainActivity extends AppCompatActivity {
    String source = "超链接\n电话\n 短信，" +
            " 背景色， 字体颜色\n正常、  粗体、 斜体、" +
            " 粗斜体\n下划线、 删除线\n上标、 下标\n" +
            " 点击事件\nmonospace、 serif、 sans-serif\n" +
            "设置字体大小、 设置字体相对大小，\n正常宽度，水平拉伸，\n引用";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView) findViewById(R.id.text);
        ;
        final SpannableString spannable = getSpannable(text);

        text.setText(spannable);
    }

    private SpannableString getSpannable(TextView text) {
        return SpannableUtils.builder(source)
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
    }
}
