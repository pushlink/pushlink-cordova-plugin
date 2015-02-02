var cordovaExec = function(action, successCallback, errorCallback, arg) {
  var args = (arg != null) ? [arg] : [];
  cordova.exec(successCallback, errorCallback, 'com.pushlink.cordova.PushLinkPlugin', args);
}

var PushLink = {
	start: function(appIconId, apiKey, deviceId, successCallback, errorCallback) {
    cordovaExec('startPushlink', successCallback, errorCallback, {
			appIconId: appIconId,
			apiKey: apiKey,
			deviceId: deviceId
		});
    return this;
	},

  addExceptionMetadata: function(key, value, successCallback, errorCallback) {
    cordovaExec('addExceptionMetadata', successCallback, errorCallback, {key: key, value: value});
    return this;
  },

  addMetadata: function(key, value, successCallback, errorCallback) {
    cordovaExec('addMetadata', successCallback, errorCallback, {key: key, value: value});
    return this;
  }, 

  enableExceptionNotification: function(successCallback, errorCallback) {
    cordovaExec('enableExceptionNotification', successCallback, errorCallback);
    return this;
  },

  disableExceptionNotification: function(successCallback, errorCallback) {
    cordovaExec('disableExceptionNotification', successCallback, errorCallback);
    return this;
  },

  setCurrentStrategy: function(strategy, successCallback, errorCallback) {
    cordovaExec('setCurrentStrategy', successCallback, errorCallback, {strategy: strategy});
    return this;
  },

  getCurrentStrategy: function(successCallback, errorCallback) {
    cordovaExec('getCurrentStrategy', successCallback, errorCallback);
    return this;
  },

  hasPendingUpdate: function(successCallback, errorCallback) {
    cordovaExec('hasPendingUpdate', successCallback, errorCallback);
    return this;
  },

  idle: function(isIdle, successCallback, errorCallback) {
    cordovaExec('idle', successCallback, errorCallback, {idle: isIdle});
    return this;
  }  
};

module.exports = PushLink;