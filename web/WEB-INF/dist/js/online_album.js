function createNewTab(url, title) {
    var tabId = Math.floor(Math.random() * 100);
    top.addTabs({
        id: '' + tabId,
        title: title,
        close: true,
        url: url,
        urlType: "relative"
    });
}

function resultHandlerCloseTab(data, status, tabId) {
    resultHandler(data, status, function () {
        closeTab(tabId, 2000);
    });
}

function resultHandlerRefreshTab(data, status, tabId) {
    resultHandler(data, status, function () {
        refreshTab(tabId, 2000);
    });
}


function resultHandler(data, status, success, fail) {
    console.log("Data: " + data.result + "\nStatus: " + status);
    if (data.result) {
        $('#resModal').addClass('modal-success');
        $('#resModal').removeClass('modal-danger');
        $("#modalMsg").text(data.msg);
        $('#resModal').modal('show');
        success();
    } else {
        $('#resModal').removeClass('modal-success');
        $('#resModal').addClass('modal-danger');
        $("#modalMsg").text(data.msg);
        $('#resModal').modal('show');
        fail();
    }
}

function showNotFoundModal(func) {
    $('#resModal').removeClass('modal-success');
    $('#resModal').addClass('modal-danger');
    $("#modalMsg").text("项目不存在");
    $('#resModal').modal('show');
    func();
}

function closeTab(tabId, delay) {
    setTimeout(function () {
        top.closeTabByPageId(tabId);
    }, delay);
}

function refreshTab(tabId, delay) {
    setTimeout(function () {
        top.refreshTabById(tabId);
    }, delay);
}