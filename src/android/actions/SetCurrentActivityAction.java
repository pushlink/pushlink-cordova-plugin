package com.pushlink.cordova.actions;

import android.util.Log;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

public class SetCurrentActivityAction implements PushLinkPluginAction  {
  private static final String TAG = 'PushLinkPlugin|SetCurrentActivityAction';

  @Override
  public void execute(CordovaInterface cordova, JSONObject arg, CallbackContext callbackContext) throws Exception {
    Log.i(TAG, 'Setting PushLink currentActivity after resume');
    PushLink.setCurrentActivity(cordova.getActivity());
    callbackContext.success();
  }
}