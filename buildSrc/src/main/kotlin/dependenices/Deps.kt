package dependenices

/**
 * Central control the dependency libraries. All dependency paths and versions here.
 */
object Deps {
    //region Global
    /**
     * The necessary libs for all modules.
     */
    object Global {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlinLib}"
        const val refelect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.Kotlin.kotlinLib}"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.kotlinCoroutine}"
        const val coroutinesRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.Kotlin.kotlinCoroutine}"

        const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.RxDep.rxJava2}"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.RxDep.rxKotlin2}"

        const val shaver = "com.devrapid.jieyi:kotlinshaver:${Versions.KotlinAndroidExt.shaver}"

        const val kodeinAndroid = "org.kodein.di:kodein-di-framework-android:${Versions.DI.kodein}"
        const val kodeinAndroidX = "org.kodein.di:kodein-di-framework-android-x:${Versions.DI.kodein}"
        const val kodeinJVM = "org.kodein.di:kodein-di-generic-jvm:${Versions.DI.kodein}"

        const val gson = "com.google.code.gson:gson:${Versions.Parser.gson}"
        const val jsoup = "org.jsoup:jsoup:${Versions.Parser.jsoup}"
    }

    /**
     * The necessary unit test libs for all modules.
     */
    object GlobalTest {
        const val junit = "junit:junit:${Versions.Test.jUnit}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.Kotlin.kotlinLib}"
        const val mockito = "com.nhaarman:mockito-kotlin:${Versions.Test.mockitoKotlin}"
        const val assertj = "org.assertj:assertj-core:${Versions.Test.assertJ}"
        const val powerMockJunit = "org.powermock:powermock-module-junit4:${Versions.Test.powerMockito}"
        const val powerMockito = "org.powermock:powermock-api-mockito2:${Versions.Test.powerMockito}"
        const val byteBuddy = "net.bytebuddy:byte-buddy:${Versions.Test.byteBuddy}"
        const val byteBuddyAgent = "net.bytebuddy:byte-buddy-agent:${Versions.Test.byteBuddy}"
        const val byteBuddyAndroid = "net.bytebuddy:byte-buddy-android:${Versions.Test.byteBuddy}"
    }

    /**
     * The necessary debug libs for all modules.
     */
    object GlobalDebug {
        const val database = "com.amitshekhar.android:debug-db:${Versions.Database.debug}"
    }
    //endregion

    //region Presentation
    /**
     * The necessary libs only for presentation layer.
     */
    object Presentation {
        const val dexTool = "androidx.multidex:multidex:${Versions.KotlinAndroidExt.dex}"
        const val anko = "org.jetbrains.anko:anko-commons:${Versions.KotlinAndroidExt.anko}"
        const val ankoSdk25 = "org.jetbrains.anko:anko-sdk25:${Versions.KotlinAndroidExt.anko}"
        const val ankoV7 = "org.jetbrains.anko:anko-appcompat-v7:${Versions.KotlinAndroidExt.anko}"
        const val ankoCoroutine = "org.jetbrains.anko:anko-sdk25-coroutines:${Versions.KotlinAndroidExt.anko}"
        const val ankoV7Coroutine = "org.jetbrains.anko:anko-appcompat-v7-coroutines:${Versions.KotlinAndroidExt.anko}"
        const val ktx = "androidx.core:core-ktx:${Versions.KotlinAndroidExt.ktx}"
        const val knifer = "com.devrapid.jieyi:kotlinknifer:${Versions.KotlinAndroidExt.kinfer}"
        const val androidCoroutine =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.kotlinCoroutine}"

        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.KotlinAndroidExt.aacLifecycle}"

        const val rxBus = "com.hwangjr.rxbus:rxbus:${Versions.RxDep.rxBus}"
        const val rxPermission = "com.tbruyelle.rxpermissions2:rxpermissions:${Versions.RxDep.rxPermission2}"

        const val retrofit2 = Data.retrofit2
        const val retrofit2Gson = Data.retrofit2ConverterGson
        const val retrofit2Courtine = Data.retrofit2AdapterCoroutine
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.Network.okhttp3}"

        const val glide = "com.github.bumptech.glide:glide:${Versions.Network.glide}"

        const val firebaseCore = "com.google.firebase:firebase-core:${Versions.Firebase.core}"
        const val firebaseDB = "com.google.firebase:firebase-database:${Versions.Firebase.database}"
        const val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.Firebase.auth}"
        const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Versions.Firebase.messaging}"
        const val firebaseVision = "com.google.firebase:firebase-ml-vision:${Versions.Firebase.mlVision}"
        const val firebaseMLImageLabel =
            "com.google.firebase:firebase-ml-vision-image-label-model:${Versions.Firebase.mlImageLabel}"

        const val dbflow = Data.dbflow
        const val dbflowRxJava2KotlinExt = Data.dbflowRxJava2

        const val cloudinary = "com.cloudinary:cloudinary-android:${Versions.CloudStore.cloudinary}"

        const val modelMapper = Data.mapper

        const val arv = "com.devrapid.jieyi:adaptiverecyclerview:${Versions.ViewComponent.adaptiveRecyclerView}"

        const val quickDialog = "com.devrapid.jieyi:dialogbuilder:${Versions.Ui.dialog}"
        const val loading = "com.github.castorflex.smoothprogressbar:library-circular:${Versions.Ui.loading}"
        const val materialChip = "com.github.pchmn:MaterialChipsInput:${Versions.Ui.materialChip}"
        const val cameraView = "com.otaliastudios:cameraview:${Versions.Ui.cameraView}"

        const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidComponent.androidx}"
        const val materialDessign = "com.google.android.material:material:${Versions.AndroidComponent.androidx}"
        const val annot = "androidx.annotation:annotation:${Versions.AndroidComponent.androidx}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.AndroidComponent.androidx}"
        const val cardview = "androidx.cardview:cardview:${Versions.AndroidComponent.cardview}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidComponent.constraintLayout}"
        const val coordinatorLayout =
            "androidx.coordinatorlayout:coordinatorlayout:${Versions.AndroidComponent.coordinatorLayout}"
        const val navigationUi =
            "android.arch.navigation:navigation-fragment-ktx:${Versions.AndroidComponent.navigation}"
        const val navigationFragment =
            "android.arch.navigation:navigation-ui-ktx:${Versions.AndroidComponent.navigation}"
    }

    /**
     * The necessary unit test libs only for the presentation layer.
     */
    object PresentationTest {
        const val espressoHelper = "com.github.Zhuinden:espresso-helper:${Versions.Test.espressoHelper}"
        const val robolectric = "org.robolectric:robolectric:${Versions.Test.robolectric}"
        const val mockito = "org.mockito:mockito-android:${Versions.Test.mockitoAndroid}"
        const val mockkAndroid = "io.mockk:mockk-android:${Versions.Test.mockk}"
        const val kakao = "com.agoda.kakao:kakao:${Versions.Test.kakao}"
    }
    //endregion

    //region Domain
    /**
     * The necessary libs only for the domain layer.
     */
    object Domain

    /**
     * The necessary unit test libs only for the domain layer.
     */
    object DomainTest
    //endregion

    //region Data
    /**
     * The necessary libs only for the data layer.
     */
    object Data {
        // Internet
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.Network.retrofit2}"
        const val retrofit2ConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.Network.retrofit2}"
        const val retrofit2AdapterCoroutine =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:${Versions.Network.adapterCoroutine}"
        // Mapper
        const val mapper = "org.modelmapper:modelmapper:${Versions.Mapping.modelmapper}"
        // Database
        const val dbflowProcessor = "com.github.Raizlabs.DBFlow:dbflow-processor:${Versions.Database.dbflow}"
        const val dbflowCore = "com.github.Raizlabs.DBFlow:dbflow-core:${Versions.Database.dbflow}"
        const val dbflow = "com.github.Raizlabs.DBFlow:dbflow:${Versions.Database.dbflow}"
        const val dbflowKotlinExt = "com.github.Raizlabs.DBFlow:dbflow-kotlinextensions:${Versions.Database.dbflow}"
        const val dbflowRxJava2 = "com.github.Raizlabs.DBFlow:dbflow-rx2:${Versions.Database.dbflow}"
        const val dbflowRxJava2KotlinExt =
            "com.github.Raizlabs.DBFlow:dbflow-rx2-kotlinextensions:${Versions.Database.dbflow}"
        // sql-cipher database encryption (optional)
        const val dbflowSqlEncrypt = "com.github.Raizlabs.DBFlow:dbflow-sqlcipher:${Versions.Database.dbflow}"
        const val dbflowSqlCipher = "net.zetetic:android-database-sqlcipher:${Versions.Database.dbflow}@aar"

        const val firebaseDB = Presentation.firebaseDB
        const val firebaseVision = Presentation.firebaseVision
        const val firebaseMLImageLabel = Presentation.firebaseMLImageLabel
        // Cloudinary
        const val cloudinary = Presentation.cloudinary

        const val appcompat = Presentation.appcompat
    }

    /**
     * The necessary unit test libs only for the data layer.
     */
    object DataTest {
        const val robolectric = PresentationTest.robolectric
    }
    //endregion

    //region Ext
    /**
     * The necessary libs only for the widget module.
     */
    object Widget {
        const val arv = "com.devrapid.jieyi:adaptiverecyclerview:${Versions.ViewComponent.adaptiveRecyclerView}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.AndroidComponent.androidx}"
    }

    /**
     * The necessary unit test libs only for the widget module.
     */
    object WidgetTest
    //endregion

    //region Ext
    /**
     * The necessary libs only for the extension module.
     */
    object Ext

    /**
     * The necessary unit test libs only for the extension module.
     */
    object ExtTest
    //endregion
}
