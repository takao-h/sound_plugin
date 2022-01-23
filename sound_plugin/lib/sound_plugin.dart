
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:import_sorter/args.dart';
import 'package:import_sorter/files.dart';
import 'package:import_sorter/sort.dart';

class SoundPlugin {
  static const MethodChannel _channel = MethodChannel('sound_plugin');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
