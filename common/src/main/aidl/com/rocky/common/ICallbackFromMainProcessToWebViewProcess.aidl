// ICallbackFromMainProcess.aidl
package com.rocky.common;

// Declare any non-default types here with import statements

interface ICallbackFromMainProcessToWebViewProcess {
    void onResult(String callbackName,String response);
}