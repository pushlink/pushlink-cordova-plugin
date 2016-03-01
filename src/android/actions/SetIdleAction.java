package com.pushlink.cordova.actions;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

public class SetIdleAction implements PushLinkPluginAction {
  private static final String IDLE = 'idle';

  @Override
  public void execute(CordovaInterface cordova, JSONObject arg, CallbackContext callbackContext) throws Exception {
    PushLink.idle(arg.getBoolean(IDLE));
    callbackContext.success();
  }
}