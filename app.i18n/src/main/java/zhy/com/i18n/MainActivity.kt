package zhy.com.i18n

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnZh: Button
    private lateinit var btnEn: Button
    private lateinit var tvText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnZh = findViewById(R.id.btn_zh)
        btnEn = findViewById(R.id.btn_en)
        tvText = findViewById(R.id.tv_text)

        btnZh.setOnClickListener {
            switchLanguage("zh")
        }
        btnEn.setOnClickListener {
            switchLanguage("en")
        }
    }

    private fun switchLanguage(lang: String) {

        val conf = resources.configuration
        val dm = resources.displayMetrics

        when (lang) {
            "zh" -> conf.locale = Locale.SIMPLIFIED_CHINESE
            "en" -> conf.locale = Locale.ENGLISH
        }
        resources.updateConfiguration(conf, dm)
        recreate()


    }

}