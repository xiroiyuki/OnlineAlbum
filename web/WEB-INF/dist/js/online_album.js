function createNewTab(url, title) {
    var tabId = Math.floor(Math.random() * 10);
    top.addTabs({
        id: '' + tabId,
        title: title,
        close: true,
        url: url,
        urlType: "relative"
    });
}