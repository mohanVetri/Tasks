const {sortingByTitle,sortingByCompleted,myResolve,myReject}=require("../Sorting");
const Sorting =require("../Sorting");
var obj=[{title:"hello",completed:true},{title:"mohan",completed:false},{title:"abc",completed:true}];
const requestMock=jest.spyOn(Sorting,"requestToRetriveData");
requestMock.mockImplementation((myResolve,myReject,condition)=>myResolve(JSON.stringify(obj),condition))


describe("test suite for Sorting.js",()=>{
    test("Checking the sortingByTitle",()=>{
        let arr=[];
        const resultArr=[{title:"abc",completed:true},{title:"hello",completed:true},{title:"mohan",completed:false}];
        expect(sortingByTitle(arr,obj)).toEqual(resultArr);
    })
    
    test("checking the myResolve for title",()=>{
        const resultArr=[{title:"abc",completed:true},{title:"hello",completed:true},{title:"mohan",completed:false}];
        expect(myResolve(JSON.stringify(obj),"title")).toEqual(resultArr);
    })
    
    
    test("checking the myResolve for CompletedTask",()=>{
        const resultArr=[{title:"hello",completed:true},{title:"abc",completed:true}];
        expect(myResolve(JSON.stringify(obj),true)).toEqual(resultArr);
    })
    
    test("checking the myResolve for UnCompletedTask",()=>{
        const resultArr=[{title:"mohan",completed:false}];
        expect(myResolve(JSON.stringify(obj),false)).toEqual(resultArr);
    })
    
    
    test("checking the myResolve for Both task",()=>{
        const resultArr=[{title:"hello",completed:true},{title:"abc",completed:true},{title:"mohan",completed:false}];
        expect(myResolve(JSON.stringify(obj),"completed")).toEqual(resultArr);
    })
    
    test("checking the requestToServer for Title ",()=>{
        const resultArr=[{title:"abc",completed:true},{title:"hello",completed:true},{title:"mohan",completed:false}];
        const consoleSpy=jest.spyOn(console,"log");
        Sorting.requestToRetriveData(myResolve,myReject,"title");
        expect(consoleSpy).toHaveBeenCalledWith(resultArr);
    })
    
    
    test("checking the requestToServer for Completed Task ",()=>{
        const resultArr=[{title:"hello",completed:true},{title:"abc",completed:true}];
        const consoleSpy=jest.spyOn(console,"log");
        Sorting.requestToRetriveData(myResolve,myReject,true);
        expect(consoleSpy).toHaveBeenCalledWith(resultArr);
    })
    
    test("checking the requestToServer with UnCompletedTask ",()=>{
        const resultArr=[{title:"mohan",completed:false}];
        const consoleSpy=jest.spyOn(console,"log");
        Sorting.requestToRetriveData(myResolve,myReject,false);
        expect(consoleSpy).toHaveBeenCalledWith(resultArr);
    })
    
    test("checking the requestToServer with Both Tasks ",()=>{
        const resultArr=[{title:"hello",completed:true},{title:"abc",completed:true},{title:"mohan",completed:false}];
        const consoleSpy=jest.spyOn(console,"log");
        Sorting.requestToRetriveData(myResolve,myReject,"completed");
        expect(consoleSpy).toHaveBeenCalledWith(resultArr);
    })
    
    test("Checking the sortingByCompleted for Completed task!!",()=>{
        let arr=[];
        const resultArr=[{title:"hello",completed:true},{title:"abc",completed:true}];
        expect(sortingByCompleted(arr,obj,true)).toEqual(resultArr);
    })
    
    test("Checking the sortingByCompleted for UnCompleted task!!",()=>{
        let arr=[];
        const resultArr=[{title:"mohan",completed:false}];
        expect(sortingByCompleted(arr,obj,false)).toEqual(resultArr);
    })
    
    test("checking the myReject",()=>{
        expect(myReject("error")).toEqual("error");
    })
    
})
