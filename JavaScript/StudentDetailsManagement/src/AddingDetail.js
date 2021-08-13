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
module.exports ={addingDetails,isRegisterNoExist,getStudentDataBase}