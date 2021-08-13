const {updateDetails,updateForm}=require('../UpdateDetails')
document.body.innerHTML=`<span id="viewUpdateDelete"></span>
<input id="firstName" type="text" name="firstName" onchange="firstNameValidation()">
<span id="warningForFirstName" class="warning"></span>
<input id="lastName" type="text" name="lastName" onchange="lastNameValidation()">
<span id="warningForLastName" class="warning"></span>
<input id="registerNo" type="number" name="registerNo" onchange="ageValidation()">
<span id="warningForRegisterNo" class="warning"></span>
<input id="fatherName" type="text" name="fatherName" onchange="fatherNameValidation()">
<span id="warningForFatherName" class="warning"></span>
<input id="motherName" type="text" name="motherName" onchange="motherNameValidation()">
<span id="warningForMotherName" class="warning"></span>
<input id="studentAge" type="number" name="studentAge" onchange="ageValidation()">
<span id="warningForAge" class="warning"></span>
<input id="sslcMark" type="number" name="sslcMark" onchange="sslcMarkValidation()">
<span id="warningForSSLC" class="warning"></span>
<input id="hscMark" type="number" name="hscMark" onchange="hscMarkValidation()">
<span id="warningForHSC" class="warning"></span>
<span id='message'></span>`;
resultDataBase=[{
    firstName:"helo",
    lastName: "hello",
    registerNo: "1",
    age: "22",
    fatherName:"hello",
    motherName:"hello",
    sslcMark:"23",
    hscMark: "123"
},{
    firstName:"helo",
    lastName: "hello",
    registerNo: "2",
    age: "22",
    fatherName:"hello",
    motherName:"hello",
    sslcMark:"23",
    hscMark: "123"
}]
localStorage.setItem('studentDataBase',JSON.stringify(resultDataBase));
describe('test suite for UpdateDetails.js',()=>{
    test("testing the updateDetails()",()=>{
        let result=`<form id="form" method="POST">`+
        `<table><tbody>`+
            `<tr>`+
                `<td><b>FirstName :</b></td>`+
                `<td><input id="firstName" type="text" name="firstName" value="helo" onchange="validate.firstNameValidation()"></td>`+
                `<td><span id="warningForFirstName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Last Name :</b></td>`+
                `<td><input id="lastName" type="text" name="lastName" value="hello" onchange="validate.lastNameValidation()"></td>`+
                `<td><span id="warningForLastName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
               `<td><b>Register.No :</b></td>`+
                `<td><input id="registerNo" type="number" name="registerNo" value="2" onchange="validate.registerNoValidation()" readonly=""></td>`+
                `<td><span id="warningForRegisterNo" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Father's Name:</b></td>`+
                `<td><input id="fatherName" type="text" name="fatherName" value="hello" onchange="validate.fatherNameValidation()"></td>`+
                `<td><span id="warningForFatherName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Mother's Name:</b></td>`+
                `<td><input id="motherName" type="text" name="motherName" value="hello" onchange="validate.motherNameValidation()"></td>`+
                `<td><span id="warningForMotherName" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>Age:</b></td>`+
                `<td><input id="studentAge" type="number" name="studentAge" value="22" onchange="validate.ageValidation()"></td>`+
                `<td><span id="warningForAge" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>SSLC Mark:</b></td>`+
                `<td><input id="sslcMark" type="number" name="sslcMark" value="23" onchange="validate.sslcMarkValidation()"></td>`+
                `<td><span id="warningForSSLC" class="warning"></span></td>`+
            `</tr>`+
            `<tr>`+
                `<td><b>HSC Mark:</b></td>`+
                `<td><input id="hscMark" type="number" name="hscMark" value="123" onchange="validate.hscMarkValidation()"></td>`+
                `<td><span id="warningForHSC" class="warning"></span></td>`+
            `</tr></tbody>`+
        `</table>`+
    `</form>`+
    `<button id="register" onclick="update.updateForm()">Update</button>`+
    `<span id="message"></span>`;
        document.getElementById('registerNo').value='2';
        updateDetails();
        expect(document.getElementById('viewUpdateDelete').innerHTML).toBe(result);
    })

    test("testing the updateForm()",()=>{
        document.getElementById('firstName').value="Hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=2;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=500;
        document.getElementById('hscMark').value=1200;
        updateForm();
        expect(document.getElementById('viewUpdateDelete').innerHTML).toBe("<b>Successfully Updated!!</b>");  
    })

    test("testing the id='viewUpdateDelete' after deletion",()=>{
        document.getElementById('registerNo').value=3;
        updateDetails();
        expect(document.getElementById('viewUpdateDelete').innerHTML).toBe("<b>NO DATA AVAILABLE!!</b>");
    })

    test("testing the local Storage",()=>{
        document.getElementById('firstName').value="Hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=2;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=500;
        document.getElementById('hscMark').value=1200;
        result=[{
            firstName:"helo",
            lastName: "hello",
            registerNo: "1",
            age: "22",
            fatherName:"hello",
            motherName:"hello",
            sslcMark:"23",
            hscMark: "123"
        },{
            firstName:"Hello",
            lastName: "Kumar",
            registerNo: "2",
            age: "23",
            fatherName:"Hello",
            motherName:"Hello",
            sslcMark:"500",
            hscMark: "1200"
        }]
        updateForm();
        expect(JSON.parse(localStorage.getItem('studentDataBase'))).toEqual(result);
    })
})