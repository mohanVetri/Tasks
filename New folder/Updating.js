let updatePromise = new Promise(function (myResolve, myReject) {
    var xhttp= getXMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myResolve("Successfully Updated");
        }
        else if (this.readyState == 4 && this.status != 200) {
            myReject("error");
        }
    };
    xhttp.open("PUT", "https://jsonplaceholder.typicode.com/posts/1", true);
    xhttp.send(data);
});

function updateFunction(promise, callBackFunction) {
    console.log("3.Updation");
    promise.then(
        function (value) {
            document.getElementById("Updation").innerHTML = value;
            callBackFunction(deletePromise);
        },
        function (error) {
            document.getElementById("Updation").innerHTML = error;
        }
    );
}