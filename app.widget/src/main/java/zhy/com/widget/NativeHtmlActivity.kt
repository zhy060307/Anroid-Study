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
import android.widget.ScrollView
import org.kobjects.nativehtml.android.HtmlView

class NativeHtmlActivity : AppCompatActivity() {

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
        items.add("1.html")
        items.add("2.html")
        items.add("3.html")
        items.add("4.html")
        items.add("5.html")

        items.add("1.html")
        items.add("2.html")
        items.add("3.html")
        items.add("4.html")
        items.add("5.html")

        items.add("1.html")
        items.add("2.html")
        items.add("3.html")
        items.add("4.html")
        items.add("5.html")

        items.add("1.html")
        items.add("2.html")
        items.add("3.html")
        items.add("4.html")
        items.add("5.html")


        recyclerView.adapter = WidgetAdapter(this, items)
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

class WidgetAdapter(private val context: Context,
                    private val items: ArrayList<String>) : RecyclerView.Adapter<WidgetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.wiget_item, parent, false)
        return WidgetViewHolder(parent.context, view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: WidgetViewHolder, position: Int) {
        val item = items[position]
        val indexUrl = MainActivity::class.java.getResource("/$item").toURI()
        var prefix = indexUrl.toString()
        val cut = prefix.lastIndexOf('/')
        prefix = prefix.substring(0, cut + 1)

        holder.htmlView.addInternalLinkPrefix(prefix)
        holder.htmlView.loadHtml(indexUrl)

    }


}

class WidgetViewHolder(context: Context, viewItem: View) : RecyclerView.ViewHolder(viewItem) {

    var scrollView: ScrollView = viewItem.findViewById(R.id.scroll_view)
    var htmlView: HtmlView = HtmlView(context)

    init {
        scrollView.addView(htmlView)
    }

}


