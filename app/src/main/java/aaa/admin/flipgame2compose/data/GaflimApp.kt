package aaa.admin.flipgame2compose.data

import aaa.admin.flipgame2compose.data.Gaflimu.GAFLIMAF
import aaa.admin.flipgame2compose.data.Gaflimu.GAFLIMOS
import android.app.Application
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal

class GaflimApp : Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(GAFLIMOS)
        AppsFlyerLib.getInstance().init(GAFLIMAF, object :
            AppsFlyerConversionListener {
            override fun onConversionDataSuccess(p0: MutableMap<String, Any>?) {}
            override fun onConversionDataFail(p0: String?) {}
            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
            override fun onAttributionFailure(p0: String?) {}
        }, this)
        AppsFlyerLib.getInstance().start(this)
    }
}