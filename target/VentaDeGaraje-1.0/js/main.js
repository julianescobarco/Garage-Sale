/* global ordenarProducto */

var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-saldo").html(user.saldo.toFixed(2) + "$");

        getProducto(false, "ASC");

        $("#ordenar-seccion").click(ordenarProducto);
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
function getProducto(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarProducto(parsedResult);
            } else {
                console.log("Error recuperando los datos de los productos");
            }
        }
    });
}
function mostrarProducto(producto) {

    let contenido = "";

    $.each(producto, function (index, producto) {

        producto = JSON.parse(producto);
        let precio;

        if (producto.inventario > 0) {

            if (user.premium) {

                if (producto.novedad) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (producto.novedad) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + producto.id + '</th>' +
                    '<td>' + producto.nombre + '</td>' +
                    '<td>' + producto.seccion + '</td>' +
                    '<td>' + producto.vendedor + '</td>' +
                    '<td>' + producto.inventario + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + producto.id + '" disabled ';
            if (producto.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="comprarProducto(' + producto.id + ',' + precio + ');" class="btn btn-success" ';
            if (user.saldo < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Comprar</button></td></tr>'

        }
    });
    $("#producto-tbody").html(contenido);
}
