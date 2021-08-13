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