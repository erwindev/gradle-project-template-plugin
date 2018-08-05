buildscript {
	ext {
		springBootVersion = '2.0.2.RELEASE'
	}
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath("org.springframework.boot:spring-boot-gradle-plugin:\${springBootVersion}")
		classpath("org.flywaydb:flyway-gradle-plugin:3.2.1")
    classpath("net.saliman:gradle-cobertura-plugin:2.3.1")
  }
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'
apply plugin: 'org.flywaydb.flyway'
apply plugin: 'net.saliman.cobertura'

repositories {
    mavenCentral()
}

bootJar {
    baseName = '${projectName}'
    version =  '0.1.0'
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-data-jpa:\${springBootVersion}"){
		exclude module: 'tomcat-jdbc'
	}
    compile("org.springframework.boot:spring-boot-starter-web:\${springBootVersion}"){
		exclude module: 'spring-boot-starter-tomcat'
	}
	//use jetty
	compile("org.springframework.boot:spring-boot-starter-jetty:\${springBootVersion}")
  compile("org.springframework.boot:spring-boot-starter-actuator:\${springBootVersion}")

	//PostgreSQL compile("org.postgresql:postgresql:9.4.1212")
	//MySQL runtime("mysql:mysql-connector-java:5.1.34")
	//SQL Server compile files("lib/sqljdbc4.jar")
	//Local H2
	compile("com.h2database:h2:1.4.197")

	//Hikari Connection Pool
	compile("com.zaxxer:HikariCP:3.1.0")

	//flyway
	//compile("org.flywaydb:flyway-core:4.2.0")

	//swagger
	compile("io.springfox:springfox-swagger2:2.7.0")
	compile("io.springfox:springfox-swagger-ui:2.7.0")

	compile("ch.qos.logback:logback-core:1.1.6")
	compile("ch.qos.logback:logback-classic:1.1.6")
	compile("ch.qos.logback:logback-access:1.1.6")
	compile("org.slf4j:slf4j-api:1.7.18")

	testCompile("junit:junit")
	testCompile("org.springframework.boot:spring-boot-starter-test:\${springBootVersion}")
}

sourceSets.main.output.classesDir = new File(buildDir, "classes/main")

cobertura {
	coverageFormats = ['html', 'xml']
	coverageIgnoreTrivial = true
	coverageIgnores = ['org.slf4j.Logger.*']
	coverageReportDir = new File("\$buildDir/reports/cobertura")
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

task wrapper(type: Wrapper) {
    gradleVersion = '4.6'
}
