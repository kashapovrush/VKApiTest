package com.kashapovrush.vkapitest.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kashapovrush.vkapitest.ui.theme.VKApiTestTheme
import com.vk.id.VKID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKApiTestTheme {
                val viewModel: MainViewModel = viewModel()
                val token = viewModel.tokenState.observeAsState()
                val vkAuthCallback = viewModel.getVkAuthCallback()
                val vkid = VKID(this@MainActivity)
                if (token.value != null) {
                    MainScreen()
                } else {
                    vkid.authorize(this@MainActivity, vkAuthCallback)
                }
            }
        }
    }
}