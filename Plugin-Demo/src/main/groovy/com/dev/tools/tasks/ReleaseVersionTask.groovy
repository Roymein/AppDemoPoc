package com.dev.tools.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 * custom task:
 * @Optional : in gradle second lifecycle of config,  @input may be null, this annotation allow @Input is null
 *
 * @Input task input
 * @OutputFile task output file
 */
class ReleaseVersionTask extends DefaultTask {

    @Input
    @Optional
    Boolean release

    @OutputFile
    File destFile

    ReleaseVersionTask() {
        group = ''
        description = ''
    }

    @TaskAction
    void start() {
        project.version.release = true
    }
}