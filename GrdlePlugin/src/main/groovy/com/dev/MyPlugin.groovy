package com.dev

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.getTasks().create("readVersion") {
            logger.quiet("Reading the version file")
            description = "only for test"
            group = 'MyPlugin'

            doLast {
                logger.quiet "dfjdaljfdlka"
            }
        }
    }
}