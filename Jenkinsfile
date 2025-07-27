pipeline {
  agent any
  triggers {
    pollSCM('H/10 * * * *') // 每分钟检查是否有代码更新
  }
  environment {
    MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    APP_REPO = "https://github.com/zy2d/simple-java-maven-app"
    ARTIFACT_DIR = "target"
  }

  tools {
    maven 'mvn.3.9.11' // Jenkins全局工具配置中的 Maven 名称
    jdk 'jdk21'        // Jenkins全局工具配置中的 JDK 名称
  }

  stages {
    stage('Checkout') {
      steps {
        echo "📥 拉取代码：${APP_REPO}"
        git "${APP_REPO}"
      }
    }

    stage('Build') {
      steps {
        echo "🔨 构建中..."
        sh 'mvn clean install -B'
      }
    }

    stage('Test') {
      steps {
        echo "🧪 运行测试..."
        sh 'mvn test'
      }
    }

    stage('Package & Rename') {
      steps {
        script {
          echo "📦 打包构建产物..."
          sh 'mvn package'

          // 获取 Git 短ID
          def shortCommit = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
          
          // 构造带版本的 jar 文件名
          env.ARTIFACT_NAME = "my-app-v${shortCommit}.jar"
          def originalJar = "${ARTIFACT_DIR}/my-app-1.0-SNAPSHOT.jar"
          def renamedJar = "${ARTIFACT_DIR}/${env.ARTIFACT_NAME}"

          // 重命名 jar
          sh "mv ${originalJar} ${renamedJar}"
        }
      }
    }

    stage('Archive Artifacts') {
      steps {
        echo "📁 归档产物供后续使用：${ARTIFACT_NAME}"
        archiveArtifacts artifacts: "${ARTIFACT_DIR}/${ARTIFACT_NAME}", fingerprint: true
      }
    }
  }

  post {
    success {
      echo '✅ Build pipeline 成功完成！'
    }
    failure {
      echo '❌ 构建失败，请检查日志。'
    }
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}
