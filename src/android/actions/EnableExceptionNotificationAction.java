package com.pushlink.cordova.actions;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

public class EnableExceptionNotificationAction implements PushLinkPluginAction {
  @Override
  public void execute(CordovaInterface cordova, JSONObject arg, CallbackContext callbackContext) throws Exception {
    PushLink.enableExceptionNotification();
    callbackContext.success();
  }
}