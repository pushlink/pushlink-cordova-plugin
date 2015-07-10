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

    it('should return the right version', function(done) {
      PushLink.getVersion(function(data) {
        expect(data.version).toBe('5.3.0');
        done();
      },
      function() {
        console.error(arguments);
        jasmine.fail('Test failed');
        done();
      });
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

    it('should start the service', function() {
      expect(PushLink.start).toBeDefined();
      expect(typeof PushLink.start).toBe('function');

      PushLink.start('com.example', 'api-key', 'device-id', null, null);

      checkCallsPushLink('start', null, null, {
        packageName: 'com.example',
        apiKey: 'api-key',
        deviceId: 'device-id'
      });
    });
  });
};
