//funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
function _Seleccionarp_(row) {
    ////recupera el idavion de la fila, en la celda 0
    var idProducto = row.cells[0].innerHTML; //recupera descripcion del avion de la fila, en la celda 1
    var nom = row.cells[1].innerHTML; //asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    var exist = row.cells[2].innerHTML;
    //asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    document.getElementById("txtId").value = idProducto;
    document.getElementById("txtProd").value = nom;
    document.getElementById("txtexist").value = exist;
    $(document).ready(function () {
        $("#exampleModal").modal("toggle");
    }
    );
    return false;
}
//funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
function _Seleccionarpacientes_(row) {
    ////recupera el idavion de la fila, en la celda 0
    var expe = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
    var nom = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    var ape = row.cells[2].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    document.getElementById("txtIdp").value = expe;
    document.getElementById("txtPac").value = nom + " " + ape;
    $(document).ready(function () {
        $("#exampleModalpacientes").modal("toggle");
    }
    );
    return false;
}
$(document).ready(function () {
    /**
     * Funcion para añadir una nueva fila en la tabla
     */
    $("#add").click(function () {
        var id = document.getElementById("txtId").value;
        var producto = document.getElementById("txtProd").value;
        var cantidad = document.getElementById("txtcantidad").value;
        var existencia = document.getElementById("txtexist").value;
        var pventa = document.getElementById("txtPrecioV").value;
        var vf=parseFloat(document.getElementById("txtcantidad").value)*parseFloat(document.getElementById("txtPrecioV").value);
        if (document.getElementById("id" + id)) {/* Que hacer si existe */
            document.getElementById("cantidad" + id).value = parseFloat(document.getElementById("txtcantidad").value) + parseFloat(document.getElementById("cantidad" + id).value);
            document.getElementById("vf" + id).value = (parseFloat(document.getElementById("txtcantidad").value)*parseFloat(document.getElementById("txtPrecioV").value)) + parseFloat(document.getElementById("vf" + id).value);
            document.getElementById("txtTotal").value = (parseFloat(document.getElementById("txtcantidad").value)*parseFloat(document.getElementById("txtPrecioV").value)) + parseFloat(document.getElementById("txtTotal").value);
            document.getElementById("txtId").value = "";
            document.getElementById("txtProd").value = "";
            document.getElementById("txtcantidad").value = "";
            document.getElementById("txtexist").value = "";
            document.getElementById("txtPrecioV").value = "";
        } else {
            var nuevaFila = "<tr><td class 'td'><input type='text' value='" + id + "' name='id' id='id" + id + "' class='form-control idp' readonly='readonly' ></td> \
                              <td class 'td1'><input type='text'value='" + producto + "' name='producto' class='form-control producto' readonly='readonly'></td>\
                                <td class 'td4'><input type='text'value='" + cantidad + "'cantidad name='cantidad' id='cantidad" + id + "' class='form-control cantidad'></td> \
                                <td class 'td3'><input type='text'value='" + pventa + "' name='precioVenta' id='precioVenta" + id + "' class='form-control pventa' readonly='readonly'></td> \
                                <td class 'td6'><input type='text'value='" + vf + "' name='vf' id='vf" + id + "' class='form-control vf' readonly='readonly'></td> \
                                <td class ='td5'><input type='button' onclick='restar(" + id + ");' class='del btn btn-danger eliminar' value='X'></td> \
            <td class 'td3'><input type='text'value='0' name='costo' id='costo" + id + "' class='form-control costo' hidden='' readonly='readonly'></td> \
                                </tr>";
            if (validarfor() == true) {//VALIDAR QUE LOS CAMPOS ESTEN LLENOS
                $("#tabla tbody").append(nuevaFila);
                document.getElementById("txtTotal").value = parseFloat(document.getElementById("txtTotal").value) + parseFloat(document.getElementById("vf" + id).value);
                document.getElementById("txtId").value = "";
                document.getElementById("txtProd").value = "";
                document.getElementById("txtcantidad").value = "";
                document.getElementById("txtexist").value = "";
                document.getElementById("txtPrecioV").value = "";

            } else {
                alert("Los campos con los datos de la compra no deben estar vacios")
            }
        }
        if (document.getElementById("id1") != "") {//validar salida de pagina si hay compra en proceso
            var bPreguntar = true;

            window.onbeforeunload = preguntarAntesDeSalir;

            function preguntarAntesDeSalir() {
                var respuesta;

                if (bPreguntar) {
                    respuesta = confirm();

                    if (respuesta) {
                        window.onunload = function () {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
    });

// evento para eliminar la fila
    $("#tabla").on("click", ".del", function () {
        $(this).parents("tr").remove();
    });

});
/*--------------------------------------*/
function validarfor() {

    var txt1 = document.getElementById("txtId").value;
    var txt2 = document.getElementsByName("txtProd")[0].value;
    var txt3 = document.getElementsByName("txtcantidad")[0].value;
    var txt5 = document.getElementsByName("txtPrecioV")[0].value;
    if ((txt1 == "") || (txt2 == "") || (txt3 == "") ||  (txt5 == "")) {  //COMPRUEBA CAMPOS VACIOS

        return false;
    } else {
        return true;
    }

}
function restar(id) {
    document.getElementById("txtTotal").value = parseFloat(document.getElementById("txtTotal").value) - parseFloat(document.getElementById("vf" + id).value);
}
function validarexistencia(){
    var exist=parseFloat(document.getElementById("txtexist").value);
    var cantd=parseFloat(document.getElementById("txtcantidad").value);
    if(cantd>exist){
        alert("La cantidad a vender supera las existencias del producto");
       document.getElementById("txtcantidad").value="";
    }else if(cantd<=0){
        alert("La cantidad a vender no pueder ser cero o menor que cero");
        document.getElementById("txtcantidad").value="";
    }
    return false;
}