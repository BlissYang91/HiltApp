package com.bliss.hiltapp

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Qualifier

//用于为 @Binds 或 @Provides 方法添加注释的限定符：@Qualifier
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherInterceptorOkHttpClient

class AuthInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }
}

class OtherInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }
}