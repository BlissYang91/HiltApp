package com.bliss.hiltapp

import android.util.Log
import android.widget.Toast
import javax.inject.Inject

class DITest @Inject constructor() {
    fun test(){
        Log.e(TAG, "test: hilt依赖注入方法执行")
    }

    companion object {
        private const val TAG = "DITest"
    }
}