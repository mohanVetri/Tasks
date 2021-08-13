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