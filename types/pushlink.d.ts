declare const _exports: PushLink;
export = _exports;
/**
 * The PushLink object
 * @constructor
 * @exports PushLink
 */
declare function PushLink(): void;
declare class PushLink {
    /**
     * Starts PushLink connection
     * @param {string} pacakgeName - The package name of your app
     * @param {string} apiKey - Your PushLink API key
     * @param {string} deviceId - The device id
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    start(packageName: any, apiKey: string, deviceId: string, successCallback: Function, errorCallback: Function, ...args: any[]): this;
    /**
     * This method adds information about the application to identify users, apps, devices, etc.
     * This information is going to appear ONLY in the 'Exceptions' tab of the web administration
     * @param {string} key - The metadata label
     * @param {string} value - The metadata value
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    addExceptionMetadata(key: string, value: string, successCallback: Function, errorCallback: Function): this;
    /**
     * This method adds information about the application to identify users, apps, devices, etc.
     * This information is going to appear in two palces: 'Installations' and 'Exceptions' tabs of the web administration
     * @param {string} key - The metadata label
     * @param {string} value - The metadata value
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    addMetadata(key: string, value: string, successCallback: Function, errorCallback: Function): this;
    /**
     * Enable automatic catch/send exception.
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    enableExceptionNotification(successCallback: Function, errorCallback: Function): this;
    /**
     * Disable automatic catch/send exception. You can still send exceptions manually.
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    disableExceptionNotification(successCallback: Function, errorCallback: Function): this;
    /**
     * This method sets the current notification strategy.
     * @param {string} strategy - the strategy name. Valid values are PushLink.STATUS_BAR, PushLink.FRIENDLY_POPUP, PushLink.ANNOYING_POPUP
     * @param {object} properties - the properties for the current strategy
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     * @see {@link https://docs.pushlink.com/strategies}
     */
    setCurrentStrategy(strategy: string, properties: object, successCallback: Function, errorCallback: Function): this;
    /**
     * This method returns StatusBarStrategy or FriendlyPopUpStrategy or AnnoyingPopUpStrategy.
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    getCurrentStrategy(successCallback: Function, errorCallback: Function): this;
    /**
     * This method checks if there is a downloaded but not applied update. It also notify the user again. It is useful for 'Check for updates' button.
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    hasPendingUpdate(successCallback: Function, errorCallback: Function): this;
    /**
     * In order to update your app only when it is idle:
     *
     * 1 - Call PushLink.idle(false) before PushLink.start()
     * 2 - Call PushLink.idle(true) when your app become idle
     * 3 - Call PushLink.idle(false) when your app is back to the action again
     *
     * When idle == false it disables all strategies
     *
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    idle(isIdle: any, successCallback: Function, errorCallback: Function): this;
    /**
     * Returns the current PushLink client version
     * @param {function} successCallback - A function to be called if the command succeeded
     * @param {function} errorCallback - A function to be called if the command failed
     */
    getVersion(successCallback: Function, errorCallback: Function): this;
}
declare namespace PushLink {
    let STATUS_BAR: string;
    let ANNOYING_POPUP: string;
    let FRIENDLY_POPUP: string;
    let CUSTOM: string;
}
