package com.lime.common.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestPropertySource(properties = {"jasypt.encryptor.password=limecorpbaseproject"})
class JasyptConfigTest {

//    BeanFactory beanFactory = new AnnotationConfigApplicationContext(JasyptConfig.class);
//    StringEncryptor stringEncryptor = beanFactory.getBean(StringEncryptor.class);

    private static StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("limecorpbaseproject");
//        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        return encryptor;
    }

    @Value("${spring.datasource.hikari.jdbc-url}")
    String jdbcUrl;


    @ParameterizedTest
    @DisplayName("암복호화 테스트")
    @ValueSource(strings = {"jdbc:log4jdbc:mariadb://localhost:33318/testdb", "limeEdu", "limeEdu1!"})
    void encryptorTest(String plain) {
        String enc = stringEncryptor().encrypt(plain);
        String dec = stringEncryptor().decrypt(enc);
        assertThat(plain).isEqualTo(dec);

        System.out.println("plain : %s -> enc : %s".formatted(plain, enc));

    }

    @Test
    @DisplayName("복호화 테스트")
    void decryptTest() {

        String dec = "72svmhrC7i4bd+U4g047KMt9IzYp5gu6UnAjnjVEEw2RqwWKPvjQ92DPVTCrR4rKMIbCv2YdhTs=";
        String plain = stringEncryptor().decrypt(dec);
        System.out.println(plain);
        Assertions.assertTrue(true);
    }
}