package com.atom.android.lebo

import android.app.Application
import com.atom.android.lebo.data.di.apiModule
import com.atom.android.lebo.data.di.dataSourceModule
import com.atom.android.lebo.data.di.databaseModule
import com.atom.android.lebo.data.di.repositoryModule
import com.atom.android.lebo.data.di.sharedPreferencesModule
import com.atom.android.lebo.data.di.networkModule
import com.atom.android.lebo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LeBoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LeBoApplication)
            modules(
                networkModule,
                sharedPreferencesModule,
                apiModule,
                dataSourceModule,
                repositoryModule,
                viewModelModule,
                databaseModule
            )
        }
    }
}
