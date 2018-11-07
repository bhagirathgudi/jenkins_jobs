job('example-job-from-jobb-dsl-2') {
    scm{
        github('bhagirathgudi/jenkins_jobs', 'master')
    }



    triggers {
        cron("@hourly")
    }

    steps {
        shell("echo 'Hello World'")
    }
}