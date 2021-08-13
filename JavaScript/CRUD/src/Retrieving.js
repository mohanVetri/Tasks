let retrivePromise = new Promise(function (myResolve, myReject) {
    var xhttp= getXMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            myResolve("Successfully Retrived");
        }
        else if (this.readyState == 4 && this.status != 200) {
            myReject("error");
        }
    };
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/1", true);
    xhttp.send();
});

function retrivingFunction(promise, callBackFunction) {
    console.log("2.retriving");
    promise.then(
        function (value) {
            document.getElementById("Retriving").innerHTML = value;
            callBackFunction(updatePromise, deleteFunction);
        },
        function (error) {
            document.getElementById("Retriving").innerHTML = error;
        }
    );
}
