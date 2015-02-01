package com.pushlink.cordova.actions;

import android.content.Context;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;

public class AddExceptionMetadataAction implements PushLinkPluginAction {
  private static final String KEY = "key";
  private static final String VALUE = "value";

  @Override
  public void execute(Context context, JSONObject arg, CallbackContext callbackContext) throws Exception {
    PushLink.addExceptionMetadata(arg.getString(KEY), arg.getString(VALUE));
  }
}