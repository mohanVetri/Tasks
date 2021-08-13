const {viewDetails}=require('../ViewDetails')
document.body.innerHTML=`<span id="viewUpdateDelete"></span><input type="number" id="registerNo"/>`;
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
describe('test suite for the ViewDetails.js',()=>{
    test("testing viewDetails()",()=>{
        document.getElementById('registerNo').value="2";
        let result = `<table>`+
        `<tbody><tr>`+
            `<td><b>FirstName :</b></td>`+
            `<td>helo</td>`+
        `</tr>`+
        `<tr>`+
            `<td><b>LastName :</b></td>`+
            `<td>hello</td>`+
        `</tr>`+
        `<tr>`+
            `<td><b>Register.No :</b></td>`+
            `<td>2</td>`+
        `</tr>`+
        `<tr>`+
            `<td><b>Age :</b></td>`+
            `<td>22</td>`+
        `</tr>`+
        `<tr>`+
            `<td><b>FatherName :</b></td>`+
            `<td>hello</td>`+
       `</tr>`+
        `<tr>`+
            `<td><b>MotherName :</b></td>`+
           `<td>hello</td>`+
        `</tr>`+
        `<tr>`+
            `<td><b>SSLCMark :</b></td>`+
            `<td>23</td>`+
        `</tr>`+
        `<tr>`+
            `<td><b>HSCMark :</b></td>`+
            `<td>123</td>`+
        `</tr></tbody>`+
    `</table>`;
    viewDetails();
        expect(document.getElementById('viewUpdateDelete').innerHTML).toBe(result);
    })

    test('testing the viewDetails() for after deletion',()=>{
        document.getElementById('registerNo').value=3;
        viewDetails();
        expect(document.getElementById('viewUpdateDelete').innerHTML).toBe("<b>NO DATA AVAILABLE!!</b>");
    })
})