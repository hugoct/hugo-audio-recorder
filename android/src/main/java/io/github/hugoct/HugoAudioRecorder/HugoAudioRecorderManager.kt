package io.github.hugoct.HugoAudioRecorder

import android.widget.Toast
import android.media.MediaRecorder
import java.io.IOException

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


class HugoAudioRecorderManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    var recorder: MediaRecorder? = null

    override fun getName(): String {
        return "HugoAudioRecorder"
    }

    @ReactMethod
    fun startRecord(fileName: String) {
        Toast.makeText(getReactApplicationContext(), "Gravando...", Toast.LENGTH_LONG).show()
        

        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile("${externalCacheDir.absolutePath}/audiorecordtest.3gp")
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                prepare()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
                Toast.makeText(getReactApplicationContext(), "Erro!", Toast.LENGTH_LONG).show()
            }

            start()
        }
    }

    @ReactMethod
    fun stopRecord() {
        Toast.makeText(getReactApplicationContext(), "Stop", Toast.LENGTH_LONG).show()
        
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
    }

}