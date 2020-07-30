package com.bliss.hiltapp

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

/**
* Author: yangtianfu
* Date: 2020/7/30 15:09
* Describe: 使用Provides 提供注入的对象
*/
@Module
@InstallIn(ApplicationComponent::class)
object ProvidesObj {
    private const val TAG = "ProvidesObj"

    @Provides
    fun provideObj(parm:String):OBJProvide{
        Log.e(TAG, "provideObjParm: 每次初始化之前执行此方法 $parm")
        return OBJProvide()
    }

}

//需要拿到的对象
class OBJProvide{
    fun test(){
        Log.e("TAG", "test: OBJProvide 内部方法执行" )
    }
}