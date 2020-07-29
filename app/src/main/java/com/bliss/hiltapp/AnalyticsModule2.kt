package com.bliss.hiltapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
/**
* Author: yangtianfu
* Date: 2020/7/29 16:56
 *如果 AnalyticsService 类不直接归您所有 在 Hilt 模块内创建一个函数，并使用 @Provides 为该函数添加注释。
 * 函数返回类型会告知 Hilt 函数提供哪个类型的实例。
 * 函数参数会告知 Hilt 相应类型的依赖项。
 * 函数主体会告知 Hilt 如何提供相应类型的实例。每当需要提供该类型的实例时，Hilt 都会执行函数主体
*/

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule2 {

    @Provides
    fun provideAnalyticsService():AnalyticsService{
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .build()
            .create(AnalyticsService::class.java)
    }
}