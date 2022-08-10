package com.o7services.secondkotlinclass

import android.R.bool
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


class WebviewActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var progressBar: ProgressBar
    lateinit var webViewClient: WebViewClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webView = findViewById(R.id.webView)
        progressBar = findViewById(R.id.progressBar)
        webView.loadUrl("https://o7services.com/")
        webViewClient = WebViewClient()
        webView.webViewClient = webViewClient
        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                Log.e("TAG", "in should override")
                System.out.println("in should override")
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }
        })
        webView.settings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }else
            super.onBackPressed()
    }
}