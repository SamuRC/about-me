package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Samuel Cusi")

    //lateinit var nickNameEdit:EditText
    //lateinit var doneButton:Button
    //lateinit var nickNameText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        //nickNameEdit = findViewById(R.id.nickname_edit)
        //doneButton = findViewById(R.id.done_button)
        //nickNameText = findViewById(R.id.nickname_text)

        //doneButton.setOnClickListener {
            //parameter is button as view
        //    addNickName(it)
        //}

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(it: View) {
        /*nickNameText.text = nickNameEdit.text
        nickNameEdit.visibility = View.GONE
        it.visibility = View.GONE
        nickNameText.visibility = View.VISIBLE*/

        binding.apply {
            //nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            it.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }


}
