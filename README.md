
# Sistema para despachantes de aduana
## Pasos para poder ejecutar el proyecto
* Clonar el repositorio
* Importar el proyecto al STS
* Correr el proyecto como una aplicación de Spring Boot
* Utilizar las diferentes entradas en el Insomnia para interactuar con el backend.

**Dsclaimer: este proyecto esta basado/inspirado en** (https://docs.google.com/document/d/1ylG2kBlzQwSCv6uiKP_tPPimTtvRA4YUG6PDxcmsH7I/edit#heading=h.ek4p4lvlzftk) **y el proyecto/carpeta encontrado en** (https://github.com/alefq/lp3-template-tp)

### Requests:
*	Todos los requests se hacen a la dirección principal http://localhost:8080/api/lp3/, agregando a cada una, una parte más de la dirección.
*	Se envia en formato JSON. 

## CRUD
### Usuario
*	*Listar usuario por rol:* Request de tipo GET y se agrega /usuario/{rol}  a la direccion principal. Lista todos los usuarios de ese rol que se agregaron mostrando todos sus datos. ***Roles definidos para este proyecto son: Auditor, Administrador, Despachante, Transportista.***
*	*Listar usuarios:* Request de tipo GET y se agrega /usuario/ a la direccion principal. Lista todos los usuarios que se agregaron mostrando todos sus datos.
* *Eliminar usuario por id:*  Request de tipo GET y se agrega /usuario/{id}   a la direccion principal para eliminar todos los datos de ese usuario con ese id.
*	*Agregar usuario:* Request de tipo POST y se agrega /usuario a la direccion principal. Los datos se insertan en formato JSON.
*	*Actualizar usuario por id:* Request de tipo PUT y se agrega /usuario/{id}  a la direccion principal. Los datos se insertan en formato JSON.
### Impuesto
*	*Listar impuestos:* Request de tipo GET y se agrega /impuesto/ a la direccion principal. Lista todos los impuestos que se agregaron mostrando todos sus datos.
*	*Agregar impuestos:* Request de tipo POST y se agrega /impuesto a la direccion principal. Los datos se insertan en formato JSON.
*	*Actualizar impuestos por id:* Request de tipo PUT y se agrega /impuesto/{id}  a la direccion principal. Los datos se insertan en formato JSON.
*	*Eliminar impuestos por id:* Request de tipo GET y se agrega /impuesto/{id}   a la direccion principal para eliminar todos los datos de ese usuario con ese id.

### Organizaciones
*	*Listar organizaciones:* Request de tipo GET y se agrega /organizaciones/ a la direccion principal. Lista todas las organizaciones que se agregaron mostrando todos sus datos.
*	*Listar organizaciones por tipo:* Request de tipo GET y se agrega /organizaciones /{tipo}  a la direccion principal. Lista todas las organizaciones de ese tipo que se agregaron mostrando todos sus datos. ***Tipos definidos para este proyecto son: Auditores, Administradores, Despachantes, Transportistas.***
*	*Agregar organizaciones:* Request de tipo POST y se agrega /organizaciones a la direccion principal. Los datos se insertan en formato JSON.
*	*Actualizar organizaciones por id:* Request de tipo PUT y se agrega /organizaciones/{id}  a la direccion principal. Los datos se insertan en formato JSON.
*	*Eliminar organizaciones por id:* Request de tipo GET y se agrega /organizaciones/{id}   a la direccion principal para eliminar todos los datos de esa organizacion con ese id.

### Producto
*	Listar productos:* Request de tipo GET y se agrega /producto/ a la direccion principal. Lista todos los productos que se agregaron mostrando todos sus datos.
*	*Listar productos por tipo:* Request de tipo GET y se agrega /producto/{tipo}  a la direccion principal. Lista todas los productos de ese tipo que se agregaron mostrando todos sus datos. 
*	*Agregar productos:* Request de tipo POST y se agrega / producto a la direccion principal. Los datos se insertan en formato JSON.
*	*Actualizar productos por id:* Request de tipo PUT y se agrega /producto/{id}  a la direccion principal. Los datos se insertan en formato JSON.
*	*Eliminar productos por id:* Request de tipo GET y se agrega /producto/{id}   a la direccion principal para eliminar todos los datos de ese producto con ese id.

### Transporte
*	*Listar transportes:* Request de tipo GET y se agrega /transporte/ a la direccion principal. Lista todos los transportes que se agregaron mostrando todos sus datos.
*	*Agregar transportes:* Request de tipo POST y se agrega /transporte a la direccion principal. Los datos se insertan en formato JSON.
*	*Actualizar transportes por id:* Request de tipo PUT y se agrega / transporte/{id}  a la direccion principal. Los datos se insertan en formato JSON.
*	*Eliminar transportes por id:* Request de tipo GET y se agrega /transporte/{id}   a la direccion principal para eliminar todos los datos de ese transporte  con ese id.

### Almacenamiento
*	*Listar almacenamiento:* Request de tipo GET y se agrega /almacenamiento/ a la direccion principal. Lista todos los almacenamientos que se agregaron mostrando todos sus datos.
*	*Agregar almacenamiento:* Request de tipo POST y se agrega /almacenamiento a la direccion principal. Los datos se insertan en formato JSON.
*	*Actualizar almacenamiento por id:* Request de tipo PUT y se agrega /almacenamiento/{id}  a la direccion principal. Los datos se insertan en formato JSON.
*	*Eliminar almacenamiento por id:* Request de tipo GET y se agrega /almacenamiento/{id}   a la direccion principal para eliminar todos los datos del almacenamiento con ese id.

### Generar Presupuesto
*	*Listar Presupuesto:* Request de tipo GET y se agrega /generarPresupuesto/ a la direccion principal. Lista todos los presupuestos que se crearon.
*	*Generar Presupuesto:* Request de tipo POST y se agrega /Presupuesto/producto/{idProducto} para generar presupuesto de un producto.
/Presupuesto/producto/{id}/{id} para generar 2 presupuestos y /Presupuesto/producto/{id}/{id}/{id} para generar 3 presupuestos de 3 productos,
Utiliza hasta tres id de producto en la direccion. Los datos se insertan en formato JSON.
*	*Actualizar Presupuesto por id:* Request de tipo PUT y se agrega /Presupuesto/producto/{id}  a la direccion principal. Los datos se insertan en formato JSON.
*	*Eliminar impuestos por id:* Request de tipo GET y se agrega / generarPresupuesto/{id} a la direccion principal para eliminar todos los datos de ese usuario con ese id.


### Autores: Erika Cardozo y Ethel Ortiz ###
