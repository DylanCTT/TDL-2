-Modelamos datos personales como cliente y usuario como perfil

-Si bien en el UML dentro de Contenido tenemos lista de géneros, aca lo simplificamos usando un solo genero.

-Simplificación de duración película a numero real.

-La reseña se setea por default a no aprobada. Se aprueban todas manualmente.

-Cuando se registra una reseña, al momento de la validación del usuario y contraseña, se verifica con el mail del cliente y su contraseña. 

-Géneros cargados desde el inicio?????????????

-Aclarar lo que entendemos por que el resumen no haga falta en el registro de película 


COMANDOS PARA EJECUTAR DESDE SHELL

javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })

java -cp "out;lib/sqlite-jdbc-3.50.3.0.jar" app.Main
