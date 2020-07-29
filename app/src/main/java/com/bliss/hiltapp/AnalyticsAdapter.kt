package com.bliss.hiltapp

import javax.inject.Inject

/**
 * 向 Hilt 提供绑定信息的一种方法是构造函数注入,
 * 类的构造函数中使用 @Inject 注释，以告知 Hilt 如何提供该类的实例：
 */
class AnalyticsAdapter @Inject constructor(

) {
}