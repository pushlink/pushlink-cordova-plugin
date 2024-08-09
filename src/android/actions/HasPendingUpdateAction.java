package com.pushlink.cordova.actions;

import org.apache.cordova.CordovaInterface;

import java.util.Map;
import java.util.HashMap;

import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

public class HasPendingUpdateAction implements PushLinkPluginAction {
  @Override
  public void execute(CordovaInterface cordova, JSONObject arg, CallbackContext callbackContext) throws Exception {
    Boolean hasPendingUpdate = PushLink.hasPendingUpdate();
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("hasPendingUpdate", hasPendingUpdate);

    callbackContext.success(new JSONObject(result));
  }
}
