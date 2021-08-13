const {creationPromise}=require("../Creation");
const creation=require("../Creation");
const promiseMock=jest.spyOn(creationPromise,"then");
promiseMock.mockImplementation((data)=>"Successfully Created");

describe("Test suite for creation opertion",()=>{
    test("testing the creation promise",()=>{
        const consoleSpy=jest.spyOn(console,"log");
        expect(creationPromise.then()).toBe("Successfully Created");
    })
})