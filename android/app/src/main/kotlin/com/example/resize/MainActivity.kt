package com.example.resize

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.platform.PlatformViewRegistry

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
    super.configureFlutterEngine(flutterEngine)
    val registry = flutterEngine.getPlatformViewsController().getRegistry();
    registry.registerViewFactory("static-text-view", StaticTextViewFactory())
  }
}