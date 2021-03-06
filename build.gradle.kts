import org.gradle.api.plugins.*
import org.gradle.api.tasks.wrapper.*
import org.gradle.script.lang.kotlin.*
import org.gradle.jvm.tasks.Jar

apply {
    plugin("java")
    plugin("com.github.ben-manes.versions")
}


buildscript {
    repositories {
        mavenCentral()

        gradleScriptKotlin()
    }

    dependencies {
        classpath("com.github.ben-manes:gradle-versions-plugin:0.13.0")

        classpath(kotlinModule("gradle-plugin"))
    }
}

repositories {
    jcenter()

    // Not sure about this
    gradleScriptKotlin()
}



configure<JavaPluginConvention> {
    setSourceCompatibility(1.8)
    setTargetCompatibility(1.8)
}

dependencies {
    compile ("cd.go.plugin:go-plugin-api:14.4.0")

    compile("com.google.code.gson:gson:2.3.1")

    compile("org.cloudfoundry:cloudfoundry-client-lib:1.1.3")
//        compile 'org.springframework:spring-webmvc:4.0.8.RELEASE'
//            compile 'org.springframework:spring-beans:4.0.8.RELEASE'
//                compile 'org.springframework:spring-core:4.0.8.RELEASE'
//                    compile 'commons-logging:commons-logging:1.1.3'
//            compile 'org.springframework:spring-context:4.0.8.RELEASE'
//                compile 'org.springframework:spring-aop:4.0.8.RELEASE'
//                    compile 'aopalliance:aopalliance:1.0'
//                    compile 'org.springframework:spring-expression:4.0.8.RELEASE'
//                    compile 'org.springframework:spring-web:4.0.8.RELEASE'
//        compile 'org.springframework.security.oauth:spring-security-oauth2:2.0.4.RELEASE'
//            compile 'org.springframework.security:spring-security-core:3.2.5.RELEASE'
//                compile 'aopalliance:aopalliance:1.0'
//            compile 'org.springframework.security:spring-security-config:3.2.5.RELEASE'
//    compile 'org.springframework.security:spring-security-web:3.2.5.RELEASE'
//
//    compile 'commons-codec:commons-codec:1.6'
//    compile 'org.codehaus.jackson:jackson-mapper-asl:1.9.13'
//    compile 'org.codehaus.jackson:jackson-core-asl:1.9.13'
//    compile 'org.apache.httpcomponents:httpclient:4.3.6'
//    compile 'org.apache.httpcomponents:httpcore:4.3.3'
//    compile 'commons-logging:commons-logging:1.1.3'
//    compile 'commons-codec:commons-codec:1.6'
//    compile 'commons-io:commons-io:2.1'
//    compile 'com.esotericsoftware.yamlbeans:yamlbeans:1.06'
//    compile 'com.fasterxml.jackson.core:jackson-core:2.3.3'
//    compile 'com.fasterxml.jackson.core:jackson-databind:2.3.3'
//    compile 'com.fasterxml.jackson.core:jackson-annotations:2.3.0'
//    compile 'com.fasterxml.jackson.core:jackson-core:2.3.3'
//    compile 'org.apache.tomcat.embed:tomcat-embed-websocket:8.0.15'
//    compile 'org.apache.tomcat.embed:tomcat-embed-core:8.0.15'
//    compile 'org.apache.tomcat:tomcat-juli:8.0.15'
//    compile 'com.google.protobuf:protobuf-java:2.6.1'
//

    testCompile("junit:junit:4.12")
//        testCompile 'org.hamcrest:hamcrest-core:1.3'
}


// FIXME:
// - This doesn't include version in jar filename
// - Path of jar files doesn't have a lib folder
tasks.withType<Jar> {
    print("Hello " + configurations.runtime)
    into("lib") {
        from(configurations.runtime)
    }
}