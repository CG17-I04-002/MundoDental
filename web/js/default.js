$(document).ready(function () {
    $('#tb1').DataTable({
        //Poder seleccionar 1 Columna
        responsive: true,
        select: true,
        //Configuracion del lenguaje del datatable
        "language": {
            sProcessing: "Procesando...",
            sLengthMenu: "Mostrar _MENU_ Registros",
            sZeroRecords: "No se encontraron resultados",
            sEmptyTable: "Ningún dato disponible en esta tabla",
            sInfo: "_START_ - _END_ ",
            sInfoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
            sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
            sInfoPostFix: "",
            sSearch: "Buscar:",
            sUrl: "",
            sInfoThousands: ",",
            
            sLoadingRecords: "Cargando...",
            "paginate": {
                "first": "Primera",
                "last": "Última",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            select: {
            rows: {
                _: "",
                0: "",
                1: ""
            }
        }
        },
        "lengthMenu": [5, 10, 20, 25],
    });
    $('#example1').DataTable({
        //Poder seleccionar 1 Columna
        select: true,
        //Configuracion del lenguaje del datatable
        "language": {
            sProcessing: "Procesando...",
            sLengthMenu: "Mostrar _MENU_ Registros",
            sZeroRecords: "No se encontraron resultados",
            sEmptyTable: "Ningún dato disponible en esta tabla",
            sInfo: "_START_ - _END_ ",
            sInfoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
            sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
            sInfoPostFix: "",
            sSearch: "Buscar:",
            sUrl: "",
            sInfoThousands: ",",
            sLoadingRecords: "Cargando...",
            "paginate": {
                "first": "Primera",
                "last": "Última",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            
        },
        
        "lengthMenu": [4],
    });


});
