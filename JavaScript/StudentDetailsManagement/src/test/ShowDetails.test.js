const { displayDetails, reset } = require('../ShowDetails');
document.body.innerHTML = `<span id="detailsTable"></span>`

describe("Test Suite for ShowDetails", () => {
    test("testing the displayDetails", () => {
        displayDetails();
        let output = "<h3>No Details Found!!</h3>";
        expect(document.getElementById('detailsTable').innerHTML).toBe(output)
    })

    test("testing the displayDetails after adding a Student Details", () => {
        let result = [{
            firstName: "Hello",
            lastName: "Hi",
            registerNo: "1",
            fatherName: "hello",
            motherName: "helo",
            age: "21",
            sslcMark: "100",
            hscMark: "123"
        },{
            firstName: "Hello",
            lastName: "Hi",
            registerNo: "2",
            fatherName: "hello",
            motherName: "helo",
            age: "21",
            sslcMark: "100",
            hscMark: "123"
        }];
        localStorage.setItem('studentDataBase',JSON.stringify(result));
        displayDetails();
        let output = "<table><tbody><tr><th>FirstName</th><th>lastName</th><th>Age</th>"+
        "<th>RegisterNo</th><th>FatherName</th><th>MotherName</th>"+
        "<th>SSLC Mark</th><th>HSC Mark</th>"+
        "</tr><tr><td>Hello</td><td>Hi</td><td>21</td>"+
        "<td>1</td><td>hello</td><td>helo</td><td>100</td>"+
        "<td>123</td></tr><tr><td>Hello</td><td>Hi</td><td>21</td>"+
        "<td>2</td><td>hello</td><td>helo</td><td>100</td>"+
        "<td>123</td></tr></tbody></table><br>";
        expect(document.getElementById('detailsTable').innerHTML).toBe(output)
    })

    test("testing the reset()",()=>{
        reset();
        expect(JSON.parse(localStorage.getItem('studentDataBase'))).toBe(null);
    })
})