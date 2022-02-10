<b>Intro:</b>
El mercado de concentraci�n es un establecimiento donde se centraliza la comercializaci�n mayorista de frutas y hortalizas para una ciudad, teniendo como clientes a supermercados, verduler�as, entre otros comercios. Cuenta con cientos de empresas denominadas �puestos� los cuales son independientes entre si y comercializan distintos tipos de alimentos. Tienen un funcionamiento similar para la venta de productos.
<b>Proceso de ventas:</b>
El cliente llega al puesto, es atendido por un vendedor el cual asesora y toma el pedido en una boleta, los precios de los art�culos son definidos por el vendedor para cada cliente. Una vez finalizado el pedido el cliente se dirije con la boleta a abonar por caja. Una vez abonado el pedido puede ser retirado si el mismo fue preparado cuando cliente lo desee.
<b>Requerimientos:</b>
�	ABMC (todos): Cliente, pedido, articulo, proveedor, personal.
�	CU complejo nivel resumen (1): �Gestion de mercader�as�
�	Listado complejo (1): Clientes morosos
�	Niveles de acceso (2): Vendedor/Cajero, Due�o de puesto
�	Manejo de errores
�	Publicar el sitio






<b>Modelo del dominio:</b>

![Md](./img/md.png)

<b>Casos de uso:</b>
<b>Caso de uso de sistema resumen reestructurado:</b> �Gesti�n de mercader�as�
Actor primario: Vendedor
Meta: Realizar venta
Camino B�sico:
1 � Ingresan mercader�as provenientes de los proveedores. Se ejecuta CUU<Ingreso de mercader�as>.
2 � Cliente llega al puesto para realizar compra invocando CUU<Compra en puesto>.
3 � El due�o ingresa al sistema para obtener listado de deudores invocando CUU<Listar deudores>.


<b>Caso de uso de usuario:</b> �Ingreso de mercader�as�
Actor primario: Cajero
Meta: Actualizar stock de mercader�as
Camino b�sico:
1 � Se ingresa en el dep�sito la nueva mercader�a. El sistema lo registra.

<b>Caso de uso de usuario:</b> �Compra en puesto�
Actor primario: Cliente
Meta: Comprar art�culos
Precondiciones de sistema:Vendedor logueado
Camino b�sico:
1 � Cliente realiza compra de art�culos, si el cliente es nuevo se lo registra, el vendedor valida disponibilidad y registra la venta en el sistema.
2 � Cliente abona pedido por caja, el sistema registra pedido y emite comprobante.
3 � Cliente retira pedido, el vendedor lo registra en el sistema.
Caminos alternativos:
1.a<durante> �Art�culo o cantidad no disponible�
	1.a.1 � El sistema muestra mensaje. Vuelta a paso 1
2.a<durante> �El cliente no abona pedido y solicita fiado�
	2.a.1 � El sistema registra deuda y emite comprobante.
	2.a.2 � Ir a paso 3.
2.b<durante> �El cliente no abona el pedido y se rechaza el fiado�
	2.b.1 � El sistema cancela pedido. FCU
2.c<posterior> �El cliente no retira el pedido�
	3.a.1 � El sistema lo registra.

<b>Caso de uso de usuario:</b> �Listar deudores�
Actor primario: Due�o
Meta: Identificar deudores morosos
Camino b�sico:
1 � El due�o se loguea en el sistema ingresando usuario y clave. El sistema valida.
2 � El due�o ingresa un monto minimo de deuda. El sistema emite listado con dni, apellido, nombre de los clientes que igualen o superen el monto ingresado.
3 � El due�o selecciona enviar mail. El sistema env�a email de notificaci�n a cada uno de los clientes morosos.
Caminos alternativos:
1.a<durante> �Usuario o clave invalida�
	1.a.1 � El sistema muestra mensaje �usuario o clave invalida�
	1.a.2 � Vuelta a paso 1.
2.a<durante> �No hay clientes deudores que superen el monto�
	2.a.1 � FCU.

