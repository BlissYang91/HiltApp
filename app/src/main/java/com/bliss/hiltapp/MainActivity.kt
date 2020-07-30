package com.bliss.hiltapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * 二、在 Application 类中设置了 Hilt 且有了应用级组件后，Hilt 可以为带有 @AndroidEntryPoint 注释的其他 Android 类提供依赖项：
 * Hilt 目前支持以下 Android 类：Application（通过使用 @HiltAndroidApp）  Activity  Fragment   View  Service  BroadcastReceiver
 * 如果您使用 @AndroidEntryPoint 为某个 Android 类添加注释，则还必须为依赖于该类的 Android 类添加注释。例如，如果您为某个 Fragment 添加注释，则还必须为使用该 Fragment 的所有 Activity 添加注释。
 * Hilt 仅支持扩展 ComponentActivity 的 Activity，如 AppCompatActivity。
 * Hilt 仅支持扩展 androidx.Fragment 的 Fragment。Hilt 不支持保留的 Fragment。
 * @AndroidEntryPoint 会为项目中的每个 Android 类生成一个单独的 Hilt 组件。这些组件可以从它们各自的父类接收依赖项
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //从组件获取依赖项，请使用 @Inject 注释执行字段注入
    @Inject lateinit var analytics: AnalyticsAdapter

    @Inject
    lateinit var diTest: DITest//去找它的构造方法实例化对象

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diTest.test()
    }
}