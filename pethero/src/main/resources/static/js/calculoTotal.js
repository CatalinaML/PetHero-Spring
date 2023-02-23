function calcular(){

    const startTime = document.getElementById("startTime").value;
    const endTime = document.getElementById("endTime").value;

    const startTimeComponents = startTime.split(":");
    const endTimeComponents = endTime.split(":");

    const startHours = parseInt(startTimeComponents[0]);
    const startMinutes = parseInt(startTimeComponents[1]);
    const endHours = parseInt(endTimeComponents[0]);
    const endMinutes = parseInt(endTimeComponents[1]);

    const minutes = (endHours * 60 + endMinutes) - (startHours * 60 + startMinutes);
    const hours = Math.floor(minutes / 60);
    const restMinutes = minutes % 60;

    const startDate = new Date(document.getElementById("startDateInput").value);
    const finishDate = new Date(document.getElementById("finishDate").value);

    const diferenceMiliseconds = finishDate.getTime() - startDate.getTime();
    const days = Math.floor(diferenceMiliseconds / (1000 * 60 * 60 * 24)) + 1;

    const remuneration = document.getElementById("remuneration").value;

    const time = hours * days;

    const horasRem = time * remuneration;
    const minRem = (restMinutes * remuneration) / 60;
    const total = horasRem + minRem;

    var inputValortotal = document.getElementById("total");
    document.getElementById("contenedor").style.display = 'block';
    inputValortotal.value = Math.round(total);
}