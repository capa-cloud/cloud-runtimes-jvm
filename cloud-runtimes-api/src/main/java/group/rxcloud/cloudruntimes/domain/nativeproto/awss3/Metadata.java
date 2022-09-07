package group.rxcloud.cloudruntimes.domain.nativeproto.awss3;

public final class Metadata {

    /**
     * Retrieve the S3 access key, used to identify the user interacting with S3.
     */
    public static final String ACCESS_KEY = "accessKey";
    /**
     * Retrieve the S3 secret access key, used to authenticate the user interacting with S3.
     */
    public static final String SECRET_KEY = "secretKey";
    /**
     * Configure the endpoint with which the SDK should communicate.
     */
    public static final String ENDPOINT = "endpoint";

    private Metadata() {
    }
}
