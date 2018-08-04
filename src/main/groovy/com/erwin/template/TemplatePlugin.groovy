package com.erwin.template

import com.erwin.template.java.JavaTemplatePlugin
import com.erwin.template.kotlin.KotlinTemplatePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class TemplatePlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        target.apply(plugin: KotlinTemplatePlugin)
        target.apply(plugin: JavaTemplatePlugin)
    }
}
