var fechaNacimiento = document.getElementById('birthdate');
var fechaMaxima = new Date();

fechaMaxima.setFullYear(fechaMaxima.getFullYear() - 16);
fechaMaxima = fechaMaxima.toISOString().substr(0, 10);

fechaNacimiento.setAttribute('max', fechaMaxima);