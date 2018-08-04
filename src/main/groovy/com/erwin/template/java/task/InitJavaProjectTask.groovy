package com.erwin.template.java.task

import com.erwin.template.BaseProjectTask
import com.erwin.template.util.ProjectTemplate

class InitJavaProjectTask extends BaseProjectTask{

    void projectTask(){
        ProjectTemplate.fromRoot("$projectName") {
            'src' {
                'main' {
                    'java' {
                        "$classPackageDir"{
                            "${defaultClassEntryName}.java" template: '/templates/java/java-class.tpl', classPackage: classPackage, className: defaultClassEntryName
                        }
                    }
                    'resources' {
                    }
                }
                'test' {
                    'java' {
                        "$classPackageDir"{
                            "${defaultClassEntryName}Test.java" template: '/templates/java/java-class.tpl', classPackage: classPackage, className: defaultClassEntryName
                        }
                    }
                    'resources' {
                    }
                }
            }
            'LICENSE.txt' '// Your License Goes here'
        }
    }
}
