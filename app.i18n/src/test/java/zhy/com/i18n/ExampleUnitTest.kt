package zhy.com.i18n

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun parseLang() {
        println(Locale.forLanguageTag(Locale.TRADITIONAL_CHINESE.toLanguageTag()))
        println(Locale.forLanguageTag(Locale.ENGLISH.toLanguageTag()))
        println(Locale.forLanguageTag(Locale.SIMPLIFIED_CHINESE.toLanguageTag()))

    }


    fun localeToString(l: Locale): String {
        return l.language + "," + l.country
    }

    fun stringToLocale(s: String): Locale {
        val split = s.split(",")

        return Locale(split[0], split[1])
    }
}
