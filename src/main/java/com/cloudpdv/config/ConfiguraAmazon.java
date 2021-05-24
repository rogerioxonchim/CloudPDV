/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.config;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * @author Rogerio Xonchim
 */
public class ConfiguraAmazon {

    private String bucketName = "voti";
    private String accessKey = "XXXXXXXXXXXXXX";
    private String secretKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    public AmazonS3 configuracao() {

        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);
        AmazonS3 s3client = AmazonS3Client.builder()
                .withClientConfiguration(clientConfig)
                .withRegion(Regions.SA_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .withPathStyleAccessEnabled(true).build();

        return s3client;
    }

}
