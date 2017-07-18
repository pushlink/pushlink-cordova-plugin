/* eslint-env jasmine */
/* globals PushLink */
'use strict';

var checkCallsPushLink = function(action, successCallback, errorCallback, arg) {
  expect(window.cordova.exec).toHaveBeenCalledWith(
    successCallback, errorCallback, 'com.pushlink.cordova.PushLinkPlugin',
    action, [arg]);
};

exports.defineAutoTests = function() {
  describe('PushLink object (window.PushLink)', function() {
    it('should exists', function() {
      expect(window.PushLink).toBeDefined();
      expect(typeof window.PushLink).toBe('object');
    });
  });

  describe('PushLink service calls', function() {
    var realCordova = null;
    beforeEach(function() {
      realCordova = window.cordova;
      window.cordova = jasmine.createSpyObj('fake cordova', ['exec']);
    });

    afterEach(function() {
      window.cordova = realCordova;
    });

    it('should start the service with no package name', function() {
      expect(PushLink.start).toBeDefined();
      expect(typeof PushLink.start).toBe('function');

      var successCallback = function(){};
      var errorCallback = function(){};
      
      PushLink.start('api-key', 'device-id', successCallback, errorCallback);

      checkCallsPushLink('start', successCallback, errorCallback, {
        apiKey: 'api-key',
        deviceId: 'device-id'
      });
    });

    it('should start the service with package name', function() {
      expect(PushLink.start).toBeDefined();
      expect(typeof PushLink.start).toBe('function');

      var successCallback = function(){};
      var errorCallback = function(){};

      PushLink.start('package-name-foo','api-key', 'device-id', successCallback, errorCallback);

      checkCallsPushLink('start', successCallback, errorCallback, {
        packageName: 'package-name-foo',
        apiKey: 'api-key',
        deviceId: 'device-id'
      });
    });

  });
};
