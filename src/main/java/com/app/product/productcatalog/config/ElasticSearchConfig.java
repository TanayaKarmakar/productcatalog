package com.app.product.productcatalog.config;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import javax.net.ssl.SSLContext;

@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {
    @Value("${spring.elasticsearch.uris}")
    private String esUris;

    @Value("${spring.elasticsearch.username}")
    private String esUsername;

    @Value("${spring.elasticsearch.password}")
    private String esPassword;


    @Override
    public ClientConfiguration clientConfiguration() {
        try {

            // TODO: Should be on the dev profile to run this on self-signed TLS server.
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(this.esUsername, this.esPassword));

            SSLContextBuilder sslBuilder = SSLContexts.custom()
                    .loadTrustMaterial(null,
                            (x509Certificates, s) -> true
                    );
            final SSLContext sslContext = sslBuilder.build();

            return ClientConfiguration.builder()
                    .connectedTo(esUris)
                    .usingSsl(sslContext, NoopHostnameVerifier.INSTANCE)
                    .withConnectTimeout(10000)
                    .withBasicAuth(esUsername, esPassword)
                    .build();
        } catch (Exception e) {
            // throwing properly
            return null;
        }
    }
}
