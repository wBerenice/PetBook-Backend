const URL = "https://petbook-generation.up.railway.app/api/login/";
let usuario;
let inputpassword = document.getElementById("input_password");
let inputcorreo= document.getElementById("input_nombre");
const button = document.getElementById('btnRegistro');

const divEl = document.querySelector(".alerts");

function renderAlert(message) {
    const markup = `
    <div class="alert alert-danger" role="error">
      <h6>Datos incorrectos</h6>
      <li>${message}</li>
    </div>
    `;
  
    divEl.innerHTML = markup;
}

const postUsuarios = async function (URL, correo, contrasena){
    const response = await fetch (URL,
    {
    method: "POST",
    headers: {
     "Content-Type": "application/json"
    },
    body: JSON.stringify({
		"correo": correo,
		"contrasena": contrasena
	})
  }
    );
    const data = await response.json();
    console.log(data);
    validarLogin(data);
    
}

const validarLogin = function (usuario){
    if (!usuario) {
        renderAlert("El correo o la contraseña son incorrectos");
        return;
    }else{
        window.location.href = "Publicaciones.html";
        
    }
    
}

button.addEventListener('click', function() {
	if(!inputcorreo.value)return;
	if(!inputpassword.value)return;

     postUsuarios(URL, inputcorreo.value, inputpassword.value);
		 
         
  });