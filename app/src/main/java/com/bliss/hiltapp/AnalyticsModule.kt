package com.bliss.hiltapp

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Hilt 将该依赖项注入 MainActivity。此注释意味着，AnalyticsModule 中的所有依赖项都可以在应用的所有 Activity 中使用。
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {

    //@Binds 注释会告知 Hilt 在需要提供接口的实例时要使用哪种实现。
    //函数返回类型会告知 Hilt 函数提供哪个接口的实例。
    //函数参数会告知 Hilt 要提供哪种实现。
    @Binds
    abstract fun bindAnalyticsService(
        analyticsServiceImpl: AnalyticsServiceImpl
    ):AnalyticsService
}