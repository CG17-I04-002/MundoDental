function _Seleccionar_(row) {
    ////recupera el idavion de la fila, en la celda 0
    var expe = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
    location.href ="SReportes?accion=historialMedico&id=" + expe;

}
