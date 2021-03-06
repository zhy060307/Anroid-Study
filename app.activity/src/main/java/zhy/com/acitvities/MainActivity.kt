package zhy.com.acitvities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, Test1Activity::class.java)
        findViewById<Button>(R.id.btn1).setOnClickListener {
            startActivity(intent)
        }
        Log.d(TAG, " OnCreate ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, " onReStart ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, " onStart ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, " onResume ")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, " onPause ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, " onStop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, " onDestroy ")
    }
}
