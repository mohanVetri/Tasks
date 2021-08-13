function getXMLHttpRequest() {
    var xhttp;
    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xhttp;
}

var data = JSON.stringify({
    title: 'Jungpyo',
    body: 'jihu',
    userId: 1,
});
