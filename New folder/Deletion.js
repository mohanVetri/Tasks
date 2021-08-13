let deletePromise = new Promise(function (myResolve, myReject) {
    var xhttp= getXMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myResolve("Successfully Deleted");
        }
        else if (this.readyState == 4 && this.status != 200) {
            myReject("error");
        }
    };
    xhttp.open("DELETE", "https://jsonplaceholder.typicode.com/posts/1", true);
    xhttp.send();
});

function deleteFunction(promise) {
    console.log("4.deletion");
    promise.then(
        function (value) {
            document.getElementById("Deletion").innerHTML = value;
        },
        function (error) {
            document.getElementById("Deletion").innerHTML = error;
        }
    );
}
