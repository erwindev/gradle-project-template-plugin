package com.erwin.template.java.task

import com.erwin.template.util.ProjectTemplate
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class ExportJavaTemplateTask extends DefaultTask{

    @TaskAction
    void export(){
        def templates =
                [
                        '/templates/java/config/java-swagger-config.tpl',
                        '/templates/java/controller/java-main-controller.tpl',
                        '/templates/java/controller/java-main-controller-test.tpl',
                        '/templates/java/dao/java-dao.tpl',
                        '/templates/java/domain/java-domain1.tpl',
                        '/templates/java/domain/java-domain2.tpl',
                        '/templates/java/dto/java-dto.tpl',
                        '/templates/java/service/java-service.tpl',
                        '/templates/java/service/java-service-test.tpl',
                        '/templates/java/util/java-application-setting.tpl',
                        '/templates/java/util/java-health-checker.tpl',
                        '/templates/java/build-gradle.tpl',
                        '/templates/java/docker-file.tpl',
                        '/templates/java/git-ignore.tpl',
                        '/templates/java/java-application-test.tpl',
                        '/templates/java/java-smoke-test.tpl',
                        '/templates/java/readme-md.tpl'
                ]
        exportTemplates(templates)
    }

    private void exportTemplates(def templates = []) {
        ProjectTemplate.buildFromCurrentLocation ('export-java-templates') {
            templates.each { template ->
                def tStream = getClass().getResourceAsStream(template)
                "$template" tStream.text
            }
        }
    }
}
