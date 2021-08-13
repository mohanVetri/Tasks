const fs=require('fs');
let user={
    firstName: "hello",
    LastName: "hello"
}
    fs.writeFile("./newFile",JSON.stringify(user),()=> {
        console.log("Created SuccessFully!!");
    });