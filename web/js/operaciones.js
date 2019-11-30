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
        var consto = document.getElementById("txtCosto").value;
        var pventa = document.getElementById("txtPrecioV").value;
        var nuevaFila = "<tr><td class 'td'><input type='text' value='" + id + "' name='id' class='form-control idp' readonly='readonly' ></td> \
                                    <td class 'td1'><input type='text'value='" + producto + "' name='producto' class='form-control producto' readonly='readonly'></td> \
                                    <td class 'td2'><input type='text'value='" + consto + "' name='costo'class='form-control costo' readonly='readonly'></td> \
                                    <td class 'td3'><input type='text'value='" + pventa + "' name='precioVenta' class='form-control pventa' readonly='readonly'></td> \
                                    <td class 'td4'><input type='text'value='" + cantidad + "' name='cantidad' class='form-control cantidad'></td> \
                                    <td class 'td5'><input type='button' class='del btn btn-danger eliminar' value='X'></td> \
                            </tr>"

                ;
        if(validarfor()==true){
          $("#tabla tbody").append(nuevaFila);
          document.getElementById("txtId").value="";
          document.getElementById("txtProd").value="";
          document.getElementById("txtcantidad").value="";
          document.getElementById("txtCosto").value="";
          document.getElementById("txtPrecioV").value="";
        }else{
            alert("Los campos con los datos de la compra no deben estar vacios")
        }
        
    });

    // evento para eliminar la fila
    $("#tabla").on("click", ".del", function () {
        $(this).parents("tr").remove();
    });

});
/*--------------------------------------*/
function validarfor() {

    var correo = document.getElementById("txtId").value;
    var nom = document.getElementsByName("txtProd")[0].value;
    var rs = document.getElementsByName("txtcantidad")[0].value;
    var tel = document.getElementsByName("txtCosto")[0].value;
    var cel = document.getElementsByName("txtPrecioV")[0].value;
    if ((correo == "") || (nom == "") || (rs == "") || (tel == "") || (cel == "")) {  //COMPRUEBA CAMPOS VACIOS
        
        return false;
    }
    else{
        return true;
    }

}
