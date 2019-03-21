package zhy.com.widget

import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RelativeLayout
import zhy.com.widget.model.Card

class CardLayoutActivity : AppCompatActivity() {


    private var cards = ArrayList<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_layout)

        val p = Point()
        windowManager.defaultDisplay.getRealSize(p)
        val width = p.x
        val height = p.y

        val itemWidth = width / 3
        val itemHeight = height / 3

        val containerView = findViewById<RelativeLayout>(R.id.fl_container)



        cards.add(Card(0, 0, 1, 1))
        cards.add(Card(1, 0, 1, 1))
        cards.add(Card(2, 0, 1, 3))
        cards.add(Card(0, 1, 2, 2))


        cards.forEach {
            val item = layoutInflater.inflate(R.layout.item_card, null)

            val params = RelativeLayout.LayoutParams(itemWidth * it.w, itemHeight * it.h)
            params.leftMargin = itemWidth * it.x
            params.topMargin = itemHeight * it.y

            item.layoutParams = params


            containerView.addView(item)

        }
    }
}