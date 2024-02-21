// IWebViewProcessToMainProcess.aidl
package com.rocky.common;
// Declare any non-default types here with import statements
import com.rocky.common.ICallbackFromMainProcessToWebViewProcess;

interface IWebViewProcessToMainProcess {

    void handleWebCommand(String commandName,String jsParams,in ICallbackFromMainProcessToWebViewProcess callback);
}