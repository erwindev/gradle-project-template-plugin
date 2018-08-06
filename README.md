# Project Template Plugin

## Summary

This project is a custom Gradle plugin that provides a way for you to easily 
scaffold a project.  By default, this plugin generates a Spring Boot project
using Java and Kotlin. Additionally, you can create your own templates 
to scaffold any type of project that you want. 

## Installation

In order to use this plugin, you have to first publish it to your local maven 
repo. _note: I still need to figure out how I can publish the plugin to Bintray._

```
$ git clone https://github.com/erwindev/gradle-project-template-plugin.git
$ cd gradle-project-template-plugin
$ ./gradlew publishToMavenLocal

```

## Using the Plugin

To start using the plugin, you will need to create a `build.gradle` script.

Create a directory and place your `build.gradle` script in there.
```
$ mkdir your-project
$ cd your-project
$ vi build.gradle
```

Contents of the `build.gradle`

```
buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath "com.erwin:gradle-project-template-plugin:1.0.0"
    }
}

apply plugin: 'gradle-project-template-plugin'
```

Run the plugin
```
$ gradle -q --console=plain initJavaProject 
What is the name of the project? [defaultproject] 

What is the base package (ex. com.erwindev.sample)? 
com.erwindev.sample
```

This will generate a directory called `defaultproject` in the current directory.  
In that directory, you will find a generated Java Spring Boot project 
with a `com.erwindev.sample` base package structure.

## Run the generated project

```
$ gradle assemble test
$ java -jar build/libs/defaultproject-0.1.0.jar
```

Access the application through Swagger UI 
(`http://localhost:8999/swagger-ui.html`).

You can also see the Test Reports by loading 
`build/reports/tests/test/index.html` in your browser

## Exporting the base templates
The base templates used to generate the Spring Boot project are included in the plugin.
To see what these templates look like, you can export them.  

```
$ cd your-project 
$ gradle -q --console=plain exportJavaTemplates
```

You should see the `export-java-templates` directory that contains all base the templates.

## Scaffolding your own project
You can create your own scaffolded project.  You are also not limited 
to a Java project.  You can basically use this plugin to generate any type
of project using any language you wish.

In order to do that, we will need to define a new task in the `build.gradle` script.

Append the following in the `build.gradle` script.
```
import com.erwin.template.util.ProjectTemplate
import com.erwin.template.util.Interact

task 'initMyOwnProject' << {
    String projectName = Interact.prompt('Project Name:')
    String classPackage = 'com.erwindev.myproject'
    String classPackageDir = classPackage.replace('.', System.getProperty("file.separator"))
    ProjectTemplate.buildFromCurrentLocation(projectName) {
      'src'{
        'main'{
          'java'{
            "${classPackageDir}"{
              String className = 'Application'
              "${className}.java" template: '/my-templates/java/java-class.tpl', classPackage: classPackage, className: className
            }
          }
        }
      }
    }
}
```

Create your templates in `my-templates/java` directory and create a `java-class.tpl` template.
```
$ mkdir my-templates
$ cd my-templates
$ mkdir java
$ cd java
$ vi java-class.tpl
```

Contents of the `java-class.tpl` template
```
package ${classPackage};

/**
 * @author ${System.getProperty("user.name")} xxxx xxxx
 * Created: ${new Date()}
 */
public class ${className} {
    public ${className}() {
    }
}
```

Run the `initMyOwnProject` task

```
$ gradle -q --console=plain initMyOwnProject
Project Name: 
fox
```

You should see a `fox` directory that contains your generated project.

## To Do
* Publish to remote Maven repo
* Create Kotlin version of Spring Boot project
* Create Groovy version of Spring Boot project
* Create Micronaut scaffolded project
* Determine how to install `build.gradle` script globally

