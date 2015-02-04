package com.pushlink.cordova.actions;

import android.content.Context;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

import java.lang.reflect.Field;

public class StartAction implements PushLinkPluginAction {
  private static final String API_KEY = "apiKey";
  private static final String DEVICE_ID = "deviceId";
  private static final String PACKAGE_NAME = "packageName";

  @Override
  public void execute(Context context, JSONObject arg, CallbackContext callbackContext) throws Exception {
    String packageName = arg.getString(PACKAGE_NAME);
    Class<?> resourceClass = Class.forName(packageName + ".R.drawable");
    Field f = resourceClass.getField("icon");

    int appIconId = f.getInt(null);

    PushLink.start(context, appIconId, arg.getString(API_KEY), arg.getString(DEVICE_ID));
  }
}