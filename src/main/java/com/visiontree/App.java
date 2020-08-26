package com.visiontree;

import com.amazonaws.services.secretsmanager.*;
import com.amazonaws.services.secretsmanager.model.ListSecretsRequest;
import com.amazonaws.services.secretsmanager.model.ListSecretsResult;
import com.amazonaws.services.secretsmanager.model.SecretListEntry;

import java.util.List;

// https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
public class App 
{
    public static void main( String[] args )
    {
        AWSSecretsManager ssm_client = AWSSecretsManagerClient.builder().build();

        ListSecretsRequest list_secrets = new ListSecretsRequest();
        ListSecretsResult secrets_response = ssm_client.listSecrets(list_secrets);
        List<SecretListEntry> secrets = secrets_response.getSecretList();

        for(int i = 0; i < secrets.size(); i++) {
            SecretListEntry secret = secrets.get(i);
            System.out.println(secret);
        }

        // tear down threadpool stuff
        ssm_client.shutdown();
    }
}
