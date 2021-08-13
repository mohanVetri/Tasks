function requestToRetriveData(resolve, reject, method, url) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && (this.status == 201 || this.status == 200)) {
            resolve(this.responseText);
        }
        if (this.readyState == 4 && (this.status != 201 || this.status != 200)) {
            reject("error");
        }
    };
    xhttp.open(method, url, true);
    xhttp.send();
}

module.exports={requestToRetriveData}