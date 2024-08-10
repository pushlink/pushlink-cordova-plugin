package com.pushlink.cordova;

import java.util.Map;
import java.util.HashMap;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.pushlink.android.PushLink;

import com.pushlink.cordova.actions.PushLinkPluginAction;
import com.pushlink.cordova.actions.StartAction;
import com.pushlink.cordova.actions.AddExceptionMetadataAction;
import com.pushlink.cordova.actions.AddMetadataAction;
import com.pushlink.cordova.actions.DisableExceptionNotificationAction;
import com.pushlink.cordova.actions.EnableExceptionNotificationAction;
import com.pushlink.cordova.actions.SetIdleAction;
import com.pushlink.cordova.actions.SetCurrentStrategyAction;
import com.pushlink.cordova.actions.GetCurrentStrategyAction;
import com.pushlink.cordova.actions.HasPendingUpdateAction;
import com.pushlink.cordova.actions.SetCurrentActivityAction;
import android.util.Log;

public class PushLinkPlugin extends CordovaPlugin {
  private static final String TAG = "PushLinkPlugin";

  public static final String START_ACTION = "start";
  public static final String ADD_EXCEPTION_METADATA = "addExceptionMetadata";
  public static final String ADD_METADATA = "addMetadata";
  public static final String DISABLE_EXCEPTION_NOTIFICATION = "disableExceptionNotification";
  public static final String ENABLE_EXCEPTION_NOTIFICATION = "enableExceptionNotification";
  public static final String SET_CURRENT_STRATEGY = "setCurrentStrategy";
  public static final String GET_CURRENT_STRATEGY = "getCurrentStrategy";
  public static final String SET_CURRENT_ACTIVITY = "setCurrentActivity";
  public static final String HAS_PENDING_UPDATE = "hasPendingUpdate";
  public static final String SET_IDLE = "idle";

  public static final String VERSION = "6.1.0-dev";

  private static final Map<String, PushLinkPluginAction> actions;

  static {
    actions = new HashMap<String, PushLinkPluginAction>();
    actions.put(START_ACTION, new StartAction());
    actions.put(ADD_EXCEPTION_METADATA, new AddExceptionMetadataAction());
    actions.put(ADD_METADATA, new AddMetadataAction());
    actions.put(DISABLE_EXCEPTION_NOTIFICATION, new DisableExceptionNotificationAction());
    actions.put(ENABLE_EXCEPTION_NOTIFICATION, new EnableExceptionNotificationAction());
    actions.put(SET_CURRENT_STRATEGY, new SetCurrentStrategyAction());
    actions.put(GET_CURRENT_STRATEGY, new GetCurrentStrategyAction());
    actions.put(HAS_PENDING_UPDATE, new HasPendingUpdateAction());
    actions.put(SET_IDLE, new SetIdleAction());
    actions.put(SET_CURRENT_ACTIVITY, new SetCurrentActivityAction());
  }

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Log.i(TAG, "initializing plugin v" + VERSION);
  }

  @Override
  public boolean execute(String action, JSONArray actionArgs, CallbackContext callbackContext) throws JSONException {
    try {
      JSONObject args = actionArgs.length() > 0 ? actionArgs.getJSONObject(0) : null;

      if (actions.containsKey(action)) {
        PushLinkPluginAction pluginAction = actions.get(action);
        pluginAction.execute(this.cordova, args, callbackContext);
        return true;
      } else if ("version".equals(action)) {
        JSONObject returnValue = new JSONObject();
        returnValue.put("version", VERSION);
        callbackContext.success(returnValue);
        return true;
      } else {
        callbackContext.error("Invalid action: " + action);
        return false;
      }
    } catch (Exception e) {
      Log.e(TAG, "Exception: " + e.getMessage(), e);
      callbackContext.error(e.getMessage());
      return false;
    }
  }
}
