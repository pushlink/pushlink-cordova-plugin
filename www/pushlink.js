var cordovaExec = function(action, successCallback, errorCallback, arg) {
  var args = (arg != null) ? [arg] : [];
  cordova.exec(successCallback, errorCallback, 'com.pushlink.cordova.PushLinkPlugin', action, args);
}

var PushLink = function() {
  this.NINJA = "NINJA";
  this.STATUS_BAR = "STATUS_BAR";
  this.ANNOYING_POPUP = "ANNOYING_POPUP";
  this.FRIENDLY_POPUP = "FRIENDLY_POPUP";
};

PushLink.prototype.start = function(appIconId, apiKey, deviceId, successCallback, errorCallback) {
  cordovaExec('startPushlink', successCallback, errorCallback, {
		appIconId: appIconId,
		apiKey: apiKey,
		deviceId: deviceId
	});
  return this;
};

PushLink.prototype.addExceptionMetadata = function(key, value, successCallback, errorCallback) {
  cordovaExec('addExceptionMetadata', successCallback, errorCallback, {key: key, value: value});
  return this;
};

PushLink.prototype.addMetadata = function(key, value, successCallback, errorCallback) {
  cordovaExec('addMetadata', successCallback, errorCallback, {key: key, value: value});
  return this;
};

PushLink.prototype.enableExceptionNotification = function(successCallback, errorCallback) {
  cordovaExec('enableExceptionNotification', successCallback, errorCallback);
  return this;
};

PushLink.prototype.disableExceptionNotification = function(successCallback, errorCallback) {
  cordovaExec('disableExceptionNotification', successCallback, errorCallback);
  return this;
};

PushLink.prototype.setCurrentStrategy = function(strategy, successCallback, errorCallback) {
  cordovaExec('setCurrentStrategy', successCallback, errorCallback, {strategy: strategy});
  return this;
};

PushLink.prototype.getCurrentStrategy = function(successCallback, errorCallback) {
  cordovaExec('getCurrentStrategy', successCallback, errorCallback);
  return this;
};

PushLink.prototype.hasPendingUpdate = function(successCallback, errorCallback) {
  cordovaExec('hasPendingUpdate', successCallback, errorCallback);
  return this;
};

PushLink.prototype.idle = function(isIdle, successCallback, errorCallback) {
  cordovaExec('idle', successCallback, errorCallback, {idle: isIdle});
  return this;
};

PushLink.prototype.getVersion = function(successCallback, errorCallback) {
  cordovaExec('version', successCallback, errorCallback);
  return this;
};

module.exports = new PushLink();
