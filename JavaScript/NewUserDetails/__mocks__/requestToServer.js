var response = {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
        }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
        "name": "Romaguera-Crona",
        "catchPhrase": "Multi-layered client-server neural-net",
        "bs": "harness real-time e-markets"
    }
};


function requestToRetriveData(resolve, reject, method, url) {
    console.log("hello i am here");
    resolve(JSON.stringify(response));
    // var xhttp = new XMLHttpRequest();
    // xhttp.onreadystatechange = function () {
    //     if (this.readyState == 4 && (this.status == 201 || this.status == 200)) {
    //         resolve(this.responseText);
    //     }
    //     if (this.readyState == 4 && (this.status != 201 || this.status != 200)) {
    //         reject("error");
    //     }
    // };
    // xhttp.open(method, url, true);
    // xhttp.send();
}