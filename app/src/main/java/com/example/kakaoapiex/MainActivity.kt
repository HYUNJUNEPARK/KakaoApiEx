package com.example.kakaoapiex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kakaoapiex.search.address.retrofit.Repository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope.launch {
            Repository.getAddress().let {
                Log.d("testLog", "onCreate: $it")
            }
        }
    }
}