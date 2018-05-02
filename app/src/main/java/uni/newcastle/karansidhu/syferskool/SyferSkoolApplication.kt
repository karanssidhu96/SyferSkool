package uni.newcastle.karansidhu.syferskool

import android.app.Application
import org.koin.android.ext.android.startKoin

/**
 * Created by Karan Sidhu on 30/04/2018.
 */

class SyferSkoolApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(DependencyInjector.appModule))
    }
}