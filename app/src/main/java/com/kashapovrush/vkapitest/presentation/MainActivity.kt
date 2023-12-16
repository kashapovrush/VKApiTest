package com.kashapovrush.vkapitest.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kashapovrush.vkapitest.ui.theme.VKApiTestTheme
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vkAuthCallback = object : VKID.AuthCallback {
            override fun onSuccess(accessToken: AccessToken) {
                val token = accessToken.token
                Log.d("MainActivityTest", "onSuccess $token")
            }

            override fun onFail(fail: VKIDAuthFail) {
                when (fail) {
                    is VKIDAuthFail.Canceled -> {
                        Log.d("MainActivityTest", "Canceled ${fail.description}")
                    }
                    else -> {
                        Log.d("MainActivityTest", "Else ${fail.description}")
                    }
                }
            }

        }

        val vkid = VKID(applicationContext)
        VKID.logsEnabled = true
        vkid.authorize(this@MainActivity, vkAuthCallback)
        setContent {
            VKApiTestTheme {

            }
        }
    }
}
