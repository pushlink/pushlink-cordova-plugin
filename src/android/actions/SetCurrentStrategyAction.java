package com.pushlink.cordova.actions;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;
import com.pushlink.android.StrategyEnum;
import com.pushlink.android.AnnoyingPopUpStrategy;
import com.pushlink.android.FriendlyPopUpStrategy;
import com.pushlink.android.StatusBarStrategy;

public class SetCurrentStrategyAction implements PushLinkPluginAction {
  private static final String STRATEGY = "strategy";
  private static final String PROPERTIES = "properties";

  private static final String REMINDER_TIME = "reminderTimeInSeconds";
  private static final String POPUP_MESSAGE = "popUpMessage";
  private static final String UPDATE_BUTTON = "updateButton";
  private static final String NOT_NOW_BUTTON = "notNowButton";
  private static final String STATUS_BAR_TITLE = "statusBarTitle";
  private static final String STATUS_BAR_DESCRIPTION = "statusBarDescription";

  @Override
  public void execute(CordovaInterface cordova, JSONObject arg, CallbackContext callbackContext) throws Exception {
    String strategyName = arg.getString(STRATEGY);
    JSONObject properties = arg.getJSONObject(PROPERTIES);
    StrategyEnum se = Enum.valueOf(StrategyEnum.class, strategyName);
    PushLink.setCurrentStrategy(se);

    switch(se) {
      case ANNOYING_POPUP:
        AnnoyingPopUpStrategy annoyingPopUpStrategy = (AnnoyingPopUpStrategy) PushLink.getCurrentStrategy();
        if (properties.has(POPUP_MESSAGE)) {
          annoyingPopUpStrategy.setPopUpMessage(properties.getString(POPUP_MESSAGE));
        }

        if (properties.has(UPDATE_BUTTON)) {
          annoyingPopUpStrategy.setUpdateButton(properties.getString(UPDATE_BUTTON));
        }
      break;

      case FRIENDLY_POPUP:
        FriendlyPopUpStrategy friendlyPopUpStrategy = (FriendlyPopUpStrategy) PushLink.getCurrentStrategy();

        if (properties.has(REMINDER_TIME)) {
          friendlyPopUpStrategy.setReminderTimeInSeconds(properties.getInt(REMINDER_TIME));
        }

        if (properties.has(POPUP_MESSAGE)) {
          friendlyPopUpStrategy.setPopUpMessage(properties.getString(POPUP_MESSAGE));
        }

        if (properties.has(UPDATE_BUTTON)) {
          friendlyPopUpStrategy.setUpdateButton(properties.getString(UPDATE_BUTTON));
        }

        if (properties.has(NOT_NOW_BUTTON)) {
          friendlyPopUpStrategy.setNotNowButton(properties.getString(NOT_NOW_BUTTON));
        }
      break;

      case STATUS_BAR:
        StatusBarStrategy statusBarStrategy = (StatusBarStrategy) PushLink.getCurrentStrategy();
        if (properties.has(STATUS_BAR_TITLE)) {
          statusBarStrategy.setStatusBarTitle(properties.getString(STATUS_BAR_TITLE));
        }

        if (properties.has(STATUS_BAR_DESCRIPTION)) {
          statusBarStrategy.setStatusBarDescription(properties.getString(STATUS_BAR_DESCRIPTION));
        }
      break;

      case NINJA:
        // no properties to be set
      break;
    }
    callbackContext.success();
  }
}