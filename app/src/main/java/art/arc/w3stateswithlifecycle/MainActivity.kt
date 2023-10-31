package art.arc.w3stateswithlifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var text : TextView
    private lateinit var button : Button
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("LIVECYCLE", "onCreate")

        text = findViewById(R.id.t1)
        button = findViewById(R.id.b1)
        button.setOnClickListener {
            text.text = Date().toString()
            val go2Activit2 = Intent(applicationContext, MainActivity2::class.java)
            go2Activit2.putExtra("liczba", 100)
            startActivity(go2Activit2)
        }

        text.text = savedInstanceState?.getString("STATE1")

        sharedPref = applicationContext?.getSharedPreferences("SHPref1", Context.MODE_PRIVATE)?:return
        text.text = sharedPref!!.getString("STATE1", "")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIVECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIVECYCLE", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIVECYCLE", "onStop")
        with(sharedPref?.edit()?:return) {
            putString("STATE1", text.text.toString())
            apply()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIVECYCLE", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIVECYCLE", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i("LIVECYCLE", "onSaveInstanceState")
        outState.run {
            putString("STATE1", text.text.toString())
        }
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.i("LIVECYCLE", "onRestoreInstanceState")
        if (savedInstanceState != null) {
            text.setText(savedInstanceState.getString("STATE1").toString())
        }
    }
}