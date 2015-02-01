var PushLink = {
	start: function(appIconId, apiKey, deviceId, successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, 
			'com.pushlink.cordova.PushLinkPlugin', 'startPushlink', 
			[{
				appIconId: appIconId,
				apiKey: apiKey,
				deviceId: deviceId
			}]);
	}
};

module.exports = PushLink;