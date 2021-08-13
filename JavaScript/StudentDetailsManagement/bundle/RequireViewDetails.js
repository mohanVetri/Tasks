(function(f){if(typeof exports==="object"&&typeof module!=="undefined"){module.exports=f()}else if(typeof define==="function"&&define.amd){define([],f)}else{var g;if(typeof window!=="undefined"){g=window}else if(typeof global!=="undefined"){g=global}else if(typeof self!=="undefined"){g=self}else{g=this}g.view = f()}})(function(){var define,module,exports;return (function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
var individualDetails="";
function isStudentDetailExisted() {
    let studentDataBase = JSON.parse(localStorage.getItem("studentDataBase"));
    let exist = false;
    studentDataBase.forEach(IndividualDetail => {
        if (IndividualDetail.registerNo === document.getElementById('registerNo').value) {
            individualDetails = IndividualDetail;
            exist = true;
        }
    });
    return exist;
}

function getIndividualDetails() {
    if(!isStudentDetailExisted())
    individualDetails="";
    return individualDetails;
}

function showOutput() {
    if (isStudentDetailExisted()){
        let outputHTML=`<h3>Records Existed!!</h3><br>`+
        `<button onclick="view.viewDetails()">View</button> `+
        `<button onclick="update.updateDetails()">Edit</button> `+
        `<button onclick="deleteModule.deleteDetail()">Delete</button><br>`;
    document.getElementById('output').innerHTML = outputHTML; 
    }else {
        document.getElementById('output').innerHTML = "<h3><i>No such Records</i></h3>"; 
        document.getElementById('viewUpdateDelete').innerHTML = ""; 
    }
}

module.exports = { isStudentDetailExisted, getIndividualDetails, showOutput }
},{}],2:[function(require,module,exports){
const { getIndividualDetails } = require("./IndividualDetails")

function viewDetails() {
    let requiredDetails=getIndividualDetails();
    let result = `<table>`+
    `<tr>`+
        `<td><b>FirstName :</b></td>`+
        `<td>${requiredDetails.firstName}</td>`+
    `</tr>`+
    `<tr>`+
        `<td><b>LastName :</b></td>`+
        `<td>${requiredDetails.lastName}</td>`+
    `</tr>`+
    `<tr>`+
        `<td><b>Register.No :</b></td>`+
        `<td>${requiredDetails.registerNo}</td>`+
    `</tr>`+
    `<tr>`+
        `<td><b>Age :</b></td>`+
        `<td>${requiredDetails.age}</td>`+
    `</tr>`+
    `<tr>`+
        `<td><b>FatherName :</b></td>`+
        `<td>${requiredDetails.fatherName}</td>`+
   `</tr>`+
    `<tr>`+
        `<td><b>MotherName :</b></td>`+
       `<td>${requiredDetails.motherName}</td>`+
    `</tr>`+
    `<tr>`+
        `<td><b>SSLCMark :</b></td>`+
        `<td>${requiredDetails.sslcMark}</td>`+
    `</tr>`+
    `<tr>`+
        `<td><b>HSCMark :</b></td>`+
        `<td>${requiredDetails.hscMark}</td>`+
    `</tr>`+
`</table>`;
if(requiredDetails!="")
document.getElementById('viewUpdateDelete').innerHTML=result;
else
document.getElementById('viewUpdateDelete').innerHTML="<b>NO DATA AVAILABLE!!</b>";
}

module.exports={viewDetails}
},{"./IndividualDetails":1}]},{},[2])(2)
});
