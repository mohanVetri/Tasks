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