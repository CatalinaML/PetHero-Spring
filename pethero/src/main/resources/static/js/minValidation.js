//Fecha actual
const today = new Date();
//Formateado
var todayFormat;
if(today.getMonth() < 10){
    var monthFormat = "0" + (today.getMonth()+1);
    todayFormat = today.getFullYear() + "-" + monthFormat + "-" + today.getDate();
}else{
    todayFormat = today.getFullYear() + "-" + (today.getMonth()+1) + "-" + today.getDate();
}

//Fecha final
//Formateado para conseguir el date
const inputEnd = document.getElementById("endDate").value;

const componentsEnd = inputEnd.split("-");
const yearE = componentsEnd[0];
const monthE = componentsEnd[1];
const dayE = componentsEnd[2];

const formatDateEnd = yearE + "/" + monthE + "/" + dayE;

const endDate = new Date(formatDateEnd);

//Fecha inicial
//Formateado para conseguir el date
const inputStart = document.getElementById("startDate").value;

const componentsStart = inputStart.split("-");
const yearS = componentsStart[0];
const monthS = componentsStart[1];
const dayS = componentsStart[2];

const formatDateStart = yearS + "/" + monthS + "/" + dayS;

const startDate = new Date(formatDateStart);
//Formateado
var startDateFormat
if(startDate.getMonth() < 10){
    var monthFormat = "0" + (startDate.getMonth()+1);
    startDateFormat = startDate.getFullYear() + "-" + monthFormat + "-" + startDate.getDate();
}else{
    startDateFormat = startDate.getFullYear() + "-" + (startDate.getMonth()+1) + "-" + startDate.getDate();
}

if(today > endDate){ //No hay fechas disponibles
console.log(todayFormat);
document.getElementById("startDateInput").setAttribute("min", todayFormat);
}else{
if(today > startDate){
    document.getElementById("startDateInput").setAttribute("min", todayFormat);
}else{
console.log(startDateFormat);
    document.getElementById("startDateInput").setAttribute("min", startDateFormat);
}
}