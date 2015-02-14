package com.pushlink.cordova.actions;

import android.content.Context;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

public class DisableExceptionNotificationAction implements PushLinkPluginAction {
  @Override
  public void execute(Context context, JSONObject arg, CallbackContext callbackContext) throws Exception {
    PushLink.disableExceptionNotification();
    callbackContext.success();
  }
}