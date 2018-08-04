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
        prompt()
        projectTask()
    }

    void prompt(){
        projectName = Interact.prompt('What is the name of the project?', defaultProjectName)
        classPackage = Interact.prompt('What is the base package (ex. com.erwindev.sample)?',  "$defaultPackageGroup")
        classPackageDir = classPackage.replace('.', separator)

    }

    abstract void projectTask()
}
