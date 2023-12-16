package com.kashapovrush.vkapitest.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _tokenState = MutableLiveData<String>()
    val tokenState : LiveData<String> = _tokenState


    fun getVkAuthCallback(): VKID.AuthCallback {
        return object : VKID.AuthCallback {
            override fun onSuccess(accessToken: AccessToken) {
                _tokenState.value = accessToken.token
            }

            override fun onFail(fail: VKIDAuthFail) {
                when (fail) {
                    is VKIDAuthFail.Canceled -> {
                    }
                    else -> {
                    }
                }
            }
        }
    }

//    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
//    val authState: LiveData<AuthState> = _authState
//
//    init {
//        val storage = VKPreferencesKeyValueStorage(application)
//        val token = VKAccessToken.restore(storage)
//        val loggedIn = token != null && token.isValid
//        _authState.value = if (loggedIn) AuthState.Authorized else AuthState.NotAuthorized
//    }
//
//    fun performAuthResult(result: VKAuthenticationResult) {
//        if (result is VKAuthenticationResult.Success) {
//            _authState.value = AuthState.Authorized
//        } else {
//            _authState.value = AuthState.NotAuthorized
//        }
//    }
}
