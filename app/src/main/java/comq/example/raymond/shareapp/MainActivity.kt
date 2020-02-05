package comq.example.raymond.shareapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_hello.setOnClickListener {
            Log.i("MainActivty","Textview clicked! " )
            Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
        }

        button_send.setOnClickListener {
            val message: String =  edt_message.text.toString()
            //Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)

        }

        button_share_other_apps.setOnClickListener {
            val message: String =  edt_message.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)

            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        button_recycler_view.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
