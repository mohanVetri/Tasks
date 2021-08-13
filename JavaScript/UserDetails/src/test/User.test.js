const {getRequiredStructure,myResolve,myReject}=require("../User")
const User=require("../User");
const requestMock=jest.spyOn(User,"requestToRetriveData");
requestMock.mockImplementation((myResolve,myReject, httpmethod , urlForSpecificUser)=>myResolve(JSON.stringify(response)));


var response = {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
        }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
        "name": "Romaguera-Crona",
        "catchPhrase": "Multi-layered client-server neural-net",
        "bs": "harness real-time e-markets"
    }
};

var expectedStructure = {
    "Sincere@april.biz": {
        city: "Gwenborough",
        companyName: "Romaguera-Crona",
        firstName: "Leanne",
        id: 1,
        lastName: "Graham",
        phone: "1-770-736-8031 x56442",
        username: "Bret",
        zipcode: "92998-3874"
    }
};


describe("test suite for UserDetails",()=>{
    test("Testing the getRequiredStructure", () => {
        expect(getRequiredStructure(response)).toEqual(expectedStructure);
    })
    
    test('Testing the myResolve', () => {
        const consoleSpy = jest.spyOn(console, 'log');
        myResolve(JSON.stringify(response));
        expect(consoleSpy).toHaveBeenCalledWith(expectedStructure);
      });
    
    test('Testing the myReject',()=>{
        const consoleSpy = jest.spyOn(console, 'log');
        myReject("error");
        expect(consoleSpy).toHaveBeenCalledWith("error");
    })
    
    test("Testing the requestToRetriveData",()=>{
        const consoleSpy = jest.spyOn(console, 'log');
        User.requestToRetriveData(myResolve,myReject,"GET","https://jsonplaceholder.typicode.com/users/1")
        expect(consoleSpy).toHaveBeenCalledWith(expectedStructure);
    })
})

