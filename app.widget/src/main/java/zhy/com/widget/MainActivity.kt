package zhy.com.widget

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.skydoves.colorpickerpreference.ColorPickerDialog


class MainActivity : AppCompatActivity() {
    lateinit var rootView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootView = findViewById(R.id.content_view)
        findViewById<TextView>(R.id.tv_colorPicker).setOnClickListener {
            val builder = ColorPickerDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK)
            builder.setTitle("ColorPicker Dialog")
            builder.setPreferenceName("MyColorPickerDialog")
            builder.setFlagView(CustomFlag(this, R.layout.layout_flag))
            builder.setPositiveButton(getString(R.string.confirm)) { colorEnvelope ->
                println(colorEnvelope.colorHtml)

                rootView.setBackgroundColor(colorEnvelope.color)

            }
            builder.setNegativeButton(getString(R.string.cancel)) { dialogInterface, i -> dialogInterface.dismiss() }
            builder.show()
        }
    }
}
