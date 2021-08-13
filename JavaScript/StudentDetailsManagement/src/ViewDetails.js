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