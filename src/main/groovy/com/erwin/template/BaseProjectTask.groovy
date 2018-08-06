package com.erwin.template

import com.erwin.template.util.Interact
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class BaseProjectTask extends DefaultTask{

    String separator = System.getProperty("file.separator")
    String defaultProjectName = 'defaultproject'
    String defaultPackageGroup = ''
    String defaultClassEntryName = 'Application'

    String projectName
    String classPackage
    String classPackageDir

    @TaskAction
    void start(){
        boolean isTest = false
        if (project.hasProperty("test")){
            String test = project.property("test")
            if (test.equalsIgnoreCase("true")){
                isTest = true
            }
        }

        projectName = "defaultProjectName"
        classPackage = "com.erwindev.sample"
        classPackageDir = classPackage.replace('.', separator)
        if (!isTest) {
            prompt()
        }
        projectTask()
    }

    void prompt(){
        projectName = Interact.prompt('What is the name of the project?', defaultProjectName)
        classPackage = Interact.prompt('What is the base package (ex. com.erwindev.sample)?',  "$defaultPackageGroup")
        classPackageDir = classPackage.replace('.', separator)
    }

    abstract void projectTask()
}
