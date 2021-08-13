const fs = require('fs');

// var data = fs.readFileSync("./newFile",);
// console.log(typeof data);
// var strData = String.fromCharCode(...data);
// console.log(strData);

fs.readFile('./src/CreateFile.js', function (err, data) {
    if (data != null) {
        let strData = String.fromCharCode(...data);
        console.log(strData);
    }
    else
        console.log("error" + err);
})