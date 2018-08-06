package com.erwin.template.kotlin.task

import com.erwin.template.BaseProjectTask
import com.erwin.template.util.ProjectTemplate

class InitKotlinProjectTask extends BaseProjectTask{

    void projectTask(){
        ProjectTemplate.buildFromCurrentLocation("$projectName") {
            'src' {
                'main' {
                    'kotlin' {
                        "$classPackageDir"{
                            "${defaultClassEntryName}.kt" template: '/templates/kotlin/kotlin-class.tpl', classPackage: classPackage, className: defaultClassEntryName
                        }
                    }
                    'resources' {
                    }
                }
                'test' {
                    'kotlin' {
                        "$classPackageDir"{
                            "${defaultClassEntryName}Test.kt" template: '/templates/kotlin/kotlin-class.tpl', classPackage: classPackage, className: defaultClassEntryName
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
