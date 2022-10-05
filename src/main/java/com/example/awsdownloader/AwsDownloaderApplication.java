package com.example.awsdownloader;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.List;


@SpringBootApplication
public class AwsDownloaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDownloaderApplication.class, args);
		String bucket_name = "softmicbucket";
		String key_name = "metadato/iStock-1300897309.jpeg";
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_1).build();

		System.out.format("Objects in S3 bucket %s:\n", bucket_name);
		final AmazonS3 s4 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_1).build();
		ListObjectsV2Result result = s4.listObjectsV2(bucket_name);
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		for (S3ObjectSummary os : objects) {
			System.out.println("* " + os.getKey());
		}
		GetObjectRequest request = new GetObjectRequest(bucket_name,key_name);
		File newFile = new File("/Users/ramaialejandria/Desktop/security.jpeg");
		s3.getObject(request,newFile);
	}
}


