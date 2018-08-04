package com.erwin.template.kotlin

import com.erwin.template.kotlin.task.InitKotlinProjectTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinTemplatePlugin implements Plugin<Project> {

    void apply(Project target) {
        target.task("initKotlinProject", type: InitKotlinProjectTask)
    }
}
