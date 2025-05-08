package com.avirat.chc.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdPartyConfiguration {

    @Bean
    public ModelMapper getModelMapper() {
       return new ModelMapper();
    }

}
