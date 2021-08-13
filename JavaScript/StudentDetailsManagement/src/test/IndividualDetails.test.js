const{getIndividualDetails,isStudentDetailExisted,showOutput}=require("../IndividualDetails")
document.body.innerHTML=` <input type="number" id="registerNo"/>
<span id="output"></span>
<span id="viewUpdateDelete"></span>`;

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
describe("test suite for Individual Details",()=>{
    test("testing the isStudentDetailExisted()",()=>{
        document.getElementById('registerNo').value="3";
        expect(isStudentDetailExisted()).toBe(false);
    })
    test("testing the isStudentDetailExisted()",()=>{
        document.getElementById('registerNo').value="2";
        expect(isStudentDetailExisted()).toBe(true);
    })

    test("testing the showOutput()",()=>{
        document.getElementById('registerNo').value="3";
        showOutput();
        expect(document.getElementById('output').innerHTML).toBe("<h3><i>No such Records</i></h3>");
    })

    test("testing the showOutput() for id='output'",()=>{
        document.getElementById('registerNo').value="2";
        showOutput();
        let outputHTML=`<h3>Records Existed!!</h3><br>`+
        `<button onclick="view.viewDetails()">View</button> `+
        `<button onclick="update.updateDetails()">Edit</button> `+
        `<button onclick="deleteModule.deleteDetail()">Delete</button><br>`;
        expect(document.getElementById('output').innerHTML).toBe(outputHTML);
    })

    test("testing the showOutput() for id='viewUpdateDelete'",()=>{
        document.getElementById('registerNo').value=3;
        showOutput();
        expect(document.getElementById('viewUpdateDelete').innerHTML).toBe("");
    })



    test("testing the getIndividualDetails() for non-existed registerNo",()=>{
        document.getElementById('registerNo').value="3";
        expect(getIndividualDetails()).toEqual("");
    })

    test("testing the getIndividualDetails() for existed registerNo",()=>{
        document.getElementById('registerNo').value="2";
        result={firstName:"helo",
            lastName: "hello",
            registerNo: "2",
            age: "22",
            fatherName:"hello",
            motherName:"hello",
            sslcMark:"23",
            hscMark: "123"
        };
        expect(getIndividualDetails()).toEqual(result);
    })
})