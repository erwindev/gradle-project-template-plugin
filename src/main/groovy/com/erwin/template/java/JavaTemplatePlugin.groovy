package com.erwin.template.java

import com.erwin.template.java.task.InitJavaProjectTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class JavaTemplatePlugin implements Plugin<Project>{

    void apply(Project target) {
        target.task("initJavaProject", type: InitJavaProjectTask)
    }
}
