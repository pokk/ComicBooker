package com.no1.taiwan.comicbooker.bases

import android.os.Bundle
import androidx.annotation.UiThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.devrapid.kotlinshaver.cast
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_INT
import com.no1.taiwan.comicbooker.ext.const.isDefault
import com.no1.taiwan.comicbooker.ext.hideLoadingView
import com.no1.taiwan.comicbooker.ext.hideRetryView
import com.no1.taiwan.comicbooker.ext.showErrorView
import com.no1.taiwan.comicbooker.ext.showLoadingView
import com.no1.taiwan.comicbooker.ext.showRetryView
import org.kodein.di.generic.instance
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * The basic fragment is in MVVM architecture which prepares all necessary variables or functions.
 */
abstract class AdvFragment<out A : BaseActivity, out VM : ViewModel> : BaseFragment<A>(), LoadView {
    protected open val genericVMIndex = DEFAULT_INT
    protected val vmProviders get() = ViewModelProviders.of(this, viewModelFactory)
    /** Add the AAC [ViewModel] for each fragments. */
    @Suppress("UNCHECKED_CAST")
    protected val vm
        get() = vmCreateMethod.invoke(vmProviders, vmConcreteClass) as? VM ?: throw ClassCastException()
    private val viewModelFactory by instance<ViewModelProvider.Factory>()
    /** [VM] is the first (index: 1) in the generic declare. */
    private val vmConcreteClass: Class<*>
        get() {
            // Get the all generic data types.
            val actualTypeArguments =
                cast<ParameterizedType>(recursiveFindGenericSuperClass(this::class.java)).actualTypeArguments

            // If we don't set viewmodel index by ourselves, it can find the first generic viewmodel.
            val viewmodelClass = if (genericVMIndex.isDefault())
            // Recursively find the first generic viewmodel data type.
                actualTypeArguments.firstOrNull { checkAllSuperClass(cast(it), ViewModel::class.java) }
            else
            // Customize index.
                actualTypeArguments[genericVMIndex]

            return cast(viewmodelClass)
        }
    /** The [ViewModelProviders.of] function for obtaining a [ViewModel]. */
    private val vmCreateMethod get() = vmProviders.javaClass.getMethod("get", vmConcreteClass.superclass.javaClass)

    //region Fragment's lifecycle.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindLiveData()
    }

    override fun onDetach() {
        super.onDetach()
        unbindLiveData()
    }
    //endregion

    //region View Implementation for the Presenter.
    @UiThread
    override fun showLoading() = requireActivity().showLoadingView()

    @UiThread
    override fun hideLoading() = requireActivity().hideLoadingView()

    @UiThread
    override fun showRetry() = requireActivity().showRetryView()

    @UiThread
    override fun hideRetry() = requireActivity().hideRetryView()

    @UiThread
    override fun showError(message: String) = requireActivity().showErrorView(message)
    //endregion

    /** The block of binding to [androidx.lifecycle.ViewModel]'s [androidx.lifecycle.LiveData]. */
    @UiThread
    protected open fun bindLiveData() = Unit

    /** The block of unbinding from [androidx.lifecycle.ViewModel]'s [androidx.lifecycle.LiveData]. */
    @UiThread
    protected open fun unbindLiveData() = Unit

    private fun recursiveFindGenericSuperClass(superclass: Class<*>): Type =
        if (superclass.genericSuperclass is ParameterizedType)
            requireNotNull(superclass.genericSuperclass)
        else
            recursiveFindGenericSuperClass(requireNotNull(superclass.superclass))

    private fun checkAllSuperClass(objClass: Class<*>, assignable: Class<*>): Boolean {
        objClass.superclass?.takeUnless { it.isAssignableFrom(java.lang.Object::class.java) }?.let {
            return if (it.isAssignableFrom(assignable))
                true
            else
                checkAllSuperClass(it, assignable)
        } ?: return false
    }
}
