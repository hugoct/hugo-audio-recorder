package io.github.hugoct.HugoAudioRecorder

import android.widget.Toast

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


class HugoAudioRecorderManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "HugoAudioRecorder"
    }

    @ReactMethod
    fun startRecord(fileName: String) {
        Toast.makeText(getReactApplicationContext(), "Start", Toast.LENGTH_LONG).show()
    }

    @ReactMethod
    fun stopRecord() {
        Toast.makeText(getReactApplicationContext(), "Stop", Toast.LENGTH_LONG).show()
        
    }

}