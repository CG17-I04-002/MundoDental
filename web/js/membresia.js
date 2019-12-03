
function _SeleccionarB_(row) {
    ////recupera el idavion de la fila, en la celda 0
        var expediente = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
        var nombre = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                                               
        if(document.getElementById("id"+expediente)){/* Que hacer si existe */
            alert("Beneficiario ya ha sido agregado!!!");
            
        }else {/* Que hacer si no existe */
             var nuevaFila = "<tr><td><input type='text' value='" + expediente + "'name='id' id='id"+expediente+"' class='form-control' readonly='readonly' ></td> \
                                    <td><input type='text'value='" + nombre + "' name='nombreMembresia' class='form-control' readonly='readonly'></td> \
                                     \
                                    <td><input type='button' class='del btn btn-danger' value='Eliminar'></td> \
                            </tr>"
                    
            $("#tabla tbody").append(nuevaFila);
            
            $("#exampleModalb").modal("hide");
        }
                 

}
function _SeleccionarP_(row) {
    ////recupera el idavion de la fila, en la celda 0
        var expediente = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
        var nombre = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
        var apellido = row.cells[2].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                                               
        document.getElementById("txtexpediente").value = expediente;
        document.getElementById("txtNombre").value = nombre+" " +apellido;
        
        $("#exampleModalp").modal("hide");
                 

}
