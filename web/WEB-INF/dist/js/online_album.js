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

function resultHandler(data, status, tabId) {
    console.log("Data: " + data.result + "\nStatus: " + status);
    if (data.result) {
        $('#resModal').addClass('modal-success');
        $('#resModal').removeClass('modal-danger');
        $("#modalMsg").text(data.msg);
        $('#resModal').modal('show');
        closeTab(tabId, 2000);
    } else {
        $('#resModal').removeClass('modal-success');
        $('#resModal').addClass('modal-danger');
        $("#modalMsg").text(data.msg);
        $('#resModal').modal('show');
    }
}

function showNotFoundModal() {
    $('#resModal').removeClass('modal-success');
    $('#resModal').addClass('modal-danger');
    $("#modalMsg").text("项目不存在");
    $('#resModal').modal('show');
}

function closeTab(tabId, delay) {
    setTimeout(function () {
        top.closeTabByPageId(tabId);
    }, delay);
}