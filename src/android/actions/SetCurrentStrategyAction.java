package com.pushlink.cordova.actions;

import android.content.Context;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;
import com.pushlink.android.StrategyEnum;

public class SetCurrentStrategyAction implements PushLinkPluginAction {
  private static final String STRATEGY = "strategy";

  @Override
  public void execute(Context context, JSONObject arg, CallbackContext callbackContext) throws Exception {
    String strategy = arg.getString(STRATEGY);
    PushLink.setCurrentStrategy(Enum.valueOf(StrategyEnum.class, strategy));
  }
}