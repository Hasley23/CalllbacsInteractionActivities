package com.zebrano.calllbacsinteractionactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.NightMode
import com.zebrano.calllbacsinteractionactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    // 1. Создаем лаунчер в главном активити (для запуска побочного активити и ожидания ответа)
    private var launcher : ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Выключаем темную тему (мешает)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        // 2. Регистрация лаунчера (для получения ActivityResult побочного activity его обработки)
        // здесь описывают колбэк - обработка требуемых действий (выполняет побочное активити)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            // result несет в себе информацию, resultCode, intent и т. д.
            result : ActivityResult ->
            // Если код ОК, то все прошло успешно
            if (result.resultCode == RESULT_OK){
                // получаем значение по ключу и помещаем в требуемое место
                // указываем требуемый тип данных и ключ, указанный в побочном Activity
                binding.textView5.text = result.data?.getStringExtra("key")
            }
        }
    }
    fun onClickButton(view: View) {
        // 3. Запуск лаунчера, который запустит второе активити
        launcher?.launch(Intent(this, MainActivity2::class.java))
    }
}