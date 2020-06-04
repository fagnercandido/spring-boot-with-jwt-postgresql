package br.com.test.configurations;

public enum SecurityConstants {
    
    SECRET("MySecretIsATest"),
    EXPIRATION_TIME("864000000"),
    HEADER_STRING("Authorization"),
    TOKEN_PREFIX("Bearer "),
    SIGN_UP_URL("/auth/register");

    private String value;

    SecurityConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}