import dependenices.Deps
import dependenices.Versions

plugins {
    id("com.android.library")
    kotlin("android")
    id("jacoco")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)
    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.compileSdk)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
        }
        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
        }
    }
    lintOptions { isAbortOnError = false }
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar"))))
    implementation(project(":ext"))

    implementation(Deps.Global.kotlin)

    implementation(Deps.Widget.appcompat)
    implementation(Deps.Widget.quickDialog)
    implementation(Deps.Widget.constraintLayout)
}

tasks.withType<Test> {
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
    }
}
tasks.withType<JacocoReport> {
    setDependsOn(listOf("testDebugUnitTest", "createDebugCoverageReport"))
    reports.apply {
        xml.isEnabled = true
        html.isEnabled = true
        html.destination = file("${project.buildDir}/jacocoHtml")
    }
    val fileFilter = listOf("**/R.class",
                            "**/R$*.class",
                            "**/BuildConfig.*",
                            "**/Manifest*.*",
                            "**/*Test*.*",
                            "android/**/*.*")
    val debugTree = fileTree(mapOf("dir" to "$project.buildDir/tmp/kotlin-classes/debug",
                                   "excludes" to fileFilter))
    val mainSrc = "$project.projectDir/src/main/kotlin"

    sourceDirectories = files(listOf(mainSrc))
    classDirectories = files(listOf(debugTree))
    executionData = fileTree(mapOf("dir" to project.buildDir,
                                   "includes" to listOf("jacoco/testDebugUnitTest.exec",
                                                        "outputs/code-coverage/connected/*coverage.ec")))
}

repositories {
    mavenCentral()
}
