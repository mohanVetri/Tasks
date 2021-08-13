const { addingDetails, isRegisterNoExist, getStudentDataBase } =require("../AddingDetail");
document.body.innerHTML = `
<td><input id="firstName" type="text" name="firstName" onchange="firstNameValidation()"></td>
<td><input id="lastName" type="text" name="lastName" onchange="lastNameValidation()"></td>
<td><input id="fatherName" type="text" name="fatherName" onchange="fatherNameValidation()"></td>
<td><input id="motherName" type="text" name="motherName" onchange="motherNameValidation()"></td>
<td><input id="studentAge" type="number" name="studentAge" onchange="ageValidation()"></td>
<td><input id="sslcMark" type="number" name="sslcMark" onchange="sslcMarkValidation()"></td>
<td><input id="hscMark" type="number" name="hscMark" onchange="hscMarkValidation()"></td>
<td><input id="registerNo" type="number" name="registerNo" onchange="registerNoValidation()"></td>
<span id='message'></span>`;

describe("test suite for the Adding Details", () => {
    beforeEach(()=>{
        localStorage.clear();
    })
    test("testing the isRegisterNoExist() for new RollNo", () => {
        document.getElementById('registerNo').value = 1;
        expect(isRegisterNoExist()).toBe(false);
    })

    test("testing the isRegisterNoExist() for existing RollNo", () => {
        studentDataBase=[{
            firstName:"helo",
            lastName: "hello",
            registerNo: "1",
            age: "22",
            fatherName:"hello",
            motherName:"hello",
            sslcMark:"23",
            hscMark: "123"
        }]
        localStorage.setItem('studentDataBase',JSON.stringify(studentDataBase));
        document.getElementById('registerNo').value = 1;
        expect(isRegisterNoExist()).toBe(true);
    })

    test("testing the document for id='message' for valid Values", () => {
        document.getElementById('firstName').value = "Hello";
        document.getElementById('lastName').value = "Hello";
        document.getElementById('registerNo').value = 1;
        document.getElementById('fatherName').value = "Hello";
        document.getElementById('motherName').value = "Hello";
        document.getElementById('studentAge').value = 22;
        document.getElementById('sslcMark').value = 22;
        document.getElementById('hscMark').value = 22;
        addingDetails();
        expect(document.getElementById('message').innerHTML).toBe('Successfully Added!!!');
    })

    test("testing the document for localStorage for valid Values", () => {
        document.getElementById('firstName').value = "Hello";
        document.getElementById('lastName').value = "Hello";
        document.getElementById('registerNo').value = 1;
        document.getElementById('fatherName').value = "Hello";
        document.getElementById('motherName').value = "Hello";
        document.getElementById('studentAge').value = 22;
        document.getElementById('sslcMark').value = 22;
        document.getElementById('hscMark').value = 22;
        addingDetails();
        expect(JSON.parse(localStorage.getItem('studentDataBase')).length).toBe(1);
    })


    test("testing the document for id='message' for Invalid Values", () => {
        document.getElementById('firstName').value = "Hello";
        document.getElementById('lastName').value = "Hello";
        document.getElementById('registerNo').value = 1;
        document.getElementById('fatherName').value = "Hello";
        document.getElementById('motherName').value = "Hello";
        document.getElementById('studentAge').value = 22;
        document.getElementById('sslcMark').value = 22;
        document.getElementById('hscMark').value = 22;
        addingDetails();
        addingDetails();
        expect(document.getElementById('message').innerHTML).toBe("RegisterNo is Already Existed!!!");
    })

    test("testing the document for localStorage for Invalid Values", () => {
        document.getElementById('firstName').value = "Hello";
        document.getElementById('lastName').value = "Hello";
        document.getElementById('registerNo').value = 1;
        document.getElementById('fatherName').value = "Hello";
        document.getElementById('motherName').value = "Hello";
        document.getElementById('studentAge').value = 22;
        document.getElementById('sslcMark').value = 22;
        document.getElementById('hscMark').value = 22;
        addingDetails();
        addingDetails();
        expect(JSON.parse(localStorage.getItem('studentDataBase')).length).toBe(1);
    })


    test("testing the getStudentDataBase()", () => {
        let result = [];
        expect(getStudentDataBase()).toEqual(result);
    })

})