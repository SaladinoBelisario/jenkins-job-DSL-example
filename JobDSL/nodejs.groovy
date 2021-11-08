job('NodeJS example') {
    scm {
        git('git://github.com/SaladinoBelisario/jenkins_node_app_example.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@mydomain.dev')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('Node_17') // this is the name of the NodeJS installation in
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
