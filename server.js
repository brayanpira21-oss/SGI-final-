/**
 * Módulo principal del framework Express para construir el servidor web.
 * @type {Function}
 */
const express = require('express');
/**
 * Módulo de Node.js para trabajar con rutas de archivos y directorios.
 * Asegura que las rutas funcionen correctamente en diferentes sistemas operativos (Windows, Linux, etc.).
 * @type {Object}
 */
const path = require('path');
/**
 * Instancia de la aplicación Express.
 * @type {Object}
 */
const app = express();
/**
 * Puerto en el que el servidor estará escuchando las peticiones entrantes.
 * @type {number}
 */
const port = 3003;
app.use(express.static(path.join(__dirname, 'public')));
app.get('/', (req, res) => {
    // ¡CORREGIR ESTA LÍNEA! Debe coincidir con el nombre sin espacios.
    res.sendFile(path.join(__dirname, 'public', 'sgi-pruebas.html')); 
});
app.listen(port, () => {
    console.log(`🚀 SGI corriendo en http://localhost:${port}`);
});