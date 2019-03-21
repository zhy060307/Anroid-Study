package zhy.com.widget

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.widget.TextView


class FontViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_font_view)

        val typeface = Typeface.createFromAsset(assets, "fonts/DINOT-Bold.ttf")
        val textView1 = findViewById<TextView>(R.id.tv_1)

        textView1.typeface = typeface

        val disStr = "17"
        val unitString = ":"
        val ss = SpannableString(disStr + unitString)
        ss.setSpan(AbsoluteSizeSpan(100, true), 0, disStr.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ss.setSpan(CustomVerticalCenterSpan(this, 100), disStr.length, ss.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        textView1.text = ss
    }
}