const AddingDetail=require('../AddingDetail');
const { firstNameValidation, lastNameValidation,registerNoValidation,fatherNameValidation, motherNameValidation, ageValidation, sslcMarkValidation, hscMarkValidation, validation, submitForm } = require("../Validation");

document.body.innerHTML = `<form id="form" action="registration" method="POST">
<td><input id="firstName" type="text" name="firstName" onchange="firstNameValidation()"></td>
<td id="demo"><span id="warningForFirstName" class="warning"></span></td>
<td><input id="lastName" type="text" name="lastName" onchange="lastNameValidation()"></td>
<td><span id="warningForLastName" class="warning"></span></td>
<td><input id="registerNo" type="number" name="registerNo" onchange="ageValidation()"></td>
<td><span id="warningForRegisterNo" class="warning"></span></td>
<td><input id="fatherName" type="text" name="fatherName" onchange="fatherNameValidation()"></td>
<td><span id="warningForFatherName" class="warning"></span></td>
<td><input id="motherName" type="text" name="motherName" onchange="motherNameValidation()"></td>
<td><span id="warningForMotherName" class="warning"></span></td>
<td><input id="studentAge" type="number" name="studentAge" onchange="ageValidation()"></td>
<td><span id="warningForAge" class="warning"></span></td>
<td><input id="sslcMark" type="number" name="sslcMark" onchange="sslcMarkValidation()"></td>
<td><span id="warningForSSLC" class="warning"></span></td>
<td><input id="hscMark" type="number" name="hscMark" onchange="hscMarkValidation()"></td>
<td><span id="warningForHSC" class="warning"></span></td>
<span id='message'></span>`;

describe("Test Suite for the Validation", () => {
    test("testing the firstNameValidation for Empty Value", () => {
        document.getElementById('firstName').value ="";
        expect(firstNameValidation()).toBe(false);
    })

    test("testing the firstNameValidation for small FirstLetter", () => {
        document.getElementById('firstName').value = "mohan";
        expect(firstNameValidation()).toBe(false);
    })

    test("testing the firstNameValidation for ValidParameter", () => {
        document.getElementById('firstName').value = "Mohan";
        expect(firstNameValidation()).toBeTruthy();
        expect(document.getElementById("warningForFirstName").innerHTML).toBe("");
    })

    test("testing the document for id=warningForFirstName for null", () => {
        document.getElementById('firstName').value = "";
        firstNameValidation();
        expect(document.getElementById("warningForFirstName").innerHTML).toBe("*firstName should not be empty");
    })

    test("testing the document for id=warningForFirstName for small FirstLetter", () => {
        document.getElementById('firstName').value = "mohan";
        firstNameValidation();
        expect(document.getElementById("warningForFirstName").innerHTML).toBe("*first letter of firstName should be in capital");
    })

    test("testing the document for id=warningForFirstName for ValidParameter", () => {
        document.getElementById('firstName').value = "Mohan";
        firstNameValidation();
        expect(document.getElementById("warningForFirstName").innerHTML).toBe("");
    })

    test("testing the lastNameValidation for Empty Value", () => {
        document.getElementById('lastName').value = "";
        expect(lastNameValidation()).toBe(false);
    })

    test("testing the lastNameValidation for Small firstletter", () => {
        document.getElementById('lastName').value = "hello";
        expect(lastNameValidation()).toBe(false);
    })

    test("testing the lastNameValidation for Valid Parameter", () => {
        document.getElementById('lastName').value = "Hello";
        expect(lastNameValidation()).toBe(true);
    })

    test("testing the document for id=warningForLastName for null", () => {
        document.getElementById('lastName').value = "";
        lastNameValidation();
        expect(document.getElementById("warningForLastName").innerHTML).toBe("*lastName should not be empty");
    })

    test("testing the document for id=warningForLastName for small FirstLetter", () => {
        document.getElementById('lastName').value = "mohan";
        lastNameValidation();
        expect(document.getElementById("warningForLastName").innerHTML).toBe("*first letter of lastName should be in capital");
    })

    test("testing the document for id=warningForLastName for small FirstLetter", () => {
        document.getElementById('lastName').value = "Mohan";
        lastNameValidation();
        expect(document.getElementById("warningForLastName").innerHTML).toBe("");
    })

    test("testing the registerNoValidation for empty Value",()=>{
        document.getElementById("registerNo").value="";
        expect(registerNoValidation()).toBe(false);
    })

    test("testing the registerNoValidation for exceeding the required Value",()=>{
        document.getElementById("registerNo").value=101;
        expect(registerNoValidation()).toBe(false);
    })

    test("testing the registerNoValidation for Valid Value",()=>{
        document.getElementById("registerNo").value=100;
        expect(registerNoValidation()).toBe(true);
    })

    test("testing the document for id='warningForRegisterNo' for empty Value",()=>{
        document.getElementById("registerNo").value="";
        registerNoValidation();
        expect(document.getElementById('warningForRegisterNo').innerHTML).toBe("*RegisterNo should not be empty");
    })

    test("testing the document for id='warningForRegisterNo' for exceeding the required Value",()=>{
        document.getElementById("registerNo").value=101;
        registerNoValidation();
        expect(document.getElementById('warningForRegisterNo').innerHTML).toBe("*RegisterNo should be greater than 0 and less than or equal to 100");
    })

    test("testing the document for id='warningForRegisterNo' for empty Value",()=>{
        document.getElementById("registerNo").value=100;
        registerNoValidation();
        expect(document.getElementById('warningForRegisterNo').innerHTML).toBe("");
    })


    test("testing the fatherNameValidation for empty Value",()=>{
        document.getElementById("fatherName").value="";
        expect(fatherNameValidation()).toBe(false);
    })

    test("testing the fatherNameValidation for small Firstletter",()=>{
        document.getElementById("fatherName").value="mohan";
        expect(fatherNameValidation()).toBe(false);
    })

    test("testing the fatherNameValidation for Valid Parameter",()=>{
        document.getElementById("fatherName").value="Mohan";
        expect(fatherNameValidation()).toBe(true);
    })

    test("testing the document for id='warningForFatherName' for null",()=>{
        document.getElementById("fatherName").value="";
        fatherNameValidation();
        expect(document.getElementById("warningForFatherName").innerHTML).toBe("*fatherName should not be empty");
    })

    test("testing the document for id='warningForFatherName' for small First letter",()=>{
        document.getElementById("fatherName").value="mohan";
        fatherNameValidation();
        expect(document.getElementById("warningForFatherName").innerHTML).toBe("*first letter of the fatherName should be in capital");
    })

    test("testing the document for id='warningForFatherName' for ValidParameter",()=>{
        document.getElementById("fatherName").value="Mohan";
        fatherNameValidation();
        expect(document.getElementById("warningForFatherName").innerHTML).toBe("");
    })

    test("testing the motherNameValidation for empty Value",()=>{
        document.getElementById("motherName").value="";
        expect(motherNameValidation()).toBe(false);
    })

    test("testing the motherNameValidation for small firstletter",()=>{
        document.getElementById("motherName").value="mohan";
        expect(motherNameValidation()).toBe(false);
    })

    test("testing the motherNameValidation for Valid Parameter",()=>{
        document.getElementById("motherName").value="Mohan";
        expect(motherNameValidation()).toBe(true);
    })
    test("testing the document for id='warningForMotherName' for empty Value",()=>{
        document.getElementById("motherName").value="";
        motherNameValidation();
        expect(document.getElementById('warningForMotherName').innerHTML).toBe("*motherName should not be empty");
    })

    test("testing the document for id='warningForMotherName' for small firstLetter",()=>{
        document.getElementById("motherName").value="mohan";
        motherNameValidation();
        expect(document.getElementById('warningForMotherName').innerHTML).toBe("*first letter of the motherName should be in Capital");
    })

    test("testing the document for id='warningForMotherName' for empty Value",()=>{
        document.getElementById("motherName").value="Mohan";
        motherNameValidation();
        expect(document.getElementById('warningForMotherName').innerHTML).toBe("");
    })

    test("testing the ageValidation for empty Value",()=>{
        document.getElementById("studentAge").value="";
        expect(ageValidation()).toBe(false);
    })
    test("testing the ageValidation for exceeding the required length",()=>{
        document.getElementById("studentAge").value=300;
        expect(ageValidation()).toBe(false);
    })

    test("testing the ageValidation for Valid Age",()=>{
        document.getElementById("studentAge").value=20;
        expect(ageValidation()).toBe(true);
    })

    test("testing the document for id='warningForAge' for empty Value",()=>{
        document.getElementById('studentAge').value="";
        ageValidation();
        expect(document.getElementById('warningForAge').innerHTML).toBe("*Age should not be empty");
    })

    test("testing the document for id='warningForAge' for exceeding the required length",()=>{
        document.getElementById('studentAge').value=300;
        ageValidation();
        expect(document.getElementById('warningForAge').innerHTML).toBe("*Age should  be in two digit and greater than 0");
    })

    test("testing the document for id='warningForAge' for Valid Age",()=>{
        document.getElementById('studentAge').value=30;
        ageValidation();
        expect(document.getElementById('warningForAge').innerHTML).toBe("");
    })

    test("testing the sslcMarkValidation for empty Value",()=>{
        document.getElementById("sslcMark").value="";
        expect(sslcMarkValidation()).toBe(false);
    })
    test("testing the sslcMarkValidation for exceeding the required length",()=>{
        document.getElementById("sslcMark").value=600;
        expect(sslcMarkValidation()).toBe(false);
    })

    test("testing the sslcMarkValidation for Valid Age",()=>{
        document.getElementById("sslcMark").value=500;
        expect(sslcMarkValidation()).toBe(true);
    })

    test("testing the document for id='warningForSSLC' for empty Value",()=>{
        document.getElementById('sslcMark').value="";
        sslcMarkValidation();
        expect(document.getElementById('warningForSSLC').innerHTML).toBe("*sslc Mark should not be empty");
    })

    test("testing the document for id='warningForSSLC' for exceeding the required length",()=>{
        document.getElementById('sslcMark').value=600;
        sslcMarkValidation();
        expect(document.getElementById('warningForSSLC').innerHTML).toBe("*sslc Mark should  be less than or equal to 500 and greater than 0");
    })

    test("testing the document for id='warningForSSLC' for Valid SSLC Mark",()=>{
        document.getElementById('sslcMark').value=500;
        sslcMarkValidation();
        expect(document.getElementById('warningForSSLC').innerHTML).toBe("");
    })

    test("testing the hscValidation for empty Value",()=>{
        document.getElementById("hscMark").value="";
        expect(hscMarkValidation()).toBe(false);
    })

    test("testing the hscValidation for exceeding the required Value",()=>{
        document.getElementById("hscMark").value=1300;
        expect(hscMarkValidation()).toBe(false);
    })

    test("testing the hscValidation for Valid HSC Mark",()=>{
        document.getElementById("hscMark").value=1200;
        expect(hscMarkValidation()).toBe(true);
    })

    test("testing the document for id='warningForHSC for empty value",()=>{
        document.getElementById("hscMark").value="";
        hscMarkValidation();
        expect(document.getElementById('warningForHSC').innerHTML).toBe("*hsc Mark should not be empty");
    })
    test("testing the document for id='warningForHSC for empty value",()=>{
        document.getElementById("hscMark").value=1300;
        hscMarkValidation();
        expect(document.getElementById('warningForHSC').innerHTML).toBe("*hsc Mark should be less than or equal to 1200 and greater than 0");
    })
    test("testing the document for id='warningForHSC for empty value",()=>{
        document.getElementById("hscMark").value=1200;
        hscMarkValidation();
        expect(document.getElementById('warningForHSC').innerHTML).toBe("");
    })

    test("testing the validation for InValid FirstName",()=>{
        document.getElementById('firstName').value="hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(false);
    })

    test("testing the validation for InValid lastName",()=>{
        document.getElementById('firstName').value="Hello";
        document.getElementById('lastName').value="";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(false);
    })

    test("testing the validation for InValid registerNo",()=>{
        document.getElementById('firstName').value="Hello";
        document.getElementById('lastName').value="";
        document.getElementById('registerNo').value=-23;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(false);
    })


    test("testing the validation for InValid fatherName",()=>{
        document.getElementById('firstName').value="hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(false);
    })

    test("testing the validation for InValid motherName",()=>{
        document.getElementById('firstName').value="hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(false);
    })

    test("testing the validation for InValid studentAge",()=>{
        document.getElementById('firstName').value="hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value="";
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(false);
    })

    test("testing the validation for InValid sslcMark",()=>{
        document.getElementById('firstName').value="hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value="";
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(false);
    })

    test("testing the validation for InValid hscMark",()=>{
        document.getElementById('firstName').value="hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value="";
        expect(validation()).toBe(false);
    })

    test("testing the validation for Valid Parameters",()=>{
        document.getElementById('firstName').value="Hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=400;
        document.getElementById('hscMark').value=1000;
        expect(validation()).toBe(true);
    })

    test("testing the submitForm() for Invalid Parameters",()=>{
        document.getElementById('firstName').value="Hello";
        document.getElementById('lastName').value="";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=500;
        document.getElementById('hscMark').value=1200;
        let addingDetails=jest.spyOn(AddingDetail,"addingDetails");
        submitForm();
        expect(addingDetails).toHaveBeenCalledTimes(0);
    })

    test("testing the submitForm() for Valid Parameters",()=>{
        document.getElementById('firstName').value="Hello";
        document.getElementById('lastName').value="Kumar";
        document.getElementById('registerNo').value=100;
        document.getElementById('fatherName').value="Hello";
        document.getElementById('motherName').value="Hello";
        document.getElementById('studentAge').value=23;
        document.getElementById('sslcMark').value=500;
        document.getElementById('hscMark').value=1200;
        let addingDetails=jest.spyOn(AddingDetail,"addingDetails");
        submitForm();
        expect(addingDetails).toHaveBeenCalledTimes(0);
    })


})