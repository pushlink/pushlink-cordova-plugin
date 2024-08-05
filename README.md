# PushLink / Cordova plugin [![Build Status](https://github.com/pushlink/pushlink-cordova-plugin/actions/workflows/ci.yml/badge.svg)](https://github.com/pushlink/pushlink-cordova-plugin/actions/workflows/ci.yml)

Source code for https://www.npmjs.com/package/pushlink-cordova-plugin

## Installation

```
$ cordova plugin add pushlink-cordova-plugin
```

## Compatibility Matrix

| pushlink-android | pushlink-cordova-plugin | Comments                                                                                                                                                               |
| ---------------- | ----------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 5.6.0            | 6.1.0                   | [Works on Android 12, 13 and 14](https://docs.pushlink.com/android-versions#android-12-13-and-14). Pushlink strategies are now static (e.g. `Pushlink.FRIENDLY_POPUP`) |
| 5.5.3            | 6.0.3                   | [Works on Android 8](https://pushlink.gitbook.io/docs/android-7-and-8#android-8-oreo). CUSTOM strategy not included.                                                   |
| 5.5.2            | 6.0.2                   | [Works on Android 7](https://pushlink.gitbook.io/docs/android-7-and-8#android-7-nougat). CUSTOM strategy not included.                                                 |
| 5.5.0            | 6.0.1                   | [Fixed for Android 6](https://github.com/pushlink/pushlink-cordova-plugin/issues/10)                                                                                   |
| 5.5.0            | 5.5.0                   | .                                                                                                                                                                      |
| 5.4.4            | 5.4.4                   | .                                                                                                                                                                      |

## Usage

The plugin exposes a global `window.PushLink` object, so there is no need to instantiate an object.

On your main `.js` file, you can call:

```javascript
//this new start API was introduced in pushlink-cordova-plugin-6.0.1

var successCallback = function success() {
  console.log("PushLink started successfully");
};
var errorCallback = function error() {
  console.log("An error occurred.");
};

PushLink.start({
  apiKey: "api-key",
  deviceId: "device-id",
  successCallback: successCallback,
  errorCallback: errorCallback,
});
```

## Troubleshooting

Getting `successCallback` called doesn't mean that all is done. If you don't see your device in the installations tabs of the web administration, maybe there is a misconfiguration or something else.

Use `adb logcat | grep PUSHLINK` to check what's going on. If you can't solve the problem by yourself, please contact the support.

## Help & Support

Always feel free to drop a line to support at pushlink dot com or visit our [support](https://www.pushlink.com/support.xhtml).

Users are always welcome to contribute with [issues](https://github.com/pushlink/pushlink-cordova-plugin/issues) and [pull requests](https://github.com/pushlink/pushlink-cordova-plugin/pulls)
