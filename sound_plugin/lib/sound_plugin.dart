
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:import_sorter/args.dart';
import 'package:import_sorter/files.dart';
import 'package:import_sorter/sort.dart';

class SoundPlugin {
  static const MethodChannel _channel = MethodChannel('sound_plugin');

  // static Future<String?> get platformVersion async {
  //   final String? version = await _channel.invokeMethod('getPlatformVersion');
  //   return version;
  // }

  static Future<dynamic> get _list async{
    final Map params<String, dynamic> {
      'name': 'my name is hoge',
      'age': 25,
    }
    final list<dynamic> list = await _channel.invokeMethod('getList', params);
    // return list;
  }

  Future<dynamic> _platformCallHandler(MethodCall call) {
    switch (call.method)  {
      print('call callMe : arguments = ${call.arguments}');
      return Future.value('called from platform!');

      defalt;
      print('Unknowm method ${call.method}');
      throw MissingPluginException();
      break;

  }
  }

  @override
  initState(){
    super initState();

    _channel.setMethodCallHandler(_platformCallHandler);
  }
}
