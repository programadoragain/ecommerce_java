package com.springboot.ecommerce.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class UploadFileService {
    String carpeta= "imagenes/";

    public String guardarImagen (MultipartFile archivo) throws IOException {
        if (!archivo.isEmpty()) {
            byte[] archivoEnBytes= archivo.getBytes();
            Path ruta= Paths.get(carpeta + archivo.getOriginalFilename());
            Files.write(ruta,archivoEnBytes);
            return archivo.getOriginalFilename();
        }
        else
            return "ImagenDefault.jpg";
    }

    public void eliminarImagen (String nombreImagen) throws IOException {
        Path ruta= Paths.get(carpeta + nombreImagen);
        if (Files.exists(ruta)) {Files.delete(ruta);}
    }

    public boolean existeImagen (String nombreImagen) throws IOException {
        Path ruta= Paths.get(carpeta + nombreImagen);
        return (Files.exists(ruta));
    }

}
