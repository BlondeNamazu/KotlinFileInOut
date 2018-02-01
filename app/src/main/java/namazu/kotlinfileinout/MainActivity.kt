package namazu.kotlinfileinout

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RawRes
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*;
import java.io.*

class MainActivity : AppCompatActivity() {

    private val fileName : String = "testfile.txt";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_save.setOnClickListener({
            val text : String = edit_text.getText().toString()
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
        try {
            val out = openFileOutput(file,Context.MODE_PRIVATE)
            out.write(str.toByteArray())
            out.close()
        } catch (e: IOException){
            e.printStackTrace()
        }
    }

    // read "testfile.txt" and show its content
    public fun readFile(file : String) : String? {
        var text : String = ""
        try{
            val reader = openFileInput(file).bufferedReader()
            for(lineBuffer in reader.readLines()){
                text += lineBuffer.toString()
            }
            reader.close()
        } catch(e:FileNotFoundException){
            e.printStackTrace()
        }
        return text;
    }
}
