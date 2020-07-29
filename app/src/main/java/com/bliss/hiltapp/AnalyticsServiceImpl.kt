package com.bliss.hiltapp

import javax.inject.Inject

// Constructor-injected, because Hilt needs to know how to
// provide instances of AnalyticsServiceImpl, too.
class AnalyticsServiceImpl @Inject constructor(

) : AnalyticsService {
    override fun analyticsMethods() {

    }
}