package com.classFiles;

import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectifyInitializer  {
    
    @Bean
    public void initilize_objectify(){
        ObjectifyService.init(new ObjectifyFactory(
			DatastoreOptions.newBuilder()
				.setProjectId("manifest-device-311614")
				.build()
				.getService()
			));	

    }
}
