package namazu.kotlinfileinout

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    private val fileName : String = "testfile.txt";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_save.setOnClickListener({
            var text : String = edit_text.getText().toString()
            saveFile(fileName,text)
            if(text.length == 0){
                text_view.setText(R.string.no_text)
            } else {
                text_view.setText(R.string.saved)
            }
        })

        button_read.setOnClickListener({
            var str : String? = readFile(fileName)
            if(str != null){
                text_view.setText(str)
            } else {
                text_view.setText(R.string.read_error)
            }
        })
    }

    // save written string to "testfile.txt"
    public fun saveFile(file : String,str : String){
        var fileOutputstream : FileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
        fileOutputstream?.write(str.toByteArray())
    }

    // read "testfile.txt" and show its content
    public fun readFile(file : String) : String? {
        var text : String? = null;
        val fileInputStream : FileInputStream? = openFileInput(file)
        if(fileInputStream == null)Log.d("mydebug","fileInputStream is null")
        val reader : BufferedReader = BufferedReader(InputStreamReader(fileInputStream,"UTF-8"))
        if(reader == null)Log.d("mydebug","reader is null")
        var lineBuffer : String? = null;
        do {
            lineBuffer = reader?.readLine()
            if(lineBuffer != null)text = lineBuffer;
        } while(lineBuffer != null)

        return text;
    }
}
