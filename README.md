# PushLink - PhoneGap / Cordova plugin [![Circle CI](https://circleci.com/gh/pushlink/pushlink-phonegap/tree/master.svg?style=svg&circle-token=bb31d76d18c780f6594f35a72d0a3e586914f176)](https://circleci.com/gh/pushlink/pushlink-phonegap/tree/master)

## Installation

```
$ phonegap plugin add com.pushlink.cordova
```
## Usage

The plugin exposes a global `window.PushLink` object, so there is no need to instantiate an object.

On your main `.js` file, you can call:

```javascript
PushLink.start('com.myapp', 'my pushlink api key', 'device id', function() {
  console.log('PushLink started successfully');
},
function(error) {
  console.log('An error occurred.');
});
```

Full [Working sample ](https://github.com/pushlink/pushlink-phonegap-sample).


## Help & Support

Always feel free to drop a line to support at pushlink dot com or visit our [support](https://www.push-link.com/support.xhtml).

Users are always welcome to contribute with [issues](https://github.com/pushlink/pushlink-phonegap/issues) and [pull requests](https://github.com/pushlink/pushlink-phonegap/pulls)
