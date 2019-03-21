package zhy.com.widget

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ScrollView
import org.kobjects.nativehtml.android.HtmlView

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_html)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val items = ArrayList<String>()
//        items.add("file:///android_asset/html/1.html")
//        items.add("file:///android_asset/html/2.html")
//        items.add("file:///android_asset/html/3.html")
//        items.add("file:///android_asset/html/4.html")
//        items.add("file:///android_asset/html/5.html")
//
//        items.add("file:///android_asset/html/1.html")
//        items.add("file:///android_asset/html/2.html")
//        items.add("file:///android_asset/html/3.html")
//        items.add("file:///android_asset/html/4.html")
//        items.add("file:///android_asset/html/5.html")
//
//
//        items.add("file:///android_asset/html/1.html")
//        items.add("file:///android_asset/html/2.html")
//        items.add("file:///android_asset/html/3.html")
//        items.add("file:///android_asset/html/4.html")
//        items.add("file:///android_asset/html/5.html")
//
//        items.add("file:///android_asset/html/1.html")
//        items.add("file:///android_asset/html/2.html")
//        items.add("file:///android_asset/html/3.html")
//        items.add("file:///android_asset/html/4.html")
//        items.add("file:///android_asset/html/5.html")

        items.add("http://www.baidu.com/?tn=sitehao123_15")
        items.add("http://www.sina.com.cn/")
        items.add("http://www.sohu.com/")
        items.add("http://www.qq.com/")
        items.add("http://www.163.com/")

        items.add("http://www.iqiyi.com/")
        items.add("http://www.ifeng.com/")
        items.add("https://www.taobao.com/")
        items.add("https://union-click.jd.com/jdc?d=iEZf6v")
        items.add("https://www.suning.com/?utm_source=hao123&utm_medium=mingzhan")



        recyclerView.adapter = WebviewAdapter(this, items)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish() // back button
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

class WebviewAdapter(private val context: Context,
                     private val items: ArrayList<String>) : RecyclerView.Adapter<WebviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebviewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.webview_item, parent, false)
        return WebviewHolder(parent.context, view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: WebviewHolder, position: Int) {
        val item = items[position]
        holder.webView.webViewClient = object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                super.shouldOverrideUrlLoading(view, request)
                return true
            }
        }

        holder.webView.loadUrl(item)


    }




}

class WebviewHolder(context: Context, viewItem: View) : RecyclerView.ViewHolder(viewItem) {

    var webView: WebView = viewItem.findViewById(R.id.web_view)


}


