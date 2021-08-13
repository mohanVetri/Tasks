
var readyState=function (){
    console.log("hello");
    let obj=JSON.stringify([{title:"hello",completed:true},{title:"mohan",completed:false},{title:"abc",completed:true}]);
    resolve(obj,condition);
}
module.exports=readyState;