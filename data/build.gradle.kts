import com.android.build.gradle.internal.tasks.JacocoTask
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import dependenices.Deps
import dependenices.Versions
import java.net.NetworkInterface

plugins {
    id("com.android.application")
    id("kotlin-android-extensions")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.compileSdk)
        versionCode = 1
        versionName = "1.0"
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
            buildConfigField("String", "URL_SERVER", "\"http://${getLocalIp("en0")}:3000\"")
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
    implementation(project(":domain"))
    implementation(project(":ext"))

    implementation(Deps.Global.kotlin)
    implementation(Deps.Global.coroutine)
    implementation(Deps.Global.shaver)
    implementation(Deps.Global.gson)

    kapt(Deps.Data.roomAnnotation)
    implementation(Deps.Data.room)

    //region Internet & Image loading
    implementation(Deps.Data.retrofit2)
    implementation(Deps.Data.retrofit2AdapterCoroutine) {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-core")
    }
    //endregion
}

//tasks.withType<Test> {
//    configure<JacocoTaskExtension> {
//        isIncludeNoLocationClasses = true
//    }
//}
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
    executionData =
        fileTree(mapOf("dir" to project.buildDir,
                       "includes" to listOf("jacoco/testDebugUnitTest.exec",
                                            "outputs/code-coverage/connected/*coverage.ec")))
}

// Get the ip address by interface name
// en0 is WIFI interface
fun getLocalIp(interfaceName: String) = NetworkInterface.getByName(interfaceName)
    ?.interfaceAddresses
    ?.find { it.address.hostAddress.length <= 15 }
    ?.address
    ?.hostAddress
    .orEmpty()
