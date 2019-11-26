$(document).ready(function(){

    $('.nav-trigger').click(function () {
        $('.side-nav').toggleClass('visible');
    });
    $('#tb1').DataTable({
        responsive: true,
        select: true,
        
        "lengthMenu": [5, 10, 20, 25],
        //Configuracion del lenguaje del datatable
        "language": {
            sProcessing: "Procesando...",
            sLengthMenu: "Mostrar _MENU_ Registros",
            sZeroRecords: "No se encontraron resultados",
            sEmptyTable: "Ningún dato disponible en esta tabla",
            sInfo: "",
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
        }
    });
    $('#tb2').DataTable({
        responsive: true,
        select: true,
        
        lengthMenu: [4],
        //Configuracion del lenguaje del datatable
        "language": {
            sProcessing: "Procesando...",
            sLengthMenu: "Mostrar _MENU_ Registros",
            sZeroRecords: "No se encontraron resultados",
            sEmptyTable: "Ningún dato disponible en esta tabla",
            sInfo: "",
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
        }
    });
});

