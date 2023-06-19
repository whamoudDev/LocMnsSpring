package com.dw.locmns.Services;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FichierService {


    @Value("${dossier.uploadImages}")
    private String dossierImages;

    @Value("${dossier.uploadDocumentations}")
    private String dossierDocumentations;


    public void transfertVersDossierImages(MultipartFile fichier, String nomFichier) throws IOException {
        System.out.println("|||||||||||||||||||||||||||||||||||||||TRANSFERT IMAGE  |||||||||||||||||||||||||||||||||||||");

        Path cheminDossierImages = Paths.get(dossierImages);
        if(!Files.exists( cheminDossierImages)){
            Files.createDirectories(cheminDossierImages);
        }
        Path destination = Paths.get(dossierImages+"/"+ nomFichier);
        Files.copy(fichier.getInputStream(),destination, StandardCopyOption.REPLACE_EXISTING);

    }

    public void transfertVersDossierDocumentations(MultipartFile fichier, String nomFichier) throws IOException {
        System.out.println("|||||||||||||||||||||||||||||||||||||||TRANSFERT DOCUMENT  |||||||||||||||||||||||||||||||||||||");
        Path cheminDossierDocumentations = Paths.get(dossierDocumentations);
        if(!Files.exists( cheminDossierDocumentations)){
            Files.createDirectories(cheminDossierDocumentations);


        }
        Path destination = Paths.get(dossierDocumentations+"/"+ nomFichier);
        Files.copy(fichier.getInputStream(),destination, StandardCopyOption.REPLACE_EXISTING);

    }




    public byte[] getImageByName(String nomImage) throws FileNotFoundException {

        Path destination = Paths.get(dossierImages+"/"+nomImage);// retrieve the image by its name

        try {
            return IOUtils.toByteArray(destination.toUri());
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }

    }

    public byte[] getDocumentationByName(String nomDocument) throws FileNotFoundException {

        Path destination = Paths.get(dossierDocumentations+"/"+nomDocument);// retrieve the image by its name

        try {
            return IOUtils.toByteArray(destination.toUri());
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }

    }








}
