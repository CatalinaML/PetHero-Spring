function dateValidation()
{
    const startDate = document.getElementById("startDate");
    const endDate = document.getElementById("finishDate");

    endDate.setAttribute("min", startDate.value);

    if (!endDate.value) // si todavia no puso fecha final
        endDate.disabled = false;
    else if (startDate.value >= endDate.value)// si ya habia puesto fecha final y la nueva inicial es mayor
        endDate.value = startDate.value;
}

function timeValidation()
{
    let startTime = document.getElementById("startTime");
    let endTime = document.getElementById("endTime");

    let arrayStartTime = startTime.value.split(':');

    if ((parseInt(arrayStartTime[0]) < 10))
        arrayStartTime[0] = `0${(parseInt(arrayStartTime[0]) + 1)}`;
    else
        arrayStartTime[0] = (parseInt(arrayStartTime[0]) + 1).toString();

    endTime.setAttribute("min", arrayStartTime.join(':'));
}

