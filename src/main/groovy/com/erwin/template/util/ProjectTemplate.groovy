package com.erwin.template.util

import groovy.text.GStringTemplateEngine

class ProjectTemplate {

    private File parent

    private ProjectTemplate(){}

    void directory(String name, Closure closure = {}){
        File oldParent = parent

        if (parent){
            parent = new File(parent, name)
        }
        else{
            parent = new File(name)
        }

        parent.mkdirs()
        closure.delegate = this
        closure()

        parent = oldParent
    }

    void file(Map args = [:], String name) {
        File file
        if (parent) {
            file = new File(parent, name)
        } else {
            file = new File(name)
        }
        file.exists() ?: file.parentFile.mkdirs() && file.createNewFile()
        def content
        if (args.content) {
            content = args.content.stripIndent()
        } else if (args.template) {
            content = renderTemplate(args, args.template)
        }
        if (content) {
            if (args.append) {
                file.append(content)
            } else {
                file.text = content
            }
        }
    }

    String renderTemplate(Map params = [:], String template) {
        def templateLocation = new File(template)
        // search the template location
        if (!templateLocation.exists()) {
            // if the template location is found
            def tmpl = template
            if (tmpl.startsWith('/')) {
                tmpl = tmpl.substring(1)
            }
            // search current directory
            templateLocation = new File(System.getProperty('user.dir'), tmpl)
            if (!templateLocation.exists()) {
                // search the classpath
                templateLocation = getClass().getResource(template)
            }
        }
        def templateReader = templateLocation?.newReader()
        if (templateReader) {

            //this is the hack
            params.each{ k, v ->
                if(!v){
                    params[k] = "\$$k"
                }
            }

            return new GStringTemplateEngine().createTemplate(templateReader)?.make(params)?.toString()
        }
        throw new RuntimeException("Could not find template: ${template}")
    }

    def methodMissing(String name, def args) {
        if (args) {
            def arg = args[0]
            if (arg instanceof Closure) {
                directory(name, arg)
            } else if (arg instanceof Map) {
                file(arg, name)
            } else if (arg instanceof String || arg instanceof GString) {
                file([content: arg], name)
            } else {
                println "Something went wrong. name: ${name}, arg: ${arg}"
            }
        }
    }

    static void fromRoot(String path, Closure closure = {}){
        new ProjectTemplate().directory(path, closure)
    }
}
