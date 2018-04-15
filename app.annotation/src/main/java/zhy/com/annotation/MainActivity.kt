package zhy.com.annotation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<Button>(R.id.btn_login)
        loginBtn.setOnClickListener {
            doLogin()
        }

    }

    private fun doLogin() {
        val clazz = IUserService::class.java
        val proxyInstance = Proxy.newProxyInstance(clazz.classLoader, arrayOf(clazz), { proxy, method, args ->
            val reqType = method.getAnnotation(ReqType::class.java)
            Log.d(TAG, "reqType = ${reqType.reqType.name}")

            val reqUrl = method.getAnnotation(ReqUrl::class.java)
            Log.d(TAG, "reqUrl = ${reqUrl.value}")



            val result = "login"
            result
        }) as IUserService

        proxyInstance.login("zhangsan", "111111")
    }


}
