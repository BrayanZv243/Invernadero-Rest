let dataSourceRegistrosRiegos = [];
let idRegistro = 0;

$(document).ready(function () {
    fetchData();

    function fetchData() {
        fetch('http://localhost:8060/planta')
            .then(response => response.json())
            .then(_data => {
                dataSourceRegistrosRiegos = _data
                let _array = [];
                _data.forEach(element => {

                    let ultimaVezRegada = element.registroPlanta.length > 0 ? element.registroPlanta[0].ultima_vez_regada : 'No Data';
                    let ultimaHumedadRegistrada = element.registroPlanta.length > 0 ? element.registroPlanta[0].ultima_humedad : 'No Data';

                    let fechaFormateada = 'No Data'
                    if(ultimaVezRegada !== 'No Data') {
                        fechaFormateada = moment(ultimaVezRegada).format("DD/MM/YYYY - HH:mm");
                    }
                    


                    let array = {
                        "id_planta": element.id_planta,
                        "nombre": element.nombre,
                        "tipo": element.tipo,
                        "humedad_optima": element.humedad_optima,
                        "ultima_vez_regada": fechaFormateada,
                        "ultima_humedad": ultimaHumedadRegistrada
                    }

                    _array.push(array);
                });

                $('#myTable').DataTable({
                    data: _array,
                    columns: [
                        { data: 'id_planta' },
                        { data: 'nombre' },
                        { data: 'tipo' },
                        { data: 'humedad_optima' },
                        {
                            data: 'ultima_vez_regada',
                            render: function (data, type, row, meta) {
                                if (data == 'No Data'){
                                    return 'No Data';
                                }
                                return `${data}<button onclick="verRegistros(${row.id_planta})"href="#myModal" class="btn btn-primary" data-toggle="modal">Registros</button>`;
                            }
                        },
                        {
                            data: 'ultima_humedad',
                            render: function (data, type, row, meta) {
                                if (data == 'No Data') {
                                    return 'No Data';
                                }
                                return `${data}<button onclick="verHumedad(${row.id_planta})"href="#myModalHumedades" class="btn btn-primary" data-toggle="modal">Ver Humedad</button>`;
                            }
                        }
                    ],
                    createdRow: function (row, data, dataIndex) {

                        $(row).append(`
                            <tbody>
                                <tr>
                                <td>
                                    <a href="#editEmployeeModal" onclick="openModalEditarPlanta(${data.id_planta})"class="edit" data-toggle="modal"><i class="material-icons"
                                        data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="#deleteEmployeeModal" onclick="openModalEliminarPlanta(${data.id_planta}) "class="delete" data-toggle="modal"><i class="material-icons"
                                        data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                                </tr>
                            </tbody>
                            `);
                    }
                });

                    // Asignar evento click a los botones "Acción"
                    $('.ver-registros').click(function () {
                        const plantaId = $(this).data('id');
                        verRegistros(plantaId);
                    });

                    $('.editar-planta').click(function () {
                        const plantaId = $(this).data('id');
                        openModalEditarPlanta(plantaId);
                    });

                    $('.eliminar-planta').click(function () {
                        const plantaId = $(this).data('id');
                        openModalEliminarPlanta(plantaId);
                    });

                    $('.ver-humedad').click(function () {
                        const plantaId = $(this).data('id');
                        verHumedad(plantaId);
                    });

            })
            .catch(error => {
                console.error('Error al realizar la petición:', error);
            });
    }

});

function verRegistros(plantaId) {
    //$("#myModal").modal("show");
    $('#misRegistros').DataTable().clear().destroy();
    let ds = dataSourceRegistrosRiegos.filter(d => d.id_planta == plantaId);
    let dsRegistros = []
    
    if (ds[0].registroPlanta.length > 0){
        ds[0].registroPlanta.forEach(element => 
        {

            let ultimaVezRegada = element.ultima_vez_regada;
            var date = new Date(ultimaVezRegada);

            var day = date.getDate(); // Obtiene el día (10)
            var month = date.getMonth(); // Obtiene el mes (5, ya que en JavaScript los meses van de 0 a 11)
            var year = date.getFullYear(); // Obtiene el año (2023)
            var hour = date.getHours(); // Obtiene la hora (12)
            var minutes = date.getMinutes(); // Obtiene los minutos (30)

            let array = {
                "año": year,
                "mes": obtenerNombreMes(month),
                "dia": day,
                "hora": hour,
                "minutos": minutes
            }

            dsRegistros.push(array);

        });
        

        $('#misRegistros').DataTable({
            data: dsRegistros,
            columns: [
                { data: 'año' },
                { data: 'mes' },
                { data: 'dia' },
                { data: 'hora' },
                { data: 'minutos' }
            ],
        });
    }
}

function verHumedad(plantaId) {
    $('#humedades').DataTable().clear().destroy();
    let ds = dataSourceRegistrosRiegos.filter(d => d.id_planta == plantaId);
    let dsRegistros = []

    if (ds[0].registroPlanta.length > 0) {
        ds[0].registroPlanta.forEach(element => {

            let ultima_humedad = element.ultima_humedad;

            let array = {
                "ultima_humedad": ultima_humedad,
            }

            dsRegistros.push(array);

        });


        $('#humedades').DataTable({
            data: dsRegistros,
            columns: [
                { data: 'ultima_humedad' },
            ],
        });
    }
}


function obtenerNombreMes(numeroMes) {
    const meses = [
        'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
        'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'
    ];
    return meses[numeroMes];
}


function openModalEditarPlanta(plantaId){
    idRegistro = plantaId
    let objRegistros = dataSourceRegistrosRiegos.filter(e => e.id_planta == plantaId)[0]
    $('#inputID').val(plantaId)
    $('#inputNombreId').val(objRegistros.nombre)
    $('#inputTipoId').val(objRegistros.tipo)
    $('#inputHumedadId').val(objRegistros.humedad_optima)
}

function openModalEliminarPlanta(plantaId){
    idRegistro = plantaId
    let objRegistros = dataSourceRegistrosRiegos.filter(e => e.id_planta == plantaId)[0]

    $('#inputEliminar').val(objRegistros.nombre)



}

function eliminarPlanta(){
    fetch(`http://localhost:8060/planta/${idRegistro}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },

    })
        .then(response => response.json())
        .then(result => {
            location.reload();
        })
        .catch(error => {
            // Manejar el error
            console.error('Error:', error);
        });
}

function editarPlanta(){
    let nombre = $('#inputNombreId').val()
    let tipo = $('#inputTipoId').val()
    let humedad = $('#inputHumedadId').val()

    let planta = {
        "id_planta":idRegistro,
        "nombre": nombre,
        "tipo": tipo,
        "humedad_optima":humedad
    }

    fetch(`http://localhost:8060/planta/${idRegistro}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(planta)
    })
        .then(response => response.json())
        .then(result => {
            location.reload();
        })
        .catch(error => {
            // Manejar el error
            console.error('Error:', error);
        });
}

function agregarPlanta(){
    let nombre = $('#inputNombreAgregar').val()
    let tipo = $('#tipoAgregar').val()
    let humedad = $('#inputHumedadOptimaAgregar').val()

    let planta = {
        "nombre":nombre,
        "tipo": tipo,
        "humedad": humedad
    }

    fetch(`http://localhost:8060/planta`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(planta)
    })
        .then(response => response.json())
        .then(result => {
            location.reload();
        })
        .catch(error => {
            // Manejar el error
            console.error('Error:', error);
        });

}


