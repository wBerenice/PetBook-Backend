const btnAgregar = document.getElementById("btnAgregar");
const itemsContainer = document.getElementById("container");
let publicaciones = [];
let btnLike = document.getElementById("btnLike");
//let likes = document.getElementById("likes")
//DOM FORMULARIO
let btnEnviar = document.getElementById("btnEnviar");
let txtNombre = document.getElementById("txtNombre");
let txtDescripcion = document.getElementById("txtDescripcion");
//DOM CERRAR SESION
let btnCerrar = document.getElementById("btnCerrarSesion");
//let inputImg = document.getElementById("inputImg");
let base64Img = "";
let imageUrl;

let alertaValidaciones = document.getElementById("alertaValidaciones");
let alertaValidacionesTexto = document.getElementById(
  "alertaValidacionesTexto"
);
let imagentemp = document.getElementById("imagentemp");
let validos = 0;
let idTimeout;

//REGEX nombre
//Este REGEX ya incluye el mínimo de caracteres 2 y el máximo es indeterminado
let nombreRegex = /^[a-zA-Z0-9A-ZÁÉÍÓÚ a-zñáéíóú(?¿:.*[@$¡!^\-_)]{2,}$/;

//Este REGEX ya incluye el mínimo de caracteres 10 y el máximo es indeterminado
let descriptionRegex = /^[a-zA-Z0-9A-ZÁÉÍÓÚ a-zñáéíóú(?¿:.*[@$¡!^\-_)]{10,}$/; //No acepta corchetes []


const tmpimagen = document.getElementById("tmpimagen");
const textArea = document.getElementById("textArea");




function validarNombre() {
  //LISTO NOMBRE
  txtNombre.value = txtNombre.value.trim().replaceAll("  ", "");
  if (txtNombre.value.match(nombreRegex) == null) {
    txtNombre.style.border = "solid red 5px";
    alertaValidaciones.style.display = "block";
    alertaValidaciones.innerHTML += `<li>El nombre debe contener más de dos carácteres</li>`;
  } else {
    txtNombre.style.border = "solid green 5px";
    validos++;
    return true;
  }
} //validarNombre

function validarDescripcion() {
  // LISTO MENSAJE
  txtDescripcion.value = txtDescripcion.value.trim().replaceAll("  ", "");

  if (txtDescripcion.value.length === 0) {
    alertaValidaciones.style.display = "block";
    alertaValidaciones.innerHTML += `<li>El mensaje no puede estar vacio</li>`;
    txtDescripcion.style.border = "solid red 5px";
  }

  if (txtDescripcion.value.match(descriptionRegex) == null) {
    alertaValidaciones.style.display = "block";
    alertaValidaciones.innerHTML += `<li>El mensaje debe contener 10 carácteres como mínimo</li>`;
    txtDescripcion.style.border = "solid red 5px";
  } else {
    txtDescripcion.style.border = "solid green 5px";
    validos++;
    return true;
  }
} //validarDescripcion

function quitarAlertas() {
  if (
    txtNombre.value.match(nombreRegex) != null &&
    txtDescripcion.value.match(descriptionRegex) != null
  ) {
    alertaValidaciones.style.display = "none";
  }
}

function temporizador() {
  if (idTimeout != undefined && idTimeout != null) {
    clearTimeout(idTimeout);
  }

  if (validos == 2) {
    idTimeout = setTimeout(function () {
      txtNombre.style.border = "";
      txtDescripcion.style.border = "";
      alertaValidaciones.style.display = "none";
    }, 2000);
  } //==4
}

//EVENTO===============================================================================

btnEnviar.addEventListener("click", function (event) {
  event.preventDefault();

  alertaValidaciones.innerHTML = ""; //separacion entre los alerts y las cards
  	if (validarNombre() == true && validarDescripcion() == true) {
    quitarAlertas();
    temporizador();

    // setLocal(publicaciones);

   
    realizarFetchDePost();
    //Limpia los campos nombres y descripción
    txtNombre.value = "";
    txtDescripcion.value = "";
  
    tmpimagen.src = "";
base64Img = "";
imageUrl="";

    txtNombre.focus();
    
   
  }
  //    let inputFocused="";
  //  let elements = document.querySelectorAll("input[type='text'], input[type='password']");
  //  for (let i =0; i<elements.length;i++){
  //    elements[i].addEventListener("focus", function(){
  //      inputFocused = this;
  //      inputFocused.value="";
  //   });
  // }
});//btnEnviar - Fin
txtNombre.addEventListener("blur", function (event) {
  event.preventDefault();
  event.target.value = event.target.value.trim();
});
txtDescripcion.addEventListener("blur", function (event) {
  event.preventDefault();
  event.target.value = event.target.value.trim();
});

function addItem( urlImg, name, description) {
 return{
    foto: urlImg,
    titulo: name,
    descripcion: description,
  }
}

function setLocal(arr) {
  window.localStorage.setItem("publicaciones", JSON.stringify(arr));
}

function renderItems(items) {
  console.log("prueba")
  itemsContainer.innerHTML = "";

  items.forEach((item) =>
    itemsContainer.insertAdjacentHTML("afterbegin", chooseRender(item))
  );
}
let itemId = 0;
function chooseRender(item) {
  
  const markupImg = `
  <div class="row justify-content-center">
    <div class="card card-img" >
      <img src="${item.foto}" class="card-img-top img" alt="${item.descripcion}">
      <div class="card-body">
      <button type="button" class="btn btn-outline-secondary btn-like" id="btnLike" value="1" data-counter  data-id="${itemId}" ></button>
      <span id = "likes">
      </span>
        <h4 class="card-title text-center">${item.titulo}</h4>
        <p class="card-text " id = "descripcionTexto">${item.descripcion}</p>
        <p class="card-text " id = "usuario"> publicado por: <b>${usuario}</b><p>

      </div>
    </div>
    </div>
    <script  src="/js/Dospublicaciones.js"> </script>
    `;
    itemId++;
  const markupText = `
  <div class="row justify-content-center">
    <div class="card card-text" >
      <div class="card-body">
        <h5 class="card-title text-center">${item.titulo}</h5>
        <p class="card-text " id ="descripcionTexto">${item.descripcion}</p>
        <p class="card-text " id = "usuario"> publicado por: <b>${usuario}</b><p>
      </div>
    </div>
    </div>
    `;
    
  return item.foto ? markupImg : markupText;
  
}

function obtenerLocalStorage() {
  let publicacion = localStorage.getItem("publicaciones");
  if (!publicacion) return;
  publicaciones = JSON.parse(publicacion);
}

window.addEventListener("load", () => {
  // obtenerLocalStorage();
  console.log("load")
  realizarFetchDeGet();//peticion GET
  renderItems(publicaciones);
  
});

//borrar los datos de inicio de sesion al momento de cerrarla
btnCerrar.addEventListener("click", function (event) {

  window.location.href = "login.html";
});

//  let cant1 = 0;
//  const cajas = document.querySelectorAll("#container");
//  cajas.forEach((item)=>
// item.addEventListener("click", (event) => {
//   const clickedElement = event.target;
//   if (!clickedElement.matches("#btnLike")) {
//     return;
//   }
//   let megusta = document.querySelector("#likes");
//   megusta.innerHTML = cant1 + `<p>Croquetas</p>`;
//   cant1++;
//   event.stopPropagation();
//  })); 

const mascota = localStorage.getItem("usuarios");
let nombreMascota = JSON.parse(mascota);
let usuario = nombreMascota[0].usuario
console.log(usuario)



const btnsLike = document.querySelectorAll('.btn-like');

// let count = 0;
// document.addEventListener("click", function(e){
//   if(e.target && e.target.classList.contains("btn-like")){
//      //const count = parseInt(e.target.innerHTML);

//      e.target.innerHTML = count++;
//   }
// });

const counters = {};
document.addEventListener("click", function(e){
  if(e.target && e.target.classList.contains("btn-like")){
    const cardId = e.target.getAttribute("data-id");
    if (!counters[cardId]) {
      counters[cardId] = 0;
    }
    counters[cardId]++;
    document.querySelector(`[data-id="${cardId}"] + span`).innerHTML = `<p>a <b>${counters[cardId]}</b> mascotas les hace mover la colita</p>` ;
  }
});

async function realizarFetchDePost() {
  const data = {
	  descripcion: txtDescripcion.value,
    titulo: txtNombre.value,
    foto: !imageUrl ? "" : imageUrl
  };
  const response = await fetch("https://petbook-generation.up.railway.app/api/publicaciones/", {
    method: "POST",
    headers: {
     "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
  });

  const post = await response.json();
renderItem(post);
}

 //const data =     { descripcion: txtDescripcion.value,
  //          titulo: txtNombre.value  ,
    //      foto: base64Img
 //};

// fetch("http://localhost:8080/api/publicaciones/", {
 //  method: 'POST', // or 'PUT'
   //headers: {
     //'Content-Type': 'application/json',
   //},
  // body: JSON.stringify(data),
 //})
 //.then(response => response.json())
 //.then(data => {
  // console.log('Success:', data);
 //})
 //.catch((error) => {
 //  console.error('Error:', error);
 //});
 
 
 //FETCH para GET publicaciones y renderizar en la página

async function realizarFetchDeGet() {
  const response = await fetch("https://petbook-generation.up.railway.app/api/publicaciones/",{
    
      method: "GET",
      headers: {
      "Content-Type": "application/json"
      },
    }
  );

  console.log(response);

  const getPublicaciones = await response.json();
  publicaciones = getPublicaciones;
renderItems(publicaciones);

  console.log(publicaciones);
  return 
}


var myWidget = cloudinary.createUploadWidget({
  cloudName: 'dfodg322v', 
  uploadPreset: 'ubdqamv7'}, (error, result) => { 
    if (!error && result && result.event === "success") { 
      console.log('Done! Here is the image info: ', result.info); 
      imageUrl = result.info.secure_url;
      tmpimagen.src = imageUrl;
    }
  }
)
document.getElementById("upload_widget").addEventListener("click", function(){
    myWidget.open();
  }, false);

  
  function renderItem(item) {
    itemsContainer.insertAdjacentHTML("afterbegin", chooseRender(item));
}