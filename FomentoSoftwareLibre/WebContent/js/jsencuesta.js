var n = 3;
var p = 2;
function addRespuesta(){
	var capa = document.getElementById("respu");
	var capa2 = document.createElement("div");
	var label = document.createElement("label");
	var texto = document.createElement("input");
	label.innerHTML = "Respuesta "+n+" ";
	texto.type = "text";
	texto.name = "resp"+p+""+n;
	texto.id ="res"+p+""+n;
	capa2.id = "res"+p+""+n;
	capa.appendChild(capa2);
	capa2.appendChild(label);
	capa2.appendChild(texto);
	capa2.innerHTML+="<br/>";
	n++;	
} 

function addPregunta(){
	n=3;
	var capa = document.getElementById("preg");
	var capa2 = document.createElement("div");
	var label = document.createElement("label");
	var labelp1 = document.createElement("label");
	var labelp2 = document.createElement("label");
	var texto = document.createElement("input");
	var textop1 = document.createElement("input");
	var textop2 = document.createElement("input");
	label.innerHTML ="Enunciado de la pregunta "+p+": ";
	labelp1.innerHTML="Respuesta 1";
	labelp2.innerHTML="Respuesta 2";
	texto.type = "text";
	texto.name = "pre"+p;
	texto.id = "pre"+p;
	/*textop1.type = "text";
	textop1.name = "res"+p"1";
	textop1.id = "res"+p"1";
	textop2.type = "text";
	textop2.name = "res"+p+"2";
	textop2.id = "res"+p"2";*/
	capa2.id= "pre"+p;
	capa.appendChild(capa2);
	capa2.appendChild(label);
	capa2.appendChild(texto);
	capa2.innerHTML+="<br/>";
	capa2.appendChild(labelp1);
	//capa2.appenChild(textop1);
	capa2.inneHTML+="<br/>";
	capa2.appendChild(labelp2);
	//capa2.appendChild(textop2);
	capa2.inneHTML+="<br/>";
	p++;
}
