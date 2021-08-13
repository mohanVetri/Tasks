const{getStudentDataBase}=require("./AddingDetail")
function deleteDetail() {
    let studentDataBase=getStudentDataBase();
    let resultDataBase=studentDataBase.filter((IndividualDetail)=>{
        return IndividualDetail.registerNo!=document.getElementById('registerNo').value;
    })
    localStorage.setItem('studentDataBase',JSON.stringify(resultDataBase));
    document.getElementById("viewUpdateDelete").innerHTML="<b>Deleted Successfully!!</b>";
}
module.exports={deleteDetail}