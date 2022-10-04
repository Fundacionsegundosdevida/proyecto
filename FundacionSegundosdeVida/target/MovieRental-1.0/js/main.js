var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-cuota_mantenimiento").html(user.cuota_mantenimiento.toFixed(2) + "$");

        getequipo_medicos(false, "ASC");

        $("#ordenar-tipo_equipo").click(ordenarequipo_medicos);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getequipo_medicos(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./Servletequipo_medicoListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarequipo_medicos(parsedResult);
            } else {
                console.log("Error recuperando los datos de las equipo_medicos");
            }
        }
    });
}
function mostrarequipo_medicos(equipo_medicos) {

    let contenido = "";

    $.each(equipo_medicos, function (index, equipo_medico) {

        equipo_medico = JSON.parse(equipo_medico);
        let precio;

        if (equipo_medico.cantidad_equipo > 0) {

            if (user.prioritario) {

                if (equipo_medico.novedad) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (equipo_medico.novedad) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + equipo_medico.id + '</th>' +
                    '<td>' + equipo_medico.nombre_equipo + '</td>' +
                    '<td>' + equipo_medico.tipo_equipo + '</td>' +
                    '<td>' + equipo_medico.marca_equipo + '</td>' +
                    '<td>' + equipo_medico.cantidad_equipo + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + equipo_medico.id + '" disabled ';
            if (equipo_medico.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="alquilarequipo_medico(' + equipo_medico.id + ',' + precio + ');" class="btn btn-success" ';
            if (user.cuota_mantenimiento < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'

        }
    });
    $("#equipo_medicos-tbody").html(contenido);
}

function ordenarequipo_medicos() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getequipo_medicos(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getequipo_medicos(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getequipo_medicos(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}
function alquilarequipo_medico(id, precio) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./Servletequipo_medicoAlquilar",
        data: $.param({
            id: id,
            username: username

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                restarDinero(precio).then(function () {
                    location.reload();
                })
            } else {
                console.log("Error en la reserva de la película");
            }
        }
    });
}


async function restarDinero(precio) {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRestarDinero",
        data: $.param({
            username: username,
            cuota_mantenimiento: parseFloat(user.cuota_mantenimiento - precio)

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                console.log("cuota_mantenimiento actualizado");
            } else {
                console.log("Error en el proceso de pago");
            }
        }
    });
}