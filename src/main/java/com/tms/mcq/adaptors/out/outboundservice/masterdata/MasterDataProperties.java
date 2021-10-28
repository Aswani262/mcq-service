package com.tms.mcq.adaptors.out.outboundservice.masterdata;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
public class MasterDataProperties {
    private String baseUrl;

}
