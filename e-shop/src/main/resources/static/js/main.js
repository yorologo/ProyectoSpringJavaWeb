console.log("Hello World")
function fun(){
    console.log("Hello World")
}

function sumaElementos() {
	var count = document.getElementById("numProductos").value
    var total = 0
    for (let index = 0; index < count; index++) {
        total += Math.round(parseFloat(document.getElementById("cantidad" + index).value.replace(",",".")) * parseFloat(document.getElementById("precio" + index).innerHTML.substr(1)) * 100) /100
    }
    console.log(total)
    document.getElementById("first-modal-body").innerHTML = `$ ${total}`
}