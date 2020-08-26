VT AWS SDK Example
---

AWS uses a provider chain to figure out how to authenticate a SDK client connection.

Recommendations:
 * Use the service provider builder (don't instantiate a configuration/raw client)
 * In development set env vars `AWS_PROFILE` and `AWS_REGION` (the SDK does not seem to respect `~/.aws/config` setting the region for a profile)
 * In the cloud, use a IAM instance profile associated with the ECS task (aka, the shared ecsTaskExecutionRole we already provide to ECS fargate tasks)
 * service provider around for the life of the program (it will renew credentials as needed, pool HTTP clients to save on resources)

Running this example:

```
export AWS_PROFILE=visiontree
export AWS_REGION=us-west-2
mvn install exec:java -Dexec.mainClass="com.visiontree.App"
```