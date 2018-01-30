package zhy.com.serialport

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android_serialport_api.SerialPort
import java.io.File
import java.io.InputStream
import java.io.OutputStream

class MainActivity : AppCompatActivity() {

    private var serialPort: SerialPort? = null
    private var inputStream: InputStream? = null
    private var outputStream: OutputStream? = null
    private var index: Int = 0
    private val devComm = "/dev/ttyS0"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_open).setOnClickListener {
            open()
        }

        findViewById<Button>(R.id.btn_send).setOnClickListener {
            send()
        }

        findViewById<Button>(R.id.btn_close).setOnClickListener {
            close()
        }
    }

    private fun open() {
        serialPort = SerialPort(File(devComm), 9600, 0)
        inputStream = serialPort?.inputStream
        outputStream = serialPort?.outputStream
    }

    private fun send() {
        index %= LEDStatus.values().size
        outputStream?.write(LEDStatus.values()[index].hexStringToByteArra())
        index++
    }

    private fun close() {
        serialPort?.close()
        inputStream?.close()
        outputStream?.close()
    }


}
