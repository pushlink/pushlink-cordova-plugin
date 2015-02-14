package com.pushlink.cordova.actions;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

public interface PushLinkPluginAction {
  void execute(CordovaInterface cordova, JSONObject arg, CallbackContext callbackContext) throws Exception;
}