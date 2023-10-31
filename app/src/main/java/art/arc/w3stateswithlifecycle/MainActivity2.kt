package art.arc.w3stateswithlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity2 : AppCompatActivity() {

    private var l2 : Int = 0
    private lateinit var t1 : EditText
    private lateinit var b3 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        t1 = findViewById(R.id.input)
        b3 = findViewById(R.id.b3)
        b3.setOnClickListener {
            intent.putExtra("liczba2",l2)
            setResult(1111,intent)
            finish()
        }
    }


    override fun onResume() {
        super.onResume()
        val l = intent.getIntExtra("liczba",0)
        Toast.makeText(applicationContext, "Otrzymano: \n ${l}", Toast.LENGTH_LONG).show()
        l2 = intent.getIntExtra("liczba2",0)
        l2 += 200
        t1.setText("${l2}")
    }


}