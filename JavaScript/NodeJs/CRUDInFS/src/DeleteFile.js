const fs=require('fs');

    fs.unlink("./newFile",()=> {
        console.log('Deleted Successfully!!');
    })    