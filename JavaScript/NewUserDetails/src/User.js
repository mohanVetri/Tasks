const {requestToRetriveData}=require("../__mocks__/requestToServer");
let httpMethods = {
    get: "GET",
};
let baseUrl = "https://jsonplaceholder.typicode.com";
let urlForUserList = baseUrl + "/users";
let urlForSpecificUser = urlForUserList + "/1";



function myResolve(response) {
    let result = JSON.parse(response);
    let requiredStructure = getRequiredStructure(result);
    console.log(requiredStructure);
}

function getRequiredStructure(result) {
    let requiredStructure={};
    requiredStructure[result.email] = {
        id: result.id,
        firstName: result.name.split(" ")[0],
        lastName: result.name.split(" ")[1],
        city: result.address.city,
        zipcode: result.address.zipcode,
        phone: result.phone,
        companyName: result.company.name,
        username: result.username,
    }
    return requiredStructure;
}

function myReject(error) {
    console.log(error);
}

// function getResponse(myResolve,myReject,method,url) {
//     requestToRetriveData(myResolve, myReject, method, url);
// }
// requestToRetriveData(myResolve, myReject, httpMethods.get, urlForSpecificUser);

module.exports={getRequiredStructure,myResolve,myReject}