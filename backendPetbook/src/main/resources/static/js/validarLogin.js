const URL = "http:localhost:8080";
const API = "/api/login/";
let usuario;
let inputpassword = document.querySelector("input-password").value
let inputcorreo= document.querySelector("input-nombre").value
const button = document.getElementById('btnRegistro');

function renderAlert(message) {
    const markup = `
    <div class="alert alert-danger" role="error">
      <h6>Datos incorrectos</h6>
      <li>${message}</li>
    </div>
    `;
  
    divEl.innerHTML = markup;
}

const Prueba = async function (URL, API){
    const response = await fetch ((URL+API),
    {
    method: "POST",
    headers: {
     "Content-Type": "application/json"
    },
    body: {
		"correo": "gama@gmail.com",
		"contrasena": "gama1234"
	}
  }
    );
    const data = response.json();
    usuario=data;
    
}

const validarLogin = function (usuario){
    if (usuario) {
        return true;
    }else{
        renderAlert("El correo o la contraseña son incorrectos");
        return false;
        
    }
}

button.addEventListener('click', function() {
     Prueba(URL,API);
     console.log(usuario);
         
  });