const{deleteDetail}=require("../DeleteDetails")

document.body.innerHTML=`<span id="viewUpdateDelete"></span>
<td><input id="registerNo" type="number" name="registerNo" onchange="registerNoValidation()"></td>`;
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

describe("Test Suite for DeleteDetails.js",()=>{
    test("testing the deleteDetail()",()=>{
        document.getElementById('registerNo').value=2;
        deleteDetail();
        expect(document.getElementById('viewUpdateDelete').innerHTML).toBe("<b>Deleted Successfully!!</b>")
    })

    test("testing the localStorage after Deletion",()=>{
        document.getElementById('registerNo').value=2;
        deleteDetail();
        expect(JSON.parse(localStorage.getItem('studentDataBase'))).toEqual([{
            firstName:"helo",
            lastName: "hello",
            registerNo: "1",
            age: "22",
            fatherName:"hello",
            motherName:"hello",
            sslcMark:"23",
            hscMark: "123"
        }]);
    })

})