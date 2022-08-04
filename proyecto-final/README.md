

*EndPoint de tienda back*

>*Persona*
>>*Agregar Persona:* localhost:8080/persona/agregar

>>*(Es necesario token, al realizar login nos arroja el token)*
>>*LOGIN* localhost:8080/persona/loginPersona (enviar email y password por body method: POST)
>>*Ver Personas:* localhost:8080/persona/todos
>>*Actualizar Persona:* localhost:8080/zapato/actualizar
>>*Eliminar Persona:* localhost:8080/persona/eliminar/3

>*Zapato*
>>*Visualizar zapatos:* localhost:8080/zapato/todos
>>*Visualizar con paginado*: localhost:8080/zapato/todos?pag=0&size=1
>>*Filtrado por genero*: localhost:8080/zapato/genero?genero=F  o   localhost:8080/zapato/genero/F
>>*Filtrado por talla*: localhost:8080/zapato/talla?talla=39  o   localhost:8080/zapato/talla/39
>>*Filtrado por color:* localhost:8080/zapato/color?color=blanco  o   localhost:8080/zapato/color/blanco
>>*Filtrado por precio:* localhost:8080/zapato/precio?precio=55  o   localhost:8080/zapato/precio/55
>>(Es necesario token)
>>*Agregar zapato:* localhost:8080/zapato/agregar
>>*Actulzar zapato:* localhost:8080/zapato/actualizar
>>*Eliminar zapato:* localhost:8080/zapato/eliminar/3

>*Carrito* (depende la existencia zapato y persona)
>>*Agregar:* (necesita zapCodigo y perCodigo (Existencia de ambos)) localhost:8080/carrito/agregar 
>>*Ver carritos de cliente:* localhost:8080/carrito/todos
>>*Ver que tiene el carrito una persona:* localhost:8080/carrito/cliente/1
>>*Eliminar objeto del carrito una persona:* localhost:8080/carrito/cliente/1

>Pedido
>>*Ver todos los pedidos:* localhost:8080/pedido/todos
>>*Ver pedido por id:* localhost:8080/pedido/5
>>*Eliminar pedido por id:* localhost:8080/pedido/eliminar/5

>Detalles de pedido (Gestiona cantidad y costo que sale en subtotal) se agrega manualmente pero debe existir el pedido
>>*Agregar manuelmente detalles del pedido(n):* localhost:8080/detalle_pedido/agregar
>>*Ver detalle de todos los pedidos:* localhost:8080/detalle_pedido/todos 

>*Pedido comprar o devolver*
>>*En method POST, colocar 'pedEstado':'Enviado o Devolver'* localhost:8080/pedido/comprar
>>*Revisar el estado del pedido y afectar o mantener stock:* localhost:8080/pedido/1
>>*Ver pedidos de persona:* localhost:8080/persona/1

>Envios
>>*Revisar pedidos enviados:* localhost:8080/entrega/todos
>>*Actualizar entrega:* localhost:8080/entrega/actualizar
>>*Revisar pedidos enviado por id:* localhost:8080/entrega/1


*Base de datos utilzida MYSQL, caso de cambiar motor es en property
