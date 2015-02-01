package com.pushlink.cordova;

import android.content.Context;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

public interface PushLinkPluginAction {
  void execute(Context context, JSONObject arg, CallbackContext callbackContext) throws Exception;
}