package com.sound_plugin.sound_plugin

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** SoundPlugin */
class SoundPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel

//  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
//    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "sound_plugin")
//    channel.setMethodCallHandler(this)
//  }
//
//  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
//    if (call.method == "getPlatformVersion") {
//      result.success("Android ${android.os.Build.VERSION.RELEASE}")
//    } else {
//      result.notImplemented()
//    }
//  }
//
//  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
//    channel.setMethodCallHandler(null)
//  }

  companion object {
    private const val CHANNEL = "sound_plugin"
    private const val METHOD_GET_LIST = "getList"
  }

  private lateinit var channel: MethodChannel

  override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
    GeneratedPluginRegistrant.registerWith(FlutterEngine)

    channel = MethodChannel(flutterEngine.dartExecutor.binaryMessager, CHANNEL)
    channel.setMethodCallHander { methodCall: MethodCall, result: MethodChannel.Result ->
      if(methodCall.method == METHOD_GET_LIST) {
        val name = methodCall.argument<String>("name").toString()
        val age = methodCall.argument<Int>("age")
        Log.d("Android", "name = ${name}, age = $age")

        val list = listOf("data0", "data1", "data2")
        result.success(list)
      }
      else
        result.notImplemented()
    }
  }
}
