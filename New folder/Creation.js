let creationPromise = new Promise(function (myResolve, myReject) {
    var xhttp= getXMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 201) {
            myResolve("Successfully Created");
        }
        else if (this.readyState == 4 && this.status != 201) {
            myReject("error");
        }
    };
    xhttp.open("POST", "https://jsonplaceholder.typicode.com/posts", true);
    xhttp.send(data);
});

function creationFunction(promise, callBackFunction) {
    console.log(promise);
    console.log("1.Creation");
    promise.then(
        function (value) {
            document.getElementById("creation").innerHTML = value;
            callBackFunction(retrivePromise, updateFunction);
        },
        function (error) {
            document.getElementById("creation").innerHTML = error;
        }
    );
}

