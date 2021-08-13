const { getStudentDataBase } = require("./AddingDetail");
const { getIndividualDetails } = require("./IndividualDetails");
const { validation } = require("./Validation");

function updateDetails() {
    let requiredDetails=getIndividualDetails();
    let result=`<form id="form" method="POST">`+
        `<table>`+
            `<tr>`+
                `<td><b>FirstName :</b></td>`+
                `<td><input id="firstName" type="text" name="firstName" value=${requiredDetails.firstName} onchange="validate.firstNameValidation()"></td>`+
                `<td><span id="warningForFirstName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Last Name :</b></td>`+
                `<td><input id="lastName" type="text" name="lastName" value=${requiredDetails.lastName} onchange="validate.lastNameValidation()"></td>`+
                `<td><span id="warningForLastName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
               `<td><b>Register.No :</b></td>`+
                `<td><input id="registerNo" type="number" name="registerNo" value=${requiredDetails.registerNo} onchange="validate.registerNoValidation()" readonly></td>`+
                `<td><span id="warningForRegisterNo" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Father's Name:</b></td>`+
                `<td><input id="fatherName" type="text" name="fatherName" value=${requiredDetails.fatherName} onchange="validate.fatherNameValidation()"></td>`+
                `<td><span id="warningForFatherName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Mother's Name:</b></td>`+
                `<td><input id="motherName" type="text" name="motherName" value=${requiredDetails.motherName} onchange="validate.motherNameValidation()"></td>`+
                `<td><span id="warningForMotherName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Age:</b></td>`+
                `<td><input id="studentAge" type="number" name="studentAge" value=${requiredDetails.age} onchange="validate.ageValidation()"></td>`+
                `<td><span id="warningForAge" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>SSLC Mark:</b></td>`+
                `<td><input id="sslcMark" type="number" name="sslcMark" value=${requiredDetails.sslcMark} onchange="validate.sslcMarkValidation()"></td>`+
                `<td><span id="warningForSSLC" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>HSC Mark:</b></td>`+
                `<td><input id="hscMark" type="number" name="hscMark" value=${requiredDetails.hscMark} onchange="validate.hscMarkValidation()"></td>`+
                `<td><span id="warningForHSC" class="warning"></span></td>`+
            `</tr>`+
        `</table>`+
    `</form>`+
    `<button id="register" onclick="update.updateForm()">Update</button>`+
    `<span id='message'></span>`;
    if(requiredDetails!="")
    document.getElementById('viewUpdateDelete').innerHTML=result;
    else
    document.getElementById('viewUpdateDelete').innerHTML="<b>NO DATA AVAILABLE!!</b>";
}

function updateForm(){
    if(validation()){
        let requiredDetails=getIndividualDetails();
        let resultDataBase=getStudentDataBase();
        resultDataBase.forEach(IndividualDetail => {
            if(IndividualDetail.registerNo===requiredDetails.registerNo){
                IndividualDetail.lastName=document.getElementById('lastName').value;
                IndividualDetail.firstName=document.getElementById('firstName').value;
                IndividualDetail.age=document.getElementById('studentAge').value;
                IndividualDetail.fatherName=document.getElementById('fatherName').value;
                IndividualDetail.motherName=document.getElementById('motherName').value;
                IndividualDetail.sslcMark=document.getElementById('sslcMark').value;
                IndividualDetail.hscMark=document.getElementById('hscMark').value;
            }
        });
        localStorage.setItem('studentDataBase',JSON.stringify(resultDataBase));
        document.getElementById('viewUpdateDelete').innerHTML="<b>Successfully Updated!!</b>";
    }
}

module.exports={updateDetails,updateForm}