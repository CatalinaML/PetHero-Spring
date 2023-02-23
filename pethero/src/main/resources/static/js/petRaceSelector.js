var opciones = document.getElementsByName('type');

opciones.forEach(function(opcion){
   opcion.addEventListener('click', function(){
     var opcionSeleccionada = document.querySelector('input[name = "type"]:checked').value;
     document.getElementById('dogRace').style.display = (opcionSeleccionada == 'Perro') ? 'block' : 'none';
     document.getElementById('catRace').style.display = (opcionSeleccionada == 'Gato') ? 'block' : 'none';
   });
});

function raceSelectedDog(breeds) {
    var hidden = document.getElementById('raceInput');
    var select = document.getElementById('dogRace');
    hidden.value = select.value;
    var breedImage = document.getElementById("breedImage");
    breedImage.src = breeds.filter(breed => breed.name === select.value)[0].image.url
}

function raceSelectedCat(breeds) {
    var hidden = document.getElementById('raceInput');
    var select = document.getElementById('catRace');
    hidden.value = select.value;
    var breedImage = document.getElementById("breedImage");
    var imageId = breeds.filter(breed => breed.name === select.value)[0].reference_image_id;
    axios.get('http://localhost:8080/image/' + imageId).then(function (response) {
         breedImage.src = response.data;
    })
}