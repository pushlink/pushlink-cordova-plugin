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

PushLink.prototype.start = function(packageName, apiKey, deviceId, successCallback, errorCallback) {
  cordovaExec('start', successCallback, errorCallback, {
    packageName: packageName,
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

PushLink.prototype.setCurrentStrategy = function(strategy, properties, successCallback, errorCallback) {
  if (typeof properties === 'function') {
    errorCallback = successCallback;
    successCallback = properties;
    properties = {};
  } else if (typeof properties != 'object') {
    properties = {};
  }
  cordovaExec('setCurrentStrategy', successCallback, errorCallback, {strategy: strategy, properties: properties});
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
