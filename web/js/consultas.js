
function enviar(id){
    
     document.location.href ="SConsultas?accion=finalizar&id="+id;
}
function cancelar(id){
    
     document.location.href ="SConsultas?accion=cancelar&id="+id;
}


//funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
function _Seleccionar_(row) {
    ////recupera el idavion de la fila, en la celda 0
    var expe = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
    location.href ="SConsultas?accion=seleccionar&id=" + expe;

}
function restar(id) {
    document.getElementById("txtTotal").value = parseFloat(document.getElementById("txtTotal").value) - parseFloat(document.getElementById("precio"+id).value);;
     
}


function _SeleccionarT_(row) {
    ////recupera el idavion de la fila, en la celda 0
        var id = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
        var tra = row.cells[1].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
        var precio = row.cells[2].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
        if(document.getElementById("id"+id)){/* Que hacer si existe */
            alert("Tratamiento ya ha sido agregado!!!");
            
        }else {/* Que hacer si no existe */
            var nuevaFila = "<tr><td><input type='text' value='" + id + "' name='id' id='id"+ id+"' class='form-control' readonly='readonly' ></td> \
            <td><input type='text'value='" + tra + "' name='tra'  class='form-control' readonly='readonly'></td> \
            <td><input type='text'value='" + precio + "' name='pre' id='precio"+id+"' id class='form-control' readonly='readonly'></td> \
            <td><input type='button' onclick='restar("+id+");'  class='del btn btn-danger' value='Eliminar'></td> \
            </tr>"
                    ;
                    
            $("#tabla tbody").append(nuevaFila);
            $("#modalTra").modal("hide");
            
            
            document.getElementById("txtTotal").value = parseFloat(document.getElementById("txtTotal").value) + parseFloat(document.getElementById("precio"+id).value);
        }
        
                    

}

$(document).ready(function () {
    
    // evento para eliminar la fila
    $("#tabla").on("click", ".del", function () {
        $(this).parents("tr").remove();
    });  
});
