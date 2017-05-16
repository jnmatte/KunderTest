# KunderTest
Prueba de selección para Kunder. API RestFul con un método POST y un método GET. Desarrollado en Java.

Para el método GET time, lo que hace es recibir el parámetro value en la uri en hora chilena, en formato yyyy-MM-DDThh:mm:ss y la 
convierte a UTC en formato yyyy-MM-DDThh:mm:ss.ssTZ. La hora nueva viene en el json de respuesta bajo el valor 'data'. Además se manejan
las distintas excepciones con sus correspondientes códigos HTTP.

Para el método POST word, recibe los párametros desde un JSON que sigue la estructura del enunciado. El método revisa que cumpla el largo
pedido (4) y luego lo convierte a mayúsculas, usando el método java toUpperCase(). Además, maneja las excepciones por el tamaño del input
y otros errores internos con los correspondientes códigos HTTP.

Ambos responden con el código de estado según la situación y un JSON que guarda el contenido de la respuesta.
