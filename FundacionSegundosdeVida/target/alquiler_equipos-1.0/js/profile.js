var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-cuota_mantenimiento").html("$" + user.cuota_mantenimiento.toFixed());

        getAlquiladas(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellidos);
                $("#input-email").val(parsedResult.email);
                $("#input-cuota_mantenimiento").val(parsedResult.cuota_mantenimiento.toFixed(2));
                $("#input-prioritario").prop("checked", parsedResult.prioritario);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getAlquiladas(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAlquilerListar",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(equipo_medicos) {
    let contenido = "";
    if (equipo_medicos.length >= 1) {
        $.each(equipo_medicos, function (index, equipo_medico) {
            equipo_medico = JSON.parse(equipo_medico);

            contenido += '<tr><th scope="row">' + equipo_medico.id + '</th>' +
                    '<td>' + equipo_medico.nombre_equipo + '</td>' +
                    '<td>' + equipo_medico.tipo_equipo + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + equipo_medico.id 
                    + '" disabled ';
            if (equipo_medico.novedad) {
                contenido += 'checked'
            }
            contenido += '></td><td>' + equipo_medico.fechaAlquiler + '</td>' +
                    '<td><button id="devolver-btn" onclick= "devolverequipo_medico(' + equipo_medico.id 
                    + ');" class="btn btn-danger">Devolver equipo_medico</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverequipo_medico(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./Servletequipo_medicoDevolver",
        data: $.param({
            username: username,
            id: id,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el equipo_medico");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let cuota_mantenimiento = $("#input-cuota_mantenimiento").val();
    let prioritario = $("#input-prioritario").prop('checked');
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
            contrasena: contrasena,
            nombre: nombre,
            apellidos: apellidos,
            email: email,
            cuota_mantenimiento: cuota_mantenimiento,
            prioritario: prioritario,
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}