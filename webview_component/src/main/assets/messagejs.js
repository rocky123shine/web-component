const messagejs = {};
messagejs.os = {};
messagejs.os.isIOS = /iOS|iPhone|iPad|iPod/i.test(navigator.userAgent);
messagejs.os.isAndroid = !messagejs.os.isIOS
messagejs.callbacks={};
messagejs.executeNativeAction = function (commandName, parameters) {
    //封装参数
    const request = {};
    request.name = commandName;
    request.param = parameters;
    if (window.messagejs.os.isAndroid) {
        window.webComponent.executeNativeAction(JSON.stringify(request))
    } else {
        window.webkit.messageHandlers.webComponent.postMessage(JSON.stringify(request))
    }
}

messagejs.executeNativeActionWithCallback = function (commandName, parameters,callback) {
    var callbackName = "nativetojs_callback_" + (new Date()).getTime() + "_" + Math.floor(Math.random() * 10000);
    messagejs.callbacks[callbackName] = callback;

    //封装参数
    const request = {};
    request.name = commandName;
    request.param = parameters;
    request.param.callbackName = callbackName;
    if (window.messagejs.os.isAndroid) {
        window.webComponent.executeNativeAction(JSON.stringify(request))
    } else {
        window.webkit.messageHandlers.webComponent.postMessage(JSON.stringify(request))
    }
}

messagejs.callback = function(callbackName,response){
    var callbackObj =  messagejs.callbacks[callbackName];
    if(callbackObj !== undefined){
        var res =  callbackObj(response);
        if(res === false) return;
        delete messagejs.callbacks[callbackName];
    }
}
window.messagejs = messagejs
