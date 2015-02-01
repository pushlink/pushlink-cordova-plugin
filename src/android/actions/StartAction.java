package com.pushlink.cordova.actions;

import android.content.Context;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

public class StartAction implements PushLinkPluginAction {
  private static final String API_KEY = "apiKey";
  private static final String DEVICE_ID = "deviceId";
  private static final String APP_ICON_ID = "appIconId";

  @Override
  public void execute(Context context, JSONObject arg, CallbackContext callbackContext) throws Exception {
    PushLink.start(context, arg.getInt(APP_ICON_ID), arg.getString(API_KEY), arg.getString(DEVICE_ID));
  }
}