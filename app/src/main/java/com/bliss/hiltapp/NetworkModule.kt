package com.bliss.hiltapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
//    两种方法具有相同的返回类型，但限定符将它们标记为两个不同的绑定

    @AuthInterceptorOkHttpClient
    @Provides
    fun provideAuthInterceptorOkHttpClient(
        authInterceptor: AuthInterceptor
    ):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @OtherInterceptorOkHttpClient
    @Provides
    fun provideOtherInterceptorOkHttpClient(
        otherInterceptor: OtherInterceptor
    ):OkHttpClient{
        return  OkHttpClient.Builder()
            .addInterceptor(otherInterceptor)
            .build()
    }
}