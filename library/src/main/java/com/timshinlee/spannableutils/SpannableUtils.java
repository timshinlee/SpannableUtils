package com.timshinlee.spannableutils;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

@SuppressWarnings("unused")
public class SpannableUtils {
    private static SpannableString sSpannable;
    private static SpannableUtils sInstance;

    private SpannableUtils() {
    }

    public static SpannableUtils builder(String source) {
        if (sInstance == null) {
            sInstance = new SpannableUtils();
        }
        sSpannable = new SpannableString(source);
        return sInstance;
    }

    public SpannableString build() {
        return sSpannable;
    }

    private SpannableUtils setSpan(Object span, int includedStart, int excludedEnd) {
        sSpannable.setSpan(span, includedStart, excludedEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    private SpannableUtils setSpan(Object span, String target) {
        final int index = new SpannableString(sSpannable).toString().indexOf(target);
        if (index != -1) {
            sSpannable.setSpan(span, index, index + target.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return this;
    }

    public SpannableUtils setUrl(TextView textView, String url, int includedStart, int excludedEnd) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return setSpan(new URLSpan(url), includedStart, excludedEnd);
    }

    public SpannableUtils setUrl(TextView textView, String url, String target) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return setSpan(new URLSpan(url), target);
    }

    /**
     * 点击跳转拨号界面
     */
    public SpannableUtils setDial(TextView textView, String phoneNumber, int includedStart, int excludedEnd) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return setSpan(new URLSpan("tel:" + phoneNumber), includedStart, excludedEnd);
    }

    public SpannableUtils setDial(TextView textView, String phoneNumber, String target) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return setSpan(new URLSpan("tel:" + phoneNumber), target);
    }

    /**
     * 点击跳转发送短信界面
     */
    public SpannableUtils setSMS(TextView textView, String mobile, int includedStart, int excludedEnd) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return setSpan(new URLSpan("sms:" + mobile), includedStart, excludedEnd);
    }

    public SpannableUtils setSMS(TextView textView, String mobile, String target) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return setSpan(new URLSpan("sms:" + mobile), target);
    }

    public SpannableUtils setBackgroundColor(int color, int includedStart, int excludedEnd) {
        return setSpan(new BackgroundColorSpan(color), includedStart, excludedEnd);
    }

    public SpannableUtils setBackgroundColor(int color, String target) {
        return setSpan(new BackgroundColorSpan(color), target);
    }

    public SpannableUtils setColor(int color, int includedStart, int excludedEnd) {
        return setSpan(new ForegroundColorSpan(color), includedStart, excludedEnd);
    }

    public SpannableUtils setColor(int color, String target) {
        return setSpan(new ForegroundColorSpan(color), target);
    }

    /**
     * 设置大小
     *
     * @param dip 是否以dip为单位
     */

    public SpannableUtils setSize(int textSize, boolean dip, int includedStart, int excludedEnd) {
        return setSpan(new AbsoluteSizeSpan(textSize, dip), includedStart, excludedEnd);
    }

    public SpannableUtils setSize(int textSize, boolean dip, String target) {
        return setSpan(new AbsoluteSizeSpan(textSize, dip), target);
    }

    /**
     * 设置大小
     *
     * @param scale 相对默认字体大小的倍数
     */
    public SpannableUtils setRelativeSize(float scale, int includedStart, int excludedEnd) {
        return setSpan(new RelativeSizeSpan(scale), includedStart, excludedEnd);
    }

    public SpannableUtils setRelativeSize(float scale, String target) {
        return setSpan(new RelativeSizeSpan(scale), target);
    }

    public SpannableUtils setFontNormal(int includedStart, int excludedEnd) {
        return setSpan(new StyleSpan(Typeface.NORMAL), includedStart, excludedEnd);
    }

    public SpannableUtils setFontNormal(String target) {
        return setSpan(new StyleSpan(Typeface.NORMAL), target);
    }

    public SpannableUtils setBold(int includedStart, int excludedEnd) {
        return setSpan(new StyleSpan(Typeface.BOLD), includedStart, excludedEnd);
    }

    public SpannableUtils setBold(String target) {
        return setSpan(new StyleSpan(Typeface.BOLD), target);
    }

    public SpannableUtils setItalic(int includedStart, int excludedEnd) {
        return setSpan(new StyleSpan(Typeface.ITALIC), includedStart, excludedEnd);
    }

    public SpannableUtils setItalic(String target) {
        return setSpan(new StyleSpan(Typeface.ITALIC), target);
    }

    public SpannableUtils setBoldItalic(int includedStart, int excludedEnd) {
        return setSpan(new StyleSpan(Typeface.BOLD_ITALIC), includedStart, excludedEnd);
    }

    public SpannableUtils setBoldItalic(String target) {
        return setSpan(new StyleSpan(Typeface.BOLD_ITALIC), target);
    }

    public SpannableUtils setMonospace(int includedStart, int excludedEnd) {
        return setSpan(new TypefaceSpan("monospace"), includedStart, excludedEnd);
    }

    public SpannableUtils setMonospace(String target) {
        return setSpan(new TypefaceSpan("monospace"), target);
    }

    public SpannableUtils setSerif(int includedStart, int excludedEnd) {
        return setSpan(new TypefaceSpan("serif"), includedStart, excludedEnd);
    }

    public SpannableUtils setSerif(String target) {
        return setSpan(new TypefaceSpan("serif"), target);
    }

    public SpannableUtils setSansSerif(int includedStart, int excludedEnd) {
        return setSpan(new TypefaceSpan("sans-serif"), includedStart, excludedEnd);
    }

    public SpannableUtils setSansSerif(String target) {
        return setSpan(new TypefaceSpan("sans-serif"), target);
    }

    /**
     * 下划线
     */
    public SpannableUtils setUnderline(int includedStart, int excludedEnd) {
        return setSpan(new UnderlineSpan(), includedStart, excludedEnd);
    }

    public SpannableUtils setUnderline(String target) {
        return setSpan(new UnderlineSpan(), target);
    }

    /**
     * 删除线
     */
    public SpannableUtils setStrikeThrough(int includedStart, int excludedEnd) {
        return setSpan(new StrikethroughSpan(), includedStart, excludedEnd);
    }

    public SpannableUtils setStrikeThrough(String target) {
        return setSpan(new StrikethroughSpan(), target);
    }

    /**
     * 设置下标
     */
    public SpannableUtils setSubscript(int includedStart, int excludedEnd) {
        return setSpan(new SubscriptSpan(), includedStart, excludedEnd);
    }

    public SpannableUtils setSubscript(String target) {
        return setSpan(new SubscriptSpan(), target);
    }

    /**
     * 设置上标
     */
    public SpannableUtils setSuperscript(int includedStart, int excludedEnd) {
        return setSpan(new SuperscriptSpan(), includedStart, excludedEnd);
    }

    public SpannableUtils setSuperscript(String target) {
        return setSpan(new SuperscriptSpan(), target);
    }

    public SpannableUtils setClickable(ClickableSpan clickable, int includedStart, int excludedEnd) {
        return setSpan(clickable, includedStart, excludedEnd);
    }

    public SpannableUtils setClickable(ClickableSpan clickable, String target) {
        return setSpan(clickable, target);
    }

    public SpannableUtils setScaleX(float scaleX, int includedStart, int excludedEnd) {
        return setSpan(new ScaleXSpan(scaleX), includedStart, excludedEnd);
    }

    public SpannableUtils setScaleX(float scaleX, String target) {
        return setSpan(new ScaleXSpan(scaleX), target);
    }

    public SpannableUtils setQuote(int color, int includedStart, int excludedEnd) {
        return setSpan(new QuoteSpan(color), includedStart, excludedEnd);
    }

    public SpannableUtils setQuote(int color, String target) {
        return setSpan(new QuoteSpan(color), target);
    }

    public SpannableUtils setBullet(int bulletColor, int includedStart, int excludedEnd) {
        return setSpan(new BulletSpan(BulletSpan.STANDARD_GAP_WIDTH, bulletColor), includedStart, excludedEnd);
    }

    public SpannableUtils setBullet(int bulletColor, String target) {
        return setSpan(new BulletSpan(BulletSpan.STANDARD_GAP_WIDTH, bulletColor), target);
    }
}
