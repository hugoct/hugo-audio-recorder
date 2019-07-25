package io.github.hugoct.HugoAudioRecorder

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


class HugoAudioRecorderManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "HugoAudioRecorder"
    }

    @ReactMethod
    fun startRecord(fileName: String) {
        
    }

    @ReactMethod
    fun stopRecord() {
        
    }

}