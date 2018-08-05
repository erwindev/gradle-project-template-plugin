package com.erwin.template.java.task

import com.erwin.template.BaseProjectTask
import com.erwin.template.util.ProjectTemplate

class InitJavaProjectTask extends BaseProjectTask{

    void projectTask(){
        String mainControllerName = 'MainController'
        String daoName = 'ClassRoomRepo'
        String domainName1 = 'ClassRoom'
        String domainName2 = 'Student'
        String dtoName = 'ClassRoomDto'
        String serviceName = 'ClassRoomService'

        ProjectTemplate.fromRoot("$projectName") {
            'src' {
                'main' {
                    'java' {
                        "$classPackageDir"{
                            "${defaultClassEntryName}.java" template: '/templates/java/java-class.tpl', classPackage: classPackage, className: defaultClassEntryName
                            'config'{
                                'SwaggerConfig.java' template: '/templates/java/config/java-swagger-config.tpl', classPackage: classPackage
                            }
                            'controller'{
                                "${mainControllerName}.java" template: '/templates/java/controller/java-main-controller.tpl', classPackage: classPackage, className: mainControllerName
                            }
                            'dao'{
                                "${daoName}.java" template: '/templates/java/dao/java-dao.tpl', classPackage: classPackage, className: daoName, domainName1: domainName1
                            }
                            'domain'{
                                "${domainName1}.java" template: '/templates/java/domain/java-domain1.tpl', classPackage: classPackage, className: domainName1, domainName2: domainName2
                                "${domainName2}.java" template: '/templates/java/domain/java-domain2.tpl', classPackage: classPackage, className: domainName2, domainName1: domainName1
                            }
                            'dto'{
                                "${dtoName}.java" template: '/templates/java/dto/java-dto.tpl', classPackage: classPackage, className: dtoName
                            }
                            'service'{
                                "${serviceName}.java" template: '/templates/java/service/java-service.tpl', classPackage: classPackage, className: serviceName, domainName1: domainName1, daoName: daoName
                            }
                            'util'{
                                'ApplicationSettings.java' template: '/templates/java/util/java-application-setting.tpl', classPackage: classPackage, projectName: projectName
                                'DependencyHealthIndicator.java' template: '/templates/java/util/java-health-checker.tpl', classPackage: classPackage
                            }
                        }
                    }
                    'resources' {
                        'application.properties' template: '/templates/resources/application-properties.tpl', projectName: projectName
                    }
                }
                'test' {
                    'java' {
                        "$classPackageDir"{
                            "${defaultClassEntryName}Test.java" template: '/templates/java/java-class.tpl', classPackage: classPackage, className: defaultClassEntryName
                            'controller'{
                                'MainControllerTest.java' template: '/templates/java/controller/java-main-controller-test.tpl', classPackage: classPackage
                            }
                            'service'{
                                "ServiceTest.java" template: '/templates/java/service/java-service-test.tpl', classPackage: classPackage, serviceName: serviceName
                            }
                            'SmokeTest.java' template: '/templates/java/java-smoke-test.tpl', classPackage: classPackage, mainControllerName: mainControllerName
                            'ApplicationTest.java' template: '/templates/java/java-application-test.tpl', classPackage: classPackage
                        }
                    }
                    'resources' {
                    }
                }
            }
            '.gitignore' template: '/templates/java/git-ignore.tpl'
            'Dockerfile' template: '/templates/java/docker-file.tpl', projectName: projectName
            'build.gradle' template: '/templates/java/build-gradle.tpl', projectName: projectName
            'README.MD' template: '/templates/java/readme-md.tpl'
        }
    }
}
