package com.example.kakaoapiex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kakaoapiex.databinding.ActivityMainBinding
import com.example.kakaoapiex.search.address.retrofit.AddressRepository
import com.example.kakaoapiex.search.image.retrofit.ImageRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var binding: ActivityMainBinding
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        testKakaoApi()
    }

    private fun testKakaoApi() {
        launch {
            showProgress()
            AddressRepository.getAddress("전북 삼성동 100").let {
                Log.d("testLog", "AddressRepository : $it")
            }
            ImageRepository.getImage("설현").let {
                Log.d("testLog", "ImageRepository : $it")
            }
            dismissProgress()
        }
    }

    private suspend fun showProgress() = withContext(coroutineContext) {
        binding.progressBar.visibility = View.VISIBLE
    }

    private suspend fun dismissProgress() = withContext(coroutineContext) {
        binding.progressBar.visibility = View.INVISIBLE
    }
}