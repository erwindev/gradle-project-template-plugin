package com.erwin.template

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.gradle.testkit.runner.TaskOutcome.SUCCESS

class TemplatePluginTest {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    private File build_gradle

    @Before
    public void setup(){
        build_gradle = testProjectDir.newFile("build.gradle")
        build_gradle << 'plugins {id "com.erwin.template.TemplatePlugin"}\n'
    }

    private BuildResult gradle(boolean isSuccessExpected, String[] arguments = ['tasks']) {
        arguments += '--stacktrace'
        def runner = GradleRunner.create()
                .withArguments(arguments)
                .withProjectDir(testProjectDir.root)
                .withPluginClasspath()
                .withDebug(true)
        return isSuccessExpected ? runner.build() : runner.buildAndFail()
    }

    private BuildResult gradle(String[] arguments = ['tasks']) {
        gradle(true, arguments)
    }

    @Test
    public void starterProject(){
        def result = gradle("initJavaProject")
        assert result.task(":initJavaProject").outcome == SUCCESS
    }
}
