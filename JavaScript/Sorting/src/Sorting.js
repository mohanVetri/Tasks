let todos = {
    title: "title",
    completed: {
        Completed: "completed",
        true: true,
        false: false
    }
}

function requestToRetriveData(resolve, reject, condition) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            resolve(this.responseText, condition);
        }
        else if (this.readyState == 4 && this.status != 200) {
            reject("error");
        }
    };
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/users/1/todos", true);
    xhttp.send();
}

function myResolve(response, condition) {
    let responseObject = JSON.parse(response);
    let resultArray = [];
    if (condition == todos.title) {
        resultArray = sortingByTitle(resultArray, responseObject);
    }
    else if (condition == true || condition == false) {
        resultArray = sortingByCompleted(resultArray, responseObject, condition);
    }
    else if (condition == todos.completed.Completed) {
        resultArray = sortingByCompleted(resultArray, responseObject, todos.completed.true);
        resultArray = sortingByCompleted(resultArray, responseObject, todos.completed.false);
    }
    console.log(resultArray);
    return resultArray;
}

function myReject(errorMessage) {
    console.log(errorMessage);
    return errorMessage;
}

function sortingByTitle(sortedArray, responseObject) {
    sortedArray = Object.values(responseObject);
    sortedArray.sort(function (value1, value2) {
        if (value1.title < value2.title) {
            return -1;
        }
        else {
            return 1;
        }
    });
    return sortedArray;
}

function sortingByCompleted(sortedArray, responseObject, completedValue) {
    for (individual of responseObject) {
        if (individual.completed === completedValue) {
            sortedArray.push(individual);
        }
    }
    return sortedArray;
}

requestToRetriveData(myResolve,myReject,"title");

module.exports={sortingByTitle,sortingByCompleted,myResolve,myReject,requestToRetriveData}