package com.zebrano.calllbacsinteractionactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.zebrano.calllbacsinteractionactivities.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickButton(view: View){
        // 4. Создаем Intent - класс намерение для описания одной операции
        val i = Intent()
        val str = binding.editText.text
        // 5. Помещаем требуемое значение
        i.putExtra("key", str.toString())
        // 6. Устанавливаем результат активити
        setResult(RESULT_OK, i)
        // 7. завершаем активити для возврата
        finish()
    }
}