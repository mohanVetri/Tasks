(function(f){if(typeof exports==="object"&&typeof module!=="undefined"){module.exports=f()}else if(typeof define==="function"&&define.amd){define([],f)}else{var g;if(typeof window!=="undefined"){g=window}else if(typeof global!=="undefined"){g=global}else if(typeof self!=="undefined"){g=self}else{g=this}g.validate = f()}})(function(){var define,module,exports;return (function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
var studentDataBase=[];
function addingDetails() {
    if(!isRegisterNoExist()){
        let studentDetails={};        
        studentDetails["firstName"]=document.getElementById('firstName').value;
        studentDetails["lastName"]=document.getElementById('lastName').value;
        studentDetails["registerNo"]=document.getElementById('registerNo').value;
        studentDetails["fatherName"]=document.getElementById('fatherName').value;
        studentDetails["motherName"]=document.getElementById('motherName').value;
        studentDetails["age"]=document.getElementById('studentAge').value;
        studentDetails["sslcMark"]=document.getElementById('sslcMark').value;
        studentDetails["hscMark"]=document.getElementById('hscMark').value;
        var resultDataBase=JSON.parse(localStorage.getItem('studentDataBase'));
        resultDataBase.push(studentDetails);
        localStorage.setItem("studentDataBase",JSON.stringify(resultDataBase));
        document.getElementById('message').innerHTML="Successfully Added!!!";
    }
    else{
        document.getElementById('message').innerHTML="RegisterNo is Already Existed!!!";
    }
}
function isRegisterNoExist() {
    let isExist=false;
    let registerNo=document.getElementById('registerNo').value;
    let resultDataBase=getStudentDataBase();
    resultDataBase.forEach(element => {
       if(element.registerNo==registerNo){
           isExist=true;
       }
    });
    return isExist;
}
function getStudentDataBase() {
    if(JSON.parse(localStorage.getItem('studentDataBase'))===null)
    localStorage.setItem("studentDataBase",JSON.stringify(studentDataBase));
        return JSON.parse(localStorage.getItem('studentDataBase'));
}
module.exports={addingDetails,isRegisterNoExist,getStudentDataBase}
},{}],2:[function(require,module,exports){
const { addingDetails } = require("./AddingDetail");
function firstNameValidation() {
    let firstName = document.getElementById("firstName").value;
    if (firstName.trim() === null || firstName.trim() === "") {
        document.getElementById("warningForFirstName").innerHTML = "*firstName should not be empty";
        return false;
    }
    else if (!(firstName[0] === firstName[0].toUpperCase())) {
        document.getElementById("warningForFirstName").innerHTML = "*first letter of firstName should be in capital";
        return false;
    }
    else {
        document.getElementById("warningForFirstName").innerHTML = "";
        return true;
    }
}

function lastNameValidation() {
    let lastName = document.getElementById("lastName").value;
    if (lastName.trim() === null || lastName.trim() === "") {
        document.getElementById("warningForLastName").innerHTML = "*lastName should not be empty";
        return false;
    }
    else if (!(lastName[0] === lastName[0].toUpperCase())) {
        document.getElementById("warningForLastName").innerHTML = "*first letter of lastName should be in capital";
        return false;
    }
    else {
        document.getElementById("warningForLastName").innerHTML = "";
        return true;
    }
}

function registerNoValidation() {
    let registerNo = document.getElementById('registerNo').value;
    if (registerNo === null || registerNo.trim() === "") {
        document.getElementById('warningForRegisterNo').innerHTML = "*RegisterNo should not be empty";
        return false;
    }
    else if (registerNo < 1 || registerNo > 100) {
        document.getElementById('warningForRegisterNo').innerHTML = "*RegisterNo should be greater than 0 and less than or equal to 100";
        return false;
    }
    else {
        document.getElementById('warningForRegisterNo').innerHTML = "";
        return true;
    }
}

function fatherNameValidation() {
    let fatherName = document.getElementById("fatherName").value;
    if (fatherName.trim() === null || fatherName.trim() === "") {
        document.getElementById("warningForFatherName").innerHTML = "*fatherName should not be empty"
        return false;
    }
    else if (!(fatherName[0] === fatherName[0].toUpperCase())) {
        document.getElementById("warningForFatherName").innerHTML = "*first letter of the fatherName should be in capital"
        return false;
    }
    else {
        document.getElementById("warningForFatherName").innerHTML = ""
        return true;
    }

}
function motherNameValidation() {
    let motherName = document.getElementById("motherName").value;
    if (motherName.trim() === null || motherName.trim() === "") {
        document.getElementById("warningForMotherName").innerHTML = "*motherName should not be empty";
        return false;
    }
    else if (!(motherName[0] === motherName[0].toUpperCase())) {
        document.getElementById("warningForMotherName").innerHTML = "*first letter of the motherName should be in Capital";
        return false;
    }
    else {
        document.getElementById("warningForMotherName").innerHTML = "";
        return true;
    }

}

function ageValidation() {
    let age = document.getElementById('studentAge').value;
    if (age.length === 0) {
        document.getElementById("warningForAge").innerHTML = "*Age should not be empty";
        return false;
    }
    else if (1 > age.length || age.length > 2) {
        document.getElementById("warningForAge").innerHTML = "*Age should  be in two digit and greater than 0";
        return false;
    }
    else {
        document.getElementById("warningForAge").innerHTML = "";
        return true;
    }

}

function sslcMarkValidation() {
    let sslcMark = document.getElementById('sslcMark').value;
    if (sslcMark.length === 0) {
        document.getElementById("warningForSSLC").innerHTML = "*sslc Mark should not be empty";
        return false;
    }
    else if (sslcMark < 0 || sslcMark > 500) {
        document.getElementById("warningForSSLC").innerHTML = "*sslc Mark should  be less than or equal to 500 and greater than 0";
        return false;
    }
    else {
        document.getElementById("warningForSSLC").innerHTML = "";
        return true;
    }
}

function hscMarkValidation() {
    let hscMark = document.getElementById('hscMark').value;
    if (hscMark.length === 0) {
        document.getElementById('warningForHSC').innerHTML = "*hsc Mark should not be empty";
        return false;
    }
    else if (hscMark > 1200 || hscMark < 0) {
        document.getElementById('warningForHSC').innerHTML = "*hsc Mark should be less than or equal to 1200 and greater than 0";
        return false;
    }
    else {
        document.getElementById('warningForHSC').innerHTML = "";
        return true;
    }
}

function validation() {

    if (firstNameValidation() && lastNameValidation() && registerNoValidation() && fatherNameValidation() && motherNameValidation() && ageValidation()
        && sslcMarkValidation() && hscMarkValidation()) {
        return true;
    }
    else {
        return false;
    }

}

function submitForm() {
    if (validation()) {
        addingDetails();
    }
}
module.exports = { firstNameValidation, lastNameValidation, registerNoValidation, fatherNameValidation, motherNameValidation, ageValidation, sslcMarkValidation, hscMarkValidation, validation, submitForm };
},{"./AddingDetail":1}]},{},[2])(2)
});
