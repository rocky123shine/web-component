const messagejs = {};
messagejs.os = {};
messagejs.os.isIOS = /iOS|iPhone|iPad|iPod/i.test(navigator.userAgent);
messagejs.os.isAndroid = !messagejs.os.isIOS
messagejs.executeNativeAction = function (commandName, parameters) {
    console.log("execute messagejs executeNativeAction function")
    //封装参数
    const request = {};
    request.name = commandName;
    request.param = parameters;
    if (window.messagejs.os.isAndroid) {
        console.log("android execute native action " + JSON.stringify(request));
        window.webComponent.executeNativeAction(JSON.stringify(request))
    } else {
        window.webkit.messageHandlers.webComponent.postMessage(JSON.stringify(request))
    }
}

window.messagejs = messagejs
