jest.mock("../requestToServer");
const{getRequiredStructure,myResolve,myReject}=require("../User");
const consoleSpy=jest.spyOn(console,"log");
test("testing the flow",()=>{
    requestToRetriveData(myResolve,myReject,"GET","hello");
});