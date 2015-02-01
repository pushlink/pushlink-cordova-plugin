package com.pushlink.cordova;

import java.util.Map;
import java.util.HashMap;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.pushlink.android.PushLink;

public class PushLinkPlugin extends CordovaPlugin {
  public static final String START_ACTION = "startPushLink";
  public static final String ADD_EXCEPTION_METADATA = "addExceptionMetadata";
  public static final String ADD_METADATA = "addMetadata";
  public static final String DISABLE_EXCEPTION_NOTIFICATION = "disableExceptionNotification";
  public static final String ENABLE_EXCEPTION_NOTIFICATION = "enableExceptionNotification";
  public static final String SET_CURRENT_STRATEGY = "setCurrentStrategy";
  public static final String GET_CURRENT_STRATEGY = "getCurrentStrategy";
  public static final String HAS_PENDING_UPDATE = "hasPengingUpdate";
  public static final String SET_IDLE = "idle";

  private static final Map<String, PushLinkPluginAction> actions;

  static {
    actions = new HashMap<String, PushLinkPluginAction>();
    actions.put(START_ACTION, new PushLinkStartAction());
    actions.put(ADD_EXCEPTION_METADATA, new PushLinkStartAction());
    actions.put(ADD_METADATA, new PushLinkStartAction());
    actions.put(DISABLE_EXCEPTION_NOTIFICATION, new PushLinkStartAction());
    actions.put(ENABLE_EXCEPTION_NOTIFICATION, new PushLinkStartAction());
    actions.put(SET_CURRENT_STRATEGY, new PushLinkStartAction());
    actions.put(GET_CURRENT_STRATEGY, new PushLinkStartAction());
    actions.put(HAS_PENDING_UPDATE, new PushLinkStartAction());
    actions.put(SET_IDLE, new PushLinkStartAction());
  }

  @Override
  public boolean execute(String action, JSONArray actionArgs, CallbackContext callbackContext) throws JSONException {
    try {
      JSONObject args = actionArgs.getJSONObject(0);

      if (actions.containsKey(action)) {
        PushLinkPluginAction pluginAction = actions.get(action);
        pluginAction.execute(this.cordova.getActivity(), args, callbackContext);
        return true;
      } else {
        callbackContext.error("Invalid action: " + action);
        return false;
      }
    } catch (Exception e) {
      System.err.println("Exception: " + e.getMessage());
      callbackContext.error(e.getMessage());
      return false;
    }
  }
}