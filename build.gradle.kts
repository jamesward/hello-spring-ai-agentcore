plugins {
    id("com.skillsjars.gradle-plugin") version "0.1.4"
    java
    id("org.springframework.boot") version "4.1.1"
    id("io.spring.dependency-management") version "1.1.7"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

dependencies {
    implementation(platform("org.springframework.ai:spring-ai-bom:2.0.1"))
    implementation(platform("org.springaicommunity:spring-ai-agentcore-bom:2.2.0"))
    implementation("org.springframework.ai:spring-ai-starter-model-bedrock-converse")
    implementation("org.springaicommunity:spring-ai-agentcore-runtime-starter")
}

// Agent Skills, extracted with ./gradlew extractSkillsJars
dependencies {
    skill("com.jamesward:skills:0.0.10")
}

skillsjars {
    outputDir.set(layout.projectDirectory.dir(".kiro/skills"))
}
