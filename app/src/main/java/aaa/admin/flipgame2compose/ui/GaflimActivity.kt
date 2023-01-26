package aaa.admin.flipgame2compose.ui

import aaa.admin.flipgame2compose.R
import aaa.admin.flipgame2compose.data.Gaflimu
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.ComponentActivity

@Suppress("DEPRECATION")
class GaflimActivity : ComponentActivity() {

    private lateinit var gaflimwv: WebView
    var gaflimfpc: ValueCallback<Array<Uri>>? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaflim)

        gaflimwv = findViewById(R.id.gaflimwv)
        gaflimwv.webViewClient = WebViewClient()

        gaflimwv.webChromeClient = MyChromeClient()
        gaflimwv.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        gaflimwv.isScrollbarFadingEnabled = false

        setSettings()

        val gaflimurl = intent.getStringExtra(Gaflimu.GAFLIMKOR) ?: Gaflimu.GAFLIMDOR

        if (savedInstanceState == null) {
            gaflimwv.post {
                kotlin.run { gaflimwv.loadUrl(gaflimurl) }
            }
        }

        gaflimwv.canGoBack()
        gaflimwv.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                gaflimwv.canGoBack()
            ) {
                gaflimwv.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val gaflimws = gaflimwv.settings
        gaflimws.javaScriptEnabled = true
        gaflimws.loadWithOverviewMode = true
        gaflimws.allowFileAccess = true
        gaflimws.domStorageEnabled = true
        gaflimws.builtInZoomControls = true
        gaflimws.displayZoomControls = false
        gaflimws.useWideViewPort = true
        gaflimws.setSupportZoom(true)
        gaflimws.userAgentString = gaflimws.userAgentString.replace("; wv", "")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        gaflimwv.saveState(outState)
    }

    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            gaflimfpc = filePath
            val gaflimi = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            gaflimi.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(gaflimi, Gaflimu.GAFLIMRC)
            return true
        }

        private var gaflimcv: View? = null
        private var gaflimcvc: CustomViewCallback? = null
        private var gaflimoo = 0
        private var gaflimosuv = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (gaflimcv == null) {
                null
            } else BitmapFactory.decodeResource(
                this@GaflimActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@GaflimActivity.window.decorView as FrameLayout).removeView(gaflimcv)
            gaflimcv = null
            this@GaflimActivity.window.decorView.systemUiVisibility =
                gaflimosuv
            this@GaflimActivity.requestedOrientation = gaflimoo
            gaflimcvc!!.onCustomViewHidden()
            gaflimcvc = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?
        ) {
            if (gaflimcv != null) {
                onHideCustomView()
                return
            }
            gaflimcv = paramView
            gaflimosuv =
                this@GaflimActivity.window.decorView.systemUiVisibility
            gaflimoo = this@GaflimActivity.requestedOrientation!!
            gaflimcvc = paramCustomViewCallback
            (this@GaflimActivity.window.decorView as FrameLayout).addView(
                gaflimcv,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@GaflimActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == Gaflimu.GAFLIMRC) {
            gaflimfpc!!.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode,
                    intent
                )
            )
            gaflimfpc = null
        }
    }

}