# PushLink - PhoneGap / Cordova plugin [![Circle CI](https://circleci.com/gh/pushlink/pushlink-phonegap/tree/master.svg?style=svg&circle-token=bb31d76d18c780f6594f35a72d0a3e586914f176)](https://circleci.com/gh/pushlink/pushlink-phonegap/tree/master)

## Installation

```
$ phonegap plugin add pushlink-cordova-plugin
```

## Compatibility Matrix

| Jar File | Cordova| Comments|
| ------------- | ------------- | ------------- |
| pushlink-android-5.5.2 | `Not released yet` | . |
| pushlink-android-5.5.0 | pushlink-phonegap-6.0.1 | [Fixed for Android 6](https://github.com/pushlink/pushlink-phonegap/issues/10) |
| pushlink-android-5.5.0 | pushlink-phonegap-5.5.0 | . |
| pushlink-android-5.4.4 | pushlink-phonegap-5.4.4 | . | 

## Usage

The plugin exposes a global `window.PushLink` object, so there is no need to instantiate an object.

On your main `.js` file, you can call:

```javascript

//this new start API was introduced in pushlink-phonegap-6.0.1

var successCallback = function success() { console.log('PushLink started successfully'); };
var errorCallback = function error() { console.log('An error occurred.'); };

PushLink.start({
  apiKey: 'api-key',
  deviceId: 'device-id',
  successCallback: successCallback,
  errorCallback: errorCallback
});

```

## Help & Support

Always feel free to drop a line to support at pushlink dot com or visit our [support](https://www.pushlink.com/support.xhtml).

Users are always welcome to contribute with [issues](https://github.com/pushlink/pushlink-phonegap/issues) and [pull requests](https://github.com/pushlink/pushlink-phonegap/pulls)

