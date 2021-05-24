/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.service;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
import com.cloudpdv.config.ConfiguraAmazon;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class APIUpload {

    private String accessKey = "XXXXXXXXX";
    private String secretKey = "XXXXXXXXXXXXXXXXXXXXXXX";

    public void UploadArquivosXML(String Empresa, String Loja, String diretorio, InputStream uploadArquivo, String nomeArquivo) throws IOException {

        ConfiguraAmazon configuraAmazon = new ConfiguraAmazon();
        AmazonS3 s3client = configuraAmazon.configuracao();
        String bucketName = "XXXXXXXX";
        bucketName = bucketName + "/" + "Empresa" + Empresa + "/" + "Loja" + Loja + "/" + diretorio;

        AccessControlList acl = new AccessControlList();
        acl.grantPermission(GroupGrantee.AllUsers, Permission.FullControl);

        s3client.putObject(new PutObjectRequest(bucketName, nomeArquivo, uploadArquivo, new ObjectMetadata()));
        s3client.setObjectAcl(bucketName, nomeArquivo, CannedAccessControlList.PublicRead);
        // Generate URL
        java.util.Date expiration = new java.util.Date();
        long milliSeconds = expiration.getTime();
        milliSeconds += 1000 * 60 * 60; // Add 1 hour.
        expiration.setTime(milliSeconds);
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, nomeArquivo);
        generatePresignedUrlRequest.setMethod(HttpMethod.GET);
        generatePresignedUrlRequest.setExpiration(expiration);
        URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest);

    }
}
