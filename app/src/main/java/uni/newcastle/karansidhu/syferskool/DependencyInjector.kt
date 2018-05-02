package uni.newcastle.karansidhu.syferskool

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by Karan Sidhu on 30/04/2018.
 */
object DependencyInjector
{
    val appModule : Module = applicationContext {
        viewModel { CustomViewModel() }
    }
}