package art.arc.w3stateswithlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }


    override fun onResume() {
        super.onResume()
        val l = intent.getIntExtra("liczba",0)
        Toast.makeText(applicationContext, "Otrzymano: \n ${l}", Toast.LENGTH_LONG).show()
    }
}