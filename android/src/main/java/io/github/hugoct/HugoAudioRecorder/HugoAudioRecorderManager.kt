package io.github.hugoct.HugoAudioRecorder

import android.widget.Toast
import android.media.MediaRecorder
import android.media.MediaPlayer
import java.io.File
import java.io.IOException
import android.os.Environment

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback


class HugoAudioRecorderManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    private var recorder: MediaRecorder? = null
    private var player: MediaPlayer? = null
    var path = "${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)}/audiorecordtest.3gp"

    override fun getName(): String {
        return "HugoAudioRecorder"
    }

    @ReactMethod
    fun startRecord(fileName: String, successCallback: Callback, errorCallback: Callback) {
        
        Toast.makeText(getReactApplicationContext(), path, Toast.LENGTH_LONG).show()
        
        try {
            recorder = MediaRecorder().apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(path)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                prepare()
                start()
            }
            successCallback.invoke(true)
        
        } catch (e: IOException) {
            errorCallback.invoke(false)
        }
    }

    @ReactMethod
    fun stopRecord(successCallback: Callback, errorCallback: Callback) {
        Toast.makeText(getReactApplicationContext(), "Stop", Toast.LENGTH_LONG).show()
        
        try {
            recorder?.apply {
                stop()
                release()
            }
            recorder = null
            successCallback.invoke(true);
        } catch (e: IOException) {
            errorCallback.invoke(false);
        }
    }

    @ReactMethod
    fun playRecord(filename: String) {
        Toast.makeText(getReactApplicationContext(), "Plaing...", Toast.LENGTH_LONG).show()
        
        player = MediaPlayer().apply {
            try {
                setDataSource(path)
                prepare()
                start()
            } catch (e: IOException) {
                Toast.makeText(getReactApplicationContext(), "Erro!", Toast.LENGTH_LONG).show()
            }
        }
    }

    @ReactMethod
    fun stopPlayingRecord() {
        Toast.makeText(getReactApplicationContext(), "Stop Plaing", Toast.LENGTH_LONG).show()
        
        player?.release()
        player = null
    }

    @ReactMethod
    fun deleteRecord(fileName: String, successCallback: Callback, errorCallback: Callback) {
        try {
        var file = File(path)
        
        if (file.exists()) {
            file.delete()
        }

        Toast.makeText(getReactApplicationContext(), "Deleted!", Toast.LENGTH_LONG).show()
        successCallback.invoke(true);

        } catch (e: IOException) {
            errorCallback.invoke(false);
        }
        
    }

}