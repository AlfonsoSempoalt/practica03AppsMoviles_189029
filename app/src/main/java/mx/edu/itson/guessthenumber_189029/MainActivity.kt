package mx.edu.itson.guessthenumber_189029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var minValue=0
    private var maxValue=100
    private var num:Int=0
    private var won=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button= findViewById(R.id.down)
        val up: Button= findViewById(R.id.up)
        val generate: Button= findViewById(R.id.generate)
        val guessed: Button= findViewById(R.id.guessed)

        generate.setOnClickListener {
            num= Random.nextInt(minValue,maxValue)
            guessings.setText(num.toString())
            generate.visibility= View.INVISIBLE
            guessed.visibility=View.VISIBLE
        }

        up.setOnClickListener {
            minValue=num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else {
                 guessings.setText("it cant be :c you win")
            }
        }

        down.setOnClickListener {
            maxValue=num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            }else {
                guessings.setText("it cant be :c you win")
            }
        }

        guessed.setOnClickListener {
            if(!won){
                guessings.setText("I guess your number "+num)
                guessed.setText("Play again c:")
                won=true
            }else{
                generate.visibility=View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility=View.GONE
                resetValues()
            }
        }
    }

    fun resetValues(){
        minValue=0
        maxValue=100
        num=0
        won=false
    }

    fun checkingLimits():Boolean{
        return minValue!=maxValue
    }
}