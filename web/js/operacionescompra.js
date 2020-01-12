//funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
function _Seleccionarp_(row) {
    ////recupera el idavion de la fila, en la celda 0
    var idProducto = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
    var nom = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    //asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    document.getElementById("txtId").value = idProducto;
    document.getElementById("txtProd").value = nom;

    $(document).ready(function () {
        $("#exampleModal").modal("toggle");
    }

    );
    return false;
}
function _Seleccionarl_(row) {
    ////recupera el idavion de la fila, en la celda 0
    var idLocal = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
    var Local = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    //asigna a las cajas de texto de la ventana padre los valores//obtenidos'
    document.getElementById("txtIdLocal").value = idLocal;
    document.getElementById("txtLocal").value = Local;

    $(document).ready(function () {
        $("#exampleModalLocal").modal("toggle");
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
        var costo = document.getElementById("txtCosto").value;
        var pventa = document.getElementById("txtPrecioV").value;
        var vf=parseFloat(document.getElementById("txtcantidad").value)*parseFloat(document.getElementById("txtCosto").value);
        if (document.getElementById("id" + id)) {/* Que hacer si existe */
            document.getElementById("cantidad" + id).value = parseFloat(document.getElementById("txtcantidad").value) + parseFloat(document.getElementById("cantidad" + id).value);
            document.getElementById("vf" + id).value = (parseFloat(document.getElementById("txtcantidad").value)*parseFloat(document.getElementById("txtCosto").value)) + parseFloat(document.getElementById("vf" + id).value);
            document.getElementById("txtTotal").value = (parseFloat(document.getElementById("txtcantidad").value)*parseFloat(document.getElementById("txtCosto").value)) + parseFloat(document.getElementById("txtTotal").value);
            document.getElementById("txtId").value = "";
            document.getElementById("txtProd").value = "";
            document.getElementById("txtcantidad").value = "";
            document.getElementById("txtCosto").value = "";
            document.getElementById("txtPrecioV").value = "";
        } else {
            var nuevaFila = "<tr><td class 'td'><input type='text' value='" + id + "' name='id' id='id" + id + "' class='form-control idp' readonly='readonly' ></td> \
                                    <td class 'td1><input type='text'value='" + producto + "' name='producto' class='form-control producto' readonly='readonly'></td> \
                                    <td class 'td2'><input type='text'value='" + costo + "' id='costo" + id + "' name='costo'class='form-control costo' readonly='readonly'></td> \
                                    <td class 'td3'><input type='text'value='" + pventa + "' name='precioVenta' class='form-control pventa' readonly='readonly'></td> \
                                    <td class 'td4'><input type='text'value='" + cantidad + "'cantidad name='cantidad' id='cantidad" + id + "' class='form-control cantidad'></td> \
                                    <td class 'td6'><input type='text'value='" + vf + "' name='vf' id='vf" + id + "' class='form-control vf' readonly='readonly'></td> \
                                    <td class ='td5'><input type='button' onclick='restar(" + id + ");' class='del btn btn-danger eliminar' value='X'></td> \
                            </tr>"

                    ;

            if (validarfor() == true) {//validar que los compos deben estar llenos
                $("#tabla tbody").append(nuevaFila);
                document.getElementById("txtTotal").value = parseFloat(document.getElementById("txtTotal").value) + parseFloat(document.getElementById("vf" + id).value);
                document.getElementById("txtId").value = "";
                document.getElementById("txtProd").value = "";
                document.getElementById("txtcantidad").value = "";
                document.getElementById("txtCosto").value = "";
                document.getElementById("txtPrecioV").value = "";

            } else {
                alert("Los campos con los datos de la compra no deben estar vacios")
            }
        }
        if(document.getElementById("id1")!=""){//validar salida de pagina si hay compra en proceso
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
    var txt4 = document.getElementsByName("txtCosto")[0].value;
    var txt5 = document.getElementsByName("txtPrecioV")[0].value;
    if ((txt1 == "") || (txt2 == "") || (txt3 == "") || (txt4 == "") || (txt5 == "")) {  //COMPRUEBA CAMPOS VACIOS

        return false;
    } else {
        return true;
    }

}
function restar(id) {
    document.getElementById("txtTotal").value = parseFloat(document.getElementById("txtTotal").value) - parseFloat(document.getElementById("vf" + id).value);
}
