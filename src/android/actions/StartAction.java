package com.pushlink.cordova.actions;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

import java.lang.reflect.Field;

public class StartAction implements PushLinkPluginAction {
  private static final String API_KEY = "apiKey";
  private static final String DEVICE_ID = "deviceId";
  private static final String PACKAGE_NAME = "packageName";
  private static final String ICON = "icon";

  @Override
  public void execute(final CordovaInterface cordova, JSONObject arg, final CallbackContext callbackContext) throws Exception {
    final String packageName = arg.getString(PACKAGE_NAME);
    final String apiKey = arg.getString(API_KEY);
    final String deviceId = arg.getString(DEVICE_ID);
    final int appIconId = cordova.getActivity().getResources().getIdentifier(ICON, "drawable", packageName);

    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        try {
          PushLink.start(cordova.getActivity(), appIconId, apiKey, deviceId);
          callbackContext.success();
        } catch(Exception e) {
          callbackContext.error(e.getMessage());
        }
      }
    });
  }
}