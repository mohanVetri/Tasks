let data = JSON.stringify({
    title: 'Jungpyo',
    body: 'jihu',
    userId: 1,
});

let creationPromise = new Promise(function(myResolve, myReject) {
    var xhttp= new XMLHttpRequest();
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

    creationPromise.then(
        function (value) {
            console.log(value);
        },
        function (error) {
            console.log(error);
        }
    );
    
module.exports={creationPromise};
