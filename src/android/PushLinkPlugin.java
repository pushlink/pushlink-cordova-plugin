package com.pushlink.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.pushlink.android.PushLink;

public class PushLinkPlugin extends CordovaPlugin {
	public static final String START_ACTION = "startPushLink";

	private static final String API_KEY = "apiKey";
	private static final String DEVICE_ID = "deviceId";
	private static final String APP_ICON_ID = "appIconId";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (START_ACTION.equals(action)) {
				JSONObject args = args.getJSONObject(0);

				PushLink.start(this.cordova.getActivity(), args.getInt(APP_ICON_ID), 
					args.getString(API_KEY), args.getString(DEVICE_ID));
				return true;
			}

			callbackContext.error("Invalid action: " + action);
			return false;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}

	}
}