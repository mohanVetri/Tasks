var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        print(this.responseText);
    }
    else if (this.readyState == 4 && this.status != 200) {
        print("error");
    }
};
xhttp.open("GET", "https://jsonplaceholder.typicode.com/users/1/todos", true);
xhttp.send();

function print(response) {
    var obj = JSON.parse(response);
    var list=Object.values(obj);
    list.sort(function(value1,value2){
        if(value1.title<value2.title){
            return -1;
        }
        else{
            return 1;
        }
    });
    console.log(list);
}

function sortingByTitle(resolve, reject) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            resolve(this.responseText);
        }
        else if(this.readyState==4 && this.status!=200){
            reject("error");
        }
    };
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/users/1/todos", true);
    xhttp.send();
}

function myResolve(response) {
    var obj = JSON.parse(response);
    var list=Object.values(obj);
    list.sort(function(value1,value2){
        if(value1.title<value2.title){
            return -1;
        }
        else{
            return 1;
        }
    });
    console.log(list);
}

function myReject(errorMessage) {
    console.log(errorMessage);
}


sortingByTitle(myResolve, myReject);