const express = require('express');
const path = require('path');
const app = express();
const port = 3001;

app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
    // ¡CORREGIR ESTA LÍNEA! Debe coincidir con el nombre sin espacios.
    res.sendFile(path.join(__dirname, 'public', 'sgi-pruebas.html')); 
});

app.listen(port, () => {
    console.log(`🚀 SGI corriendo en http://localhost:${port}`);
});