package patterns.estructural.facade.excersice.facade;

import patterns.estructural.facade.excersice.library.*;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        // Imprime un mensaje indicando que la conversión ha comenzado
        System.out.println("VideoConversionFacade: conversion started.");
        
        // Crea un objeto VideoFile con el nombre del archivo proporcionado
        VideoFile file = new VideoFile(fileName);
        
        // Extrae el codec del archivo de video utilizando la fábrica de codecs
        Codec sourceCodec = CodecFactory.extract(file);
        
        // Declara una variable para el codec de destino
        Codec destinationCodec;
        
        // Determina el codec de destino basado en el formato proporcionado
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        
        // Lee el archivo de video y lo convierte a un buffer utilizando el codec de origen
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        
        // Convierte el buffer al codec de destino
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        
        // Ajusta el archivo de video utilizando el mezclador de audio y obtiene el archivo final
        File result = (new AudioMixer()).fix(intermediateResult);
        
        // Imprime un mensaje indicando que la conversión ha finalizado
        System.out.println("VideoConversionFacade: conversion completed.");
        
        // Retorna el archivo resultante
        return result;
    }
}
