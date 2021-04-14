package kg.tutorialapp.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.lang.Exception
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1 = findViewById<TextView>(R.id.textView)
        val text2 = findViewById<TextView>(R.id.textView2)

        val bracket1 = findViewById<TextView>(R.id.btn_2)
        val bracket2 = findViewById<TextView>(R.id.btn_3)
        val division = findViewById<TextView>(R.id.btn_4)
        val multi = findViewById<TextView>(R.id.btn_8)
        val plus = findViewById<TextView>(R.id.btn_12)
        val minus = findViewById<TextView>(R.id.btn_16)
        val result = findViewById<TextView>(R.id.btn_20)
        val reset = findViewById<TextView>(R.id.btn_1)
        val back = findViewById<TextView>(R.id.btn_19)
        val float1 = findViewById<TextView>(R.id.btn_17)

        val zero = findViewById<TextView>(R.id.btn_18)
        val one = findViewById<TextView>(R.id.btn_13)
        val two = findViewById<TextView>(R.id.btn_14)
        val three = findViewById<TextView>(R.id.btn_15)
        val four = findViewById<TextView>(R.id.btn_9)
        val five = findViewById<TextView>(R.id.btn_10)
        val six = findViewById<TextView>(R.id.btn_11)
        val seven = findViewById<TextView>(R.id.btn_5)
        val eight = findViewById<TextView>(R.id.btn_6)
        val nine = findViewById<TextView>(R.id.btn_7)

        fun addText(str: String){
            text1.append(str)
        }

        zero.setOnClickListener {
            addText("0")
        }
        one.setOnClickListener {
            addText("1")
        }
        two.setOnClickListener {
            addText("2")
        }
        three.setOnClickListener {
            addText("3")
        }
        four.setOnClickListener {
            addText("4")
        }
        five.setOnClickListener {
            addText("5")
        }
        six.setOnClickListener {
            addText("6")
        }
        seven.setOnClickListener {
            addText("7")
        }
        eight.setOnClickListener {
            addText("8")
        }
        nine.setOnClickListener {
            addText("9")
        }
        bracket1.setOnClickListener {
            addText("(")
        }
        bracket2.setOnClickListener {
            addText(")")
        }
        division.setOnClickListener {
            addText("/")
        }
        multi.setOnClickListener {
            addText("*")
        }
        plus.setOnClickListener {
            addText("+")
        }
        minus.setOnClickListener {
            addText("-")
        }
        float1.setOnClickListener {
            addText(".")
        }
        reset.setOnClickListener {
            text1.text = ""
            text2.text = ""
        }
        back.setOnClickListener {
            val str = text1.text.toString()
            if (str.isNotEmpty()){
                text1.text = str.substring(0, str.length - 1)
                text2.text = ""
            }
        }
        result.setOnClickListener {
            try {
                val exp = ExpressionBuilder(text1.text.toString()).build()
                val res = exp.evaluate()
                val long = res.toLong()
                if (res == long.toDouble())
                    text2.text = long.toString()
                else
                    text2.text = res.toString()
            }
            catch (e: Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }
}




