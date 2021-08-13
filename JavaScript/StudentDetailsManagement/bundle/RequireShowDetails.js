(function(f){if(typeof exports==="object"&&typeof module!=="undefined"){module.exports=f()}else if(typeof define==="function"&&define.amd){define([],f)}else{var g;if(typeof window!=="undefined"){g=window}else if(typeof global!=="undefined"){g=global}else if(typeof self!=="undefined"){g=self}else{g=this}g.showDetail = f()}})(function(){var define,module,exports;return (function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
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
const{getStudentDataBase}=require('./AddingDetail');
function displayDetails() {
    let totalDetails=getStudentDataBase();
    let output="<h3>No Details Found!!</h3>";
    if (totalDetails.length!=0){
        output = "<table>" +
        "<tr>" +
        "<th>FirstName</th><th>lastName</th><th>Age</th>" +
        "<th>RegisterNo</th><th>FatherName</th><th>MotherName</th>" +
        "<th>SSLC Mark</th><th>HSC Mark</th></tr>";
    totalDetails.forEach(element => {
        output += "<tr>" +
            "<td>" + element.firstName + "</td>"
            + "<td>" + element.lastName + "</td>"
            + "<td>" + element.age + "</td>"
            + "<td>" + element.registerNo + "</td>"
            + "<td>" + element.fatherName + "</td>"
            + "<td>" + element.motherName + "</td>"
            + "<td>" + element.sslcMark + "</td>"
            + "<td>" + element.hscMark + "</td>"
            + "</tr>";
    });
    output += "</table><br>";
    }
    document.getElementById('detailsTable').innerHTML = output;
}

function reset() {
    localStorage.clear();
}
module.exports = { displayDetails, reset }
},{"./AddingDetail":1}]},{},[2])(2)
});
