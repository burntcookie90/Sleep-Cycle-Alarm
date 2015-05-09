package io.dwak.sleepycyclealarm.options

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import io.dwak.mvp_base.MvpFragment
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepycyclealarm.adapter
import io.dwak.sleepycyclealarm.layoutManager
import io.dwak.sleepycyclealarm.model.Option
import io.dwak.sleepycyclealarm.view.OptionsView
import kotlin.properties.Delegates

class OptionsFragment : MvpFragment<OptionsPresenterImpl>(), OptionsView {
    val recyclerView : RecyclerView by bindView(R.id.recycler_view)
    var adapter : OptionsAdapter by Delegates.notNull()
    var interactionListener : OptionsFragmentInteractionListener? = null

    public companion object {
        public fun newInstance() : Fragment = OptionsFragment()
    }

    override val presenterClass : Class<OptionsPresenterImpl> = javaClass()

    override fun setView() {
        presenter.view = this
    }

    override fun onAttach(activity : Activity?) {
        super<MvpFragment>.onAttach(activity)
        if(getActivity() is OptionsFragmentInteractionListener)
            interactionListener = getActivity() as OptionsFragmentInteractionListener
        else
            throw RuntimeException("${getActivity().javaClass.getSimpleName()} must implement OptionsFragmentInteractionListener")
    }

    override fun onCreateView(inflater : LayoutInflater?, container : ViewGroup?, savedInstanceState : Bundle?) : View? {
        return inflater?.inflate(R.layout.fragment_options, container, false)
    }

    override fun onViewCreated(view : View?, savedInstanceState : Bundle?) {
        super<MvpFragment>.onViewCreated(view, savedInstanceState)

        adapter = OptionsAdapter(getActivity(), object: OptionsAdapter.OptionsAdapterListener {
            override fun onOptionItemSelected(position : Int) = interactionListener?.onOptionSelected(adapter.optionList.get(position))
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(getActivity())
        presenter.getOptions()
    }

    override fun onDetach() {
        super<MvpFragment>.onDetach()
        interactionListener = null
    }

    override fun showOptions(options : List<Option>) {
        options.forEach { adapter.addOption(it) }
    }

    public trait OptionsFragmentInteractionListener {
        fun onOptionSelected(option : Option)
    }
}