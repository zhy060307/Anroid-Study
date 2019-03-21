package zhy.com.acitvities

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import java.io.DataInputStream
import java.net.ServerSocket
import java.net.Socket

class Test1Activity : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)
        textView = findViewById(R.id.textView)
//        serverThread.start()
    }

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                0 -> {
                    textView.text = msg.obj.toString()

                }
            }
        }
    }

    private val serverThread = object : Thread() {
        override fun run() {
            val serverSocket = ServerSocket(9000)
            var socket: Socket? = null
            while (true) {
                try {
                    socket = serverSocket.accept()
                    val text = DataInputStream(socket.getInputStream()).read()
                    val msg = handler.obtainMessage()
                    msg.what = 0
                    msg.obj = text
                    handler.handleMessage(msg)

                } catch (e: Exception) {
                } finally {
                    socket?.close()
                }


            }
        }
    }
}
