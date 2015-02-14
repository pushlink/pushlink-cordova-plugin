package com.pushlink.cordova.actions;

import java.util.Map;
import java.util.HashMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.cordova.CordovaInterface;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.json.JSONObject;

import com.pushlink.android.PushLink;
import com.pushlink.android.Strategy;
import com.pushlink.android.StrategyEnum;
import com.pushlink.android.AnnoyingPopUpStrategy; 
import com.pushlink.android.FriendlyPopUpStrategy; 
import com.pushlink.android.NinjaStrategy; 
import com.pushlink.android.StatusBarStrategy;

public class GetCurrentStrategyAction implements PushLinkPluginAction {
  @Override
  public void execute(CordovaInterface cordova, JSONObject arg, CallbackContext callbackContext) throws Exception {
    Strategy strategy = PushLink.getCurrentStrategy();
    Map<String, Object> properties = beanToMap(strategy);

    if (strategy instanceof AnnoyingPopUpStrategy) {
      properties.put("type", StrategyEnum.ANNOYING_POPUP.name());
    } else if (strategy instanceof FriendlyPopUpStrategy) {
      properties.put("type", StrategyEnum.FRIENDLY_POPUP.name());
    } else if (strategy instanceof NinjaStrategy) {
      properties.put("type", StrategyEnum.NINJA.name());
    } else if (strategy instanceof StatusBarStrategy) {
      properties.put("type", StrategyEnum.STATUS_BAR.name());
    } else {
      throw new IllegalStateException("Unknown strategy");
    }

    JSONObject returnValue = new JSONObject(properties);
    callbackContext.success(returnValue);
  }

  private Map<String, Object> beanToMap(Object bean) throws SecurityException, IllegalAccessException {
    Map<String, Object> map = new HashMap<String, Object>();

    Method[] methods = bean.getClass().getMethods();
    for (Method m : methods) {
      if (m.getName().startsWith("get") && m.getParameterTypes().length == 0 && !m.isVarArgs()) {
        try {
          map.put(m.getName(), m.invoke(bean));
        } catch (InvocationTargetException e) {
          Log.e("PushLink|GetCurrentStrategyAction", "Exception trying to invoke method " + m.getName(), e);
        }
      }
    }

    return map;
  }
}