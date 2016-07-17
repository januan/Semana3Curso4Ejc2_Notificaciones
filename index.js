var express = require('express');
var app = express();
app.set('port', (process.env.PORT || 5000));

var bodyParser = require("body-parser");
app.use(bodyParser.json()); //soporte para codificar json
app.use(bodyParser.urlencoded({extended: true})); //soporte para decodificar las URL

//para poder conectar con bbdd Firebase
var firebase = require("firebase");
firebase.initializeApp({
  serviceAccount: "Puppies-5c6089c03aef.json",
  databaseURL: "https://puppies-b04e6.firebaseio.com"
});

//para poder enviar notificaciones:
var FCM = require("fcm-push");





app.use(express.static(__dirname + '/public'));

// views is directory for all template files
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/android', function(request, response) {
  response.render('pages/index');
});


//https://warm-stream-32312.herokuapp.com/registrar-usuario
//usuario_instagram
//id_dispositivo (token)
//id_usuario_instagram
var usuariosInstagramURI="registrar-usuario";
app.post("/"+usuariosInstagramURI, function(request, response){
	var id_disp = request.body.id_dispositivo; //token
	var id_user = request.body.id_usuario_instagram;
	var nom_usuario = request.body.nombre_usuario_instagram;
	
	var db = firebase.database();
	var usuariosInstagram = db.ref(usuariosInstagramURI).push();
	usuariosInstagram.set({
		id_dispositivo: id_disp,
		id_usuario_instagram: id_user,
		nombre_usuario_instagram: nom_usuario
	});
	
	//para coger el id de la bbdd
	var path = usuariosInstagram.toString();
	var pathSplit = path.split(usuariosInstagramURI+"/");
	var idAutoGenerado = pathSplit[1];

	var resp=generaRespuestaUsuarios(db, idAutoGenerado);
	response.setHeader("Content-Type", "application/json");
	response.send(JSON.stringify(resp));
	
	//response.send(request.body.id_dispositivo);
})


function generaRespuestaUsuarios(db, idAuto){
	var respuesta={};
	var registro = "";
	var ref = db.ref(usuariosInstagramURI);
	ref.on("child_added", function(snapshot, prevChildKey){
		registro = snapshot.val();
		respuesta = {
			/* //sólo se devuelve el id_dispositivo (token) en el JSON
			id: idAuto,
			*/
			id_dispositivo: registro.id_dispositivo
			/* //sólo se devuelve el id_dispositivo (token) en el JSON
			,id_usuario_instagram: registro.id_usuario_instagram
			,nombre_usuario_instagram: registro.nombre_usuario_instagram
			*/
		}
	});
	return respuesta;

}

//https://warm-stream-32312.herokuapp.com/like-generado
//id_dispositivo (token)
//id_usuario_instagram
//id_foto_instagram
var likesInstagramURI="like-generado";
app.post("/"+likesInstagramURI, function(request, response){
	var id_disp = request.body.id_dispositivo; //token
	var id_user = request.body.id_usuario_instagram;
	var id_foto = request.body.id_foto_instagram;
	
	var db = firebase.database();
	var likesInstagram = db.ref(likesInstagramURI).push();
	likesInstagram.set({
		id_dispositivo: id_disp,
		id_usuario_instagram: id_user,
		id_foto_instagram: id_foto
	});
	
	//para coger el id de la bbdd
	var path = likesInstagram.toString();
	var pathSplit = path.split(likesInstagramURI+"/");
	var idAutoGenerado = pathSplit[1];
	//Devuelve lo que haya en la bbdd con ese ID
	var resp=generaRespuestaLikes(db, idAutoGenerado);
	response.setHeader("Content-Type", "application/json");
	response.send(JSON.stringify(resp));
})

function generaRespuestaLikes(db, idAuto){
	var respuesta={};
	var registro = "";
	var ref = db.ref(likesInstagramURI);
	ref.on("child_added", function(snapshot, prevChildKey){
		registro = snapshot.val();
		respuesta = {
			id_dispositivo: registro.id_dispositivo
		}
	});
	return respuesta;
}

//https://warm-stream-32312.herokuapp.com/notifica-usuario
//Pasando id-token del usuario actual, para evitar que sea ese
//pasando id-usr-inst
//pasando fotoUsuario -> URL foto del usuario, para enviarla como dato en la notificación
//busca el id-token de a quien hay que notificar
var notificaUsrURI="notifica-usuario";
//app.get("/"+notificaUsrURI+"/:id_token/:id_usr_inst/:url_foto_usuario", function(request, response){
	//mejor lo paso por post, porque va como parámetro una URL:
	//las variables vienen como "body" en vez de "params"
app.post("/"+notificaUsrURI, function(request, response){	

	var miToken		=request.body.id_token; 
	var idUsrInst 	=request.body.id_usr_inst;
	var urlFotoUsr  =request.body.url_foto_usuario;

	var respuesta = {};
	var registro = "";
	var nombreUsuario ="";

	var db = firebase.database();
	var ref = db.ref(usuariosInstagramURI); //busco entre los usuarios registrados
	var contarEnvios=0;
contarEnvios++;

	ref.once("value", function(snapshot){
	//ref.orderByChild("id_usuario_instagram").equalTo(idUsrInst).on("value", function(snapshot) {
		snapshot.forEach(function(childSnapshot){
	  		
	  		//console.log("key: " + childSnapshot.getKey());
	  		registro=childSnapshot.val();

			if (registro.id_dispositivo!==miToken && registro.id_usuario_instagram==idUsrInst){
				//es el usuario de la foto y no es el dispositivo desde el que hago el lanzamiento
				//tengo que enviarle una notificación

				nombreUsuario=registro.nombre_usuario_instagram;
				
				console.log("Notificación #"+contarEnvios++);//+" a "+registro.id_dispositivo+" para el usuario "+registro.id_usuario_instagram);
				//console.log("id_usuario_instagram: " + registro.id_usuario_instagram);
				//console.log("id_dispositivo: " + registro.id_dispositivo);
				console.log("nombreUsuario: " + nombreUsuario);
				
				var msg="Hola "+registro.nombre_usuario_instagram+". Han clickado una foto tuya";
				enviaNotificacion(registro.id_dispositivo,msg, idUsrInst, nombreUsuario, urlFotoUsr);
				
				contarEnvios++;
				return true; //en cuanto encuentra uno, sale del bucle del forEach
			}

		});
		
	}, function (errorObject) {
		  console.log("La lectura de datos falló: " + errorObject.code);
		  respuesta={
		  	id_usuario_instagram: "self" //para que abra el propio timeline
		  	//,nombre_usuario_instagram: "Puppies" 
		  };
	});
	respuesta ={
					id_usuario_instagram: idUsrInst //registro.id_usuario_instagram,
					//,nombre_usuario_instagram: nombreUsuario // registro.nombre_usuario_instagram
				};
	response.setHeader("Content-Type", "application/json");
	response.send(JSON.stringify(respuesta));
})



function enviaNotificacion(tokenDestinatario, mensaje, idUsuario, nomUsuario, urlFoto){
	var serverKey = 'AIzaSyA6FGygvso09ZYKz3EYWO3yeck4JPnRmtI';
	var fcm = new FCM(serverKey);
	var message = {
	    to: tokenDestinatario, // required
	    collapse_key: '', //'your_collapse_key', 
	    data: { 
	    	idUsu: idUsuario,
	    	nomUsu: nomUsuario,
	    	urlUsu: urlFoto
	    },
	    notification: {
	        title: 'Puppies',
	        body: mensaje,
	        icon: "footprint",
	        sound: "default",
	        color: "#00BCD4"
	    }
	};

	fcm.send(message, function(err, response){
	    if (err) {
	        console.log("Something has gone wrong!");
	    } else {
	        console.log("Successfully sent with response: ", response);
	    }
	});
}

/*
//POST
//https://warm-stream-32312.herokuapp.com/token-device
//token
var tokenDeviceURI ="token-device";
app.post("/"+tokenDeviceURI, function(request, response){
	var token = request.body.token;
	
	var db = firebase.database();
	var tokenDevice = db.ref(tokenDeviceURI).push();
	tokenDevice.set({
		token: token
	});

	var path = tokenDevice.toString();
	var pathSplit = path.split(tokenDeviceURI+"/");
	var idAutoGenerado = pathSplit[1];

	var resp=generaRespuestaAToken(db, idAutoGenerado);
	response.setHeader("Content-Type", "application/json");
	response.send(JSON.stringify(resp));

	//response.send(request.body.token);
})

function generaRespuestaAToken(db, idAuto){
	var respuesta={};
	var usuario = "";
	var ref = db.ref(tokenDeviceURI);
	ref.on("child_added", function(snapshot, prevChildKey){
		usuario = snapshot.val();
		respuesta = {
			id: idAuto,
			token: usuario.token
		}
	});
	return respuesta;

}
*/
app.listen(app.get('port'), function() {
  console.log('Node app is running on port', app.get('port'));
});


