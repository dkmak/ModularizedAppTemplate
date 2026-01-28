package com.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
@Bind should use a abstract class, not an interface.
 Because it is just an instruction to the compiler, it's flexible
 */
@Module
@InstallIn(SingletonComponent::class) // creates a single reference that will be injected throughout the lifetime(?) of the application
internal abstract class DataModule { }
