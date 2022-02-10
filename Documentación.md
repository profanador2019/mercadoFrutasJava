<b>Intro:</b>
<br>El mercado de concentración es un establecimiento donde se centraliza la comercialización mayorista de frutas y hortalizas para una ciudad, teniendo como clientes a supermercados, verdulerías, entre otros comercios. Cuenta con cientos de empresas denominadas “puestos” los cuales son independientes entre si y comercializan distintos tipos de alimentos. Tienen un funcionamiento similar para la venta de productos.
<p><b>Proceso de ventas:</b>
<br>El cliente llega al puesto, es atendido por un vendedor el cual asesora y toma el pedido en una boleta, los precios de los artículos son definidos por el vendedor para cada cliente. Una vez finalizado el pedido el cliente se dirije con la boleta a abonar por caja. Una vez abonado el pedido puede ser retirado si el mismo fue preparado cuando cliente lo desee.
<p><b>Requerimientos:</b>
<br>•	ABMC (todos): Cliente, pedido, articulo, proveedor, personal.
<br>•	CU complejo nivel resumen (1): “Gestion de mercaderías”
<br>•	Listado complejo (1): Clientes morosos
<br>•	Niveles de acceso (2): Vendedor/Cajero, Dueño de puesto
<br>•	Manejo de errores
<br>•	Publicar el sitio






<p><b>Modelo del dominio:</b>

<br>![Md](./img/md.png)

<p><b>Casos de uso:</b>
<p><b>Caso de uso de sistema resumen reestructurado:</b> “Gestión de mercaderías”
<br>Actor primario: Vendedor
<br>Meta: Realizar venta
<br>Camino Básico:
<br>1 – Ingresan mercaderías provenientes de los proveedores. Se ejecuta CUU "Ingreso de mercaderías".
<br>2 – Cliente llega al puesto para realizar compra invocando CUU "Compra en puesto".
<br>3 – El dueño ingresa al sistema para obtener listado de deudores invocando CUU "Listar deudores".


<p><b>Caso de uso de usuario:</b> “Ingreso de mercaderías”
<br>Actor primario: Cajero
<br>Meta: Actualizar stock de mercaderías
<br>Camino básico:
<br>1 – Se ingresa en el depósito la nueva mercadería. El sistema lo registra.

<p><b>Caso de uso de usuario:</b> “Compra en puesto”
<br>Actor primario: Cliente
<br>Meta: Comprar artículos
<br>Precondiciones de sistema:Vendedor logueado
<br>Camino básico:
<br>1 – Cliente realiza compra de artículos, si el cliente es nuevo se lo registra, el vendedor valida disponibilidad y registra la venta en el sistema.
<br>2 – Cliente abona pedido por caja, el sistema registra pedido y emite comprobante.
<br>3 – Cliente retira pedido, el vendedor lo registra en el sistema.
<br>Caminos alternativos:
<br>1.a<durante> “Artículo o cantidad no disponible”
	<br>1.a.1 – El sistema muestra mensaje. Vuelta a paso 1
<br>2.a<durante> “El cliente no abona pedido y solicita fiado”
	<br>2.a.1 – El sistema registra deuda y emite comprobante.
	<br>2.a.2 – Ir a paso 3.
<br>2.b<durante> “El cliente no abona el pedido y se rechaza el fiado”
	<br>2.b.1 – El sistema cancela pedido. FCU
<br>2.c<posterior> “El cliente no retira el pedido”
	<br>3.a.1 – El sistema lo registra.

<p><b>Caso de uso de usuario:</b> “Listar deudores”
<br>Actor primario: Dueño
<br>Meta: Identificar deudores morosos
<br>Camino básico:
<br>1 – El dueño se loguea en el sistema ingresando usuario y clave. El sistema valida.
<br>2 – El dueño ingresa un monto minimo de deuda. El sistema emite listado con dni, apellido, nombre de los clientes que igualen o superen el monto ingresado.
<br>3 – El dueño selecciona enviar mail. El sistema envía email de notificación a cada uno de los clientes morosos.
<br>Caminos alternativos:
<br>1.a<durante> “Usuario o clave invalida”
	<br>1.a.1 – El sistema muestra mensaje “usuario o clave invalida”
	<br>1.a.2 – Vuelta a paso 1.
<br>2.a<durante> “No hay clientes deudores que superen el monto”
	<br>2.a.1 – FCU.

