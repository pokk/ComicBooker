/*
 * Copyright (C) 2018 The Smash Ks Open Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.no1.taiwan.comicbooker.internal.di.dependency

import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * To provide the necessary usecase objects for the specific activities or fragments.
 */
object UsecaseModule {
    fun usecaseProvider() = Module("Use Cases Module") {
        //region For Fragments
        //region Fake
        bind<TestUsecase>() with singleton {
            TestUsecase(instance())
        }
        //endregion
        //endregion
    }
}
